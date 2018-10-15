import java.util.*;

class Task {
    private int id, time, staff;
    private String name;
    private int earliestStart, latestStart;
    private ArrayList<Task> outEdges;
    private int cntPredecessors;

    Task(int id){
        this.id = id;
    }
    

    Task(int id, String name, int time, int staff) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.staff = staff;
    }
    public void printTask(){
        System.out.println(id);
        System.out.println(name);
        System.out.println(time);
        System.out.println(staff);
    }

    public void setTask(String name, int time, int staff){
        this.name = name;
        this.time = time;
        this.staff = staff;
    }
    public void addDependentTask(Task task){
        outEdges.add(task);
    }

    public void setCntPredecessors(int cntPredecessors) {
        this.cntPredecessors = cntPredecessors;
    }

    public void setEarliestStart(int earliestStart){
        this.earliestStart = earliestStart;
    }

    public ArrayList<Task> getOutEdges() {
        return outEdges;
    }

    public String toString() {
        return null;
    }

    public int getTime() {
        return id;
    }

    public int getStaff() {
        return staff;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPredecessors(){
        return cntPredecessors;
    }

    public int getEarliestStart(){
        return earliestStart;
    }
    public int getLatestStart(){
        return earliestStart;
    }
    public void removePredOnOutEdges(){
        for(Task task: outEdges){
            task.cntPredecessors--;
        }
    }
    public int getLatest(int totalTime){ //går inn i barnene og spør om latestStart, hvis den ikke har barn, setter man det til timeCount-time
        int latest = -1;
        int temp;
        if(latestStart != -1){
            return latestStart;
        }
        if(outEdges.isEmpty()){
            latestStart = (totalTime - time);
            return latestStart;
        }else{
            for(Task tmp : outEdges){
                if(latest == -1){
                    latest = tmp.getLatest(totalTime);
                }else{
                    temp = tmp.getLatest(totalTime);
                    if(temp < latest){
                        latest = temp;
                    }
                }
            }
        }
        latestStart = (latest - time);
        return latestStart;
    }
}