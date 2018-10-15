import java.io.File;
import java.util.*;

class Planner {

    private ArrayList<Task> tasks, visited;

    planner(String filNavn){
        tasks = new Arraylist<Task>();
        visited = new ArrayList<Task>();
        readFile(filnavn);
        setDependencies();
        checkForCycles();
    }

    private void readFile(String filnavn) throws Exception {
        Scanner scanner = new Scanner(new File(filnavn));
        while (scanner.hasNextLine()) {
            String[] info = scanner.nextLine().split(" ");
            Task newTask = new Task(info[0], info[1], info[2], info[3]);
            List<String> temp;
            for (int i = 4; i < info.length; i++) {
                temp.add(info[i]);
            }
            newTask.setOe(temp);
            tasks.add(newTask);
        }
    }

    private void makeDependencies(ArrayList<Task> taskList) {
		// find first Task and set it

		//add into this graph holding map, could have used a bag or some heap structure.
		// this is set in the graph id start at 1 index at 0.

		for (Task t: taskList){
			if (t.getPredecessors()==null) {
				head=t;
			}
		}

		makeDependencies(head,taskList); //go recursive
	}

	int i = 0; // yah, global param woot woot.
	/**
	 * recursive method to find all edges. and calling cycle check
	 * @param current
	 * @param notEvalTaskList
	 */
	private void makeDependencies(Task current,ArrayList<Task> notEvalTaskList){
		//some mandatory tacky code
		if (current.getPredecessors()==null){
			viewGraph.put(head.getId(), head);
			notEvalTaskList.remove(head);

		}

		for (Task t: notEvalTaskList){
			if (t.getPredecessors().contains(current.getId())){

				current.outEdge.add(t);
				//currId=t.getId();
				viewGraph.put(t.getId(), t);

				//System.out.println(t.getName() + " -> " + current.getName() + " t get preds "  + t.getPredecessors());
			}
		}
		notEvalTaskList.remove(current);

		//for (Task m: current.outEdge) System.out.println(m.getName()); //debug
		if (notEvalTaskList.isEmpty()){
			System.out.println("Going to find cycles");

			try {
				if (!cycleChecker(head)){
					System.out.println("No cycle detected\n Starting evaluation of nodes in Graph ");
					evaluateNodes();
				}
			} catch (CyclicGraphException e) {
				System.err.println(e.getMessage());
				System.exit(1); //error
			}
		} 
		for(Task task:current.outEdge){
			makeDependencies(task, notEvalTaskList);
		}


    }
    
    public void evaluateNodes(){
		evaluateNodes(head,0); //lets go recursive!
	}
	/**
	 * Recursively finding the largest time throughout the graph.
	 * By setting/reading the latest start of each node this will detect how long time each dependency will use. 
	 * 
	 * @param current
	 * @param time
	 */
	public void evaluateNodes(Task current, int time){
		setTimes(head);
		System.out.println("This Project contains: " + FileReader.numberofTasks + " tasks\nThese are: ");
		for (Task t: viewGraph.values()){
			System.out.println(t.getId()+ " : " +t.getName());
		}
		System.out.println("Dependencies: ");
		for (Task t: viewGraph.values()){
			for(Task deps: t.outEdge){
				System.out.println(deps.getName() + " is dependent on " + t.getName());
			}
		}
	}
	/**
	 * recursively setting latest/earliest starting time of each Task to be evaluated. 
	 * It is the lateste time tha t will define when the next dependent task is going to be evaluated.
	 * task1.lateststarttime+task1.time=next.starttime ... and so on.
	 * @param current
	 */
	public void setTimes(Task current){

	}
	/**
	 * Gets the slack of the 
	 * @param current 
	 * 				recursive, recursive
	 * @param prev
	 * 				previous task.
	 * @return int
	 * 			the slack is s earliest start - sum of latest start
	 */
	public int slack(Task current, Task prev){
		return 0;
		
	}


    private boolean checkForCycles(){
        for (Task task : tasks){
            if(task.getPredecessors() == 0){
                checkForCycles(task);
            }
        }
        return false;
    }

    private boolean checkForCycles(Task curTask) {
        if (visited.contains(curTask)) {
            String cycle;
            for (Task task : tasks) {
                System.out.println(task.getName);
            }
            return true;
        }
        visited.add(curTask);
        for (Task task : tasks) {
            System.out.println(task.getName());
            checkForCycles(task);
            System.out.println("The given graph shows no signs of a cycle");
        }
        return false;
    }
}