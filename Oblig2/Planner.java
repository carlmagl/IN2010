import java.io.File;
import java.util.*;

class Planner {

    private ArrayList<Task> tasks, visited, firstStart;
    private ArrayList<Task> zeroDep = new ArrayList<>();
    private ArrayList<Task> doing = new ArrayList<>();
    private ArrayList<Task> done = new ArrayList<>();
    private int count = 0;
    private int timeCounter;
    private static boolean foundCycle = false;

    Planner(String filnavn) throws Exception {
        tasks = new ArrayList<Task>();
        visited = new ArrayList<Task>();
        firstStart = new ArrayList<Task>();
        timeCounter = 0;
        readFile(filnavn);
        //makeDependencies();
        findCycle();
        beginTasks();
        setLatestStartAndSlack();
        printAllAfterRun();
    }

    private void readFile(String filnavn) throws Exception {
        Scanner scanner = new Scanner(new File(filnavn));
        scanner.nextLine();
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String[] info = scanner.nextLine().split("\\s+");
            if (info.length > 1) {
                Task newTask = getTask(Integer.parseInt(info[0]));
                newTask.setTask(info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]));
                ArrayList<Task> temp = new ArrayList<Task>();
                for (int i = 4; i < info.length; i++) {
                    if(Integer.parseInt(info[i]) != 0){
                        newTask.addDependentTask(getTask(Integer.parseInt(info[i])));
                    }
                }
                newTask.setCntPredecessors(temp.size());
                tasks.add(newTask);
                newTask.printTask();
            }
        }
        firstStart = getAllTasksWithZero(0);
    }

    private void beginTasks() {
        boolean someThingChanged = false;
        ArrayList<Task> started = new ArrayList<>();
        ArrayList<Task> doneTasks = new ArrayList<>();
        int currStaff = 0;

        while (existsUndoneTask()) {
            for (int i = doing.size() - 1; i >= 0; i--) {
                if ((doing.get(i).getEarliestStart() + doing.get(i).getTime()) == timeCounter) {
                    doneTasks.add(doing.get(i));
                    done.add(doing.get(i));
                    currStaff -= doing.get(i).getStaff();
                    doing.get(i).removePredOnOutEdges(); // -- on all cntPred for the Tasks in outedge
                    doing.remove(i);
                    someThingChanged = true;
                }
            }

            zeroDep = getAllTasksWithZero(timeCounter);
            for (Task start : zeroDep) {
                if (start == null) {
                    break;
                }
                doing.add(start);
                started.add(start);
                currStaff += start.getStaff();
                removeTask(start.getId());
                someThingChanged = true;
            }
            zeroDep.clear();
            if (someThingChanged) {
                System.out.println("---------------------------------");
                System.out.println("Time:          " + timeCounter);
                if (!doneTasks.isEmpty()) {
                    for (Task done : doneTasks) {
                        System.out.println("Finished:      " + done.getId());
                    }
                }
                if (!started.isEmpty()) {
                    for (Task begun : started) {
                        System.out.println("Started:       " + begun.getId());
                    }
                }
                System.out.println("Manpower:      " + currStaff);
                started.clear();
                doneTasks.clear();
                someThingChanged = false;
                System.out.println();
            }
            timeCounter++;
        }
        timeCounter--;
        System.out.println("Done!");
    }

    private ArrayList<Task> getAllTasksWithZero(int starttime) {
        ArrayList<Task> tasksWithZero = new ArrayList<>();
        for (Task task : tasks) {
            if (task != null && task.getPredecessors() == 0) {
                tasksWithZero.add(task);
                task.setEarliestStart(starttime);
            }
        }
        return tasksWithZero;
    }

    private void setLatestStartAndSlack() { 
        int lowestNumber = -1;
        int temp;
        for (Task task : firstStart) {
            temp = task.getLatest(timeCounter);
            if (lowestNumber == -1) {
                lowestNumber = temp;
            }
            if (temp < lowestNumber) {
                lowestNumber = temp;
            }
        }
        System.out.println("Critical tasks:");
        for (Task curTask : done) {
            if ((curTask.getLatestStart() - curTask.getEarliestStart()) == 0) {
                System.out.println(curTask.getId());
            }
        }
    }

    private void printAllAfterRun() {
        for (Task task : done) {
            System.out.println("-------------------------------");
            System.out.println("ID: " + task.getId());
            System.out.println("Name: " + task.getName());
            System.out.println("Time: " + task.getTime());
            System.out.println("Manpower: " + task.getStaff());
            System.out.println("OutEdges: ");
            for (Task parents : task.getOutEdges()) {
                System.out.println("ID: " + parents.getId());
            }
            System.out.println("Earliest start:  " + task.getEarliestStart());
            System.out.println("Latest   start:  " + task.getLatestStart());
            System.out.println("Slack :          " + (task.getLatestStart() - task.getEarliestStart()));
            System.out.println();
        }
    }

    private void printCycle(ArrayList<Task> task) {
        int lastId = task.get(task.size() - 1).getId();
        boolean from = false;
        System.out.println("There is a cycle, and here it is:");
        for (Task i : task) {
            if (from) {
                System.out.println(i.getId());
            } else if (i.getId() == lastId) {
                System.out.println(i.getId());
                from = true;
            }
        }
    }

    private boolean cycle(ArrayList<Task> seen, Task k) {
        if (seen.contains(k)) {
            return true;
        }
        ArrayList<Task> send = new ArrayList<>();
        send.addAll(seen);
        send.add(k);
        for (Task x : k.getOutEdges()) {
            if (cycle(send, x)) {
                if (!foundCycle) {
                    foundCycle = true;
                    send.add(x);
                    printCycle(send);
                }
                return true;
            }
        }
        return false;
    }

    private boolean findCycle() {
        ArrayList<Task> kk = new ArrayList<>();
        for (Task k : firstStart) {
            if (cycle(kk, k)) {
                return true;
            }
        }
        return false;
    }

    /*
     * private Task getTask(int id) { if (tasks[id - 1] == null) { Task temp = new
     * Task(id); tasks[id - 1] = temp; return temp; } return tasks[id - 1]; }
     */

    private boolean existsUndoneTask() {
        for (Task t : tasks) {
            if (t != null) {
                return true;
            }
        }
        for (Task k : doing) {
            if (k != null) {
                return true;
            }
        }
        return false;
    }

    private void removeTask(int taskId) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i) != null) {
                if (tasks.get(i).getId() == taskId) {
                    tasks.remove(i);
                }
            }
        }
    }
    private Task getTask(int id){
        if(!tasks.contains(new Task(id))){
            Task temp = new Task(id);
            tasks.add(id, temp);
            return temp;
        }
        return tasks.get(id);
    }
}