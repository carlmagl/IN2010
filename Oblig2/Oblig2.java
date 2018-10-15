import java.util.*;

class Oblig2 {

    public static void main(String[] args) throws Exception {
        if (args[0] == null) {
            System.out.println("No file found, please add filename after program");
            return;
        } else {
            Planner planner = new Planner(args[0]);
            // starttasks
            // setLatestStartAndSlack
            // printAllAfterRun

        }
    }
}