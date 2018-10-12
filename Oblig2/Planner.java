import java.io.File;
import java.util.*;

class Planner{

    class Task {
        int id , time , staff ;
        String name ;
        int earliestStart , latestStart ;
        List < Task > outEdges ;
        int cntPredecessors ;
    
        Task(int id, String name, int time, int staff, List<Task> outEdges){
            this.id = id;
            this.name = name;
            this.time = time;
            this.staff = staff;
            this.outEdges = outEdges;
        }       
    }    

    List<Task> tasks = new List<Task>();

    planner(String filNavn){
        readFile(filnavn);
    }

    public void readFile(String filnavn){
        Scanner scanner = new Scanner(filnavn);
        while(scanner.hasNextLine()){
            String[] info = scanner.nextLine().split(" ");
            Task newTask = new Task(info[0], info[1], info[2], info[3]);
            List<String> temp;
            for(int i = 4; i < info.length; i++){
                temp.add(info[i]);
            }
            newTask.setOe(temp);
        }
    }

    public void findCycle(){
        
    }

}