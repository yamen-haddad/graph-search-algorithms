/*
author: MHD Yamen HADDAD
Advanced Algorithms
4th year IT student
HIAST
 */
package blindsearch;
import java.util.*;

public class BlindSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //this code is for the 1st problem EightCube problem 
        //please un comment the code and run the program to see the result of the 1st problem to any 3*3 array
        //specified in the grid array
        int[][] grid=new int [][]{
            {0,1,2},
            {4,5,3},
            {7,8,6}
        };
        State s=new EightCubeState(grid);
        Node start=new Node(s,null,0,0);
        ArrayList<Action> actions=new ArrayList<Action>();
        actions.add(new EightCubeAction("up"));
        actions.add(new EightCubeAction("down"));
        actions.add(new EightCubeAction("right"));
        actions.add(new EightCubeAction("left"));
        //BreadthFirstSearch a=new BreadthFirstSearch(start,actions);
        long  T1=System.currentTimeMillis();
        AStarSearch a=new AStarSearch(start,actions);
        if(a.found())
            System.out.println("found a solution");
        else
            System.out.println("do not found a solution");
        a.printSolution();
        long  T2=System.currentTimeMillis();
        

        System.out.println("the Time Taken is:"+(T2-T1)+"milliseconds");
        
        //this code is for the 2nd problem Graph Coloring problem 
        //please un comment the code and run the program to see the result of the 2nd problem
////        String graphString="0 1 0 1 0 0 0\n" +
////"1 0 1 1 0 0 0\n" +
////"0 1 0 1 1 0 0\n" +
////"1 1 1 0 1 1 0\n" +
////"0 0 1 1 0 1 0\n" +
////"0 0 0 1 1 0 0\n" +
////"0 0 0 0 0 0 0";
////        //above is the string representation of the graph in the exemple 
////        int n=7;
////        String[] lines=graphString.split("\n");
////        int [][] tempGraph=new int [n][n];
////        for(int i=0;i<n;i++)
////        {
////            String[] nums=lines[i].split(" ");
////            for(int j=0;j<n;j++)
////            {
////                tempGraph[i][j]=Integer.parseInt(nums[j]);
////            }
////        }
////        GraphColoringState.setGraph(n, tempGraph); //initialize the graph
////        //the start state has no colored cities so all its cities are uncolored
////        ArrayList<Integer> colored=new ArrayList<Integer>(); 
////        ArrayList<Integer> colored2=new ArrayList<Integer>(); 
////        ArrayList<Integer> colored3=new ArrayList<Integer>();        
////        ArrayList<Integer> uncolored=new ArrayList<Integer>();
////        for(int i=0;i<n;i++)
////            uncolored.add(i);
////        State s=new GraphColoringState(colored,colored2,colored3,uncolored);
////        Node start=new Node(s,null,0,0);
////        ArrayList<Action> actions=new ArrayList<Action>();
////        actions.add(new GraphColoringAction(1));
////        actions.add(new GraphColoringAction(2));
////        actions.add(new GraphColoringAction(3));
////        //here we will take advantage of the inheritance we built
////        //we will define an instance of Algorithm called a and then using this variable
////        //we will aplly all the five blind search algorithms and make sure they give correct results.
////        Algorithm a=new BreadthFirstSearch(start,actions);
//        if(a.found())
//            System.out.println("found a solution");
//        else
//            System.out.println("do not found a solution");
//        a.printSolution();
//        
//        
//        
//        System.out.println("------------");
//        System.out.println("/DepthFirstSearch/");
//        System.out.println("------------");
//        a=new DepthFirstSearch(start,actions);
//        if(a.found())
//            System.out.println("found a solution");
//        else
//            System.out.println("do not found a solution");
//        a.printSolution();
    
        
//                System.out.println("------------");
//        System.out.println("/DepthLimitedSearch/");
//        System.out.println("------------");
//        System.out.println("trying it with limit smaller than 7");
//        int limit=6;
//        a=new DepthLimitedSearch(start,actions,limit);
//        if(a.found())
//            System.out.println("found a solution");
//        else
//            System.out.println("do not found a solution");
//        a.printSolution();
//        System.out.println("trying it with limit equals or bigger than 7");
//        limit=7;
//        a=new DepthLimitedSearch(start,actions,limit);
//        if(a.found())
//            System.out.println("found a solution");
//        else
//            System.out.println("do not found a solution");
//        a.printSolution();
        
        
//         System.out.println("------------");
//        System.out.println("/IterativeDeepeningSearch/");
//        System.out.println("------------");
//        a=new IterativeDeepeningSearch(start,actions);
//        if(a.found())
//            System.out.println("found a solution");
//        else
//            System.out.println("do not found a solution");
//        a.printSolution();
    }
    
}
