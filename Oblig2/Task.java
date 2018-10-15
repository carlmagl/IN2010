class Task {
    private int id, time, staff;
    private String name;
    private int earliestStart, latestStart;
    private ArrayList<Task> outEdges;
    private int cntPredecessors;

    Task(int id, String name, int time, int staff, List<Task> outEdges) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.staff = staff;
        this.outEdges = outEdges;
    }

    public void setOE(List<Task> outEdgesString) {
        this.outEdgesString = outEdgesString;
    }

    public List<String> returnOutEdges() {
        return outEdgesString;
    }

    public String toString() {
        return null;
    }

    public int returnTime() {
        return id;
    }

    public int returnStaff() {
        return staff;
    }

    public String returnName() {
        return name;
    }

    public int returnId() {
        return id;
    }
    
    public int getPredecessors(){
        return cntPredecessors;
    }
}