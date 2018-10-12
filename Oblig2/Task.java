class Task {
    int id, time, staff;
    String name;
    int earliestStart, latestStart;
    List<String> outEdgesString;
    List<Task> outEdges;
    int cntPredecessors;

    Task(int id, String name, int time, int staff, String oE) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.staff = staff;
        this.oE = oE;
    }
    public void setOE(List<Task> outEdgesString){
        this.outEdgesString = outEdgesString;
    }
}
