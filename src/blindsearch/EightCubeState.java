/*
author: MHD Yamen HADDAD
Advanced Algorithms
4th year IT student
HIAST
 */
package blindsearch;


public class EightCubeState extends State {
    //the feilds in this class depends on the problem we want to solve
    //so this code needs modification according to the problem
    //problem 1
    int n;  //the dimention of the grid
    public int [][] grid=new int [3][3];
    public EightCubeState(int [][] temp)
    {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                grid[i][j]=temp[i][j];
    }
    
        /*
    //here we will implement toString method so that each state has a unique string representation
    //we will use this string representation to know if we have already processed this state before in our algorithm
    //so that we will avoid repetetion.
    //note: in most of our blind search algorithm we will use a set data structure called "closed" to identify 
    // all the state that have been processed so that we will not process them again.
    */
    /*
    //problem1
    //the grid is represented in a line of 9 digits representing the grid as follow
         2 3 5
         8 1 6
         4 0 7
    will be represented as follows: 235816407
    */
        @Override
    public String toString()
    {
        String res="";
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                res+=grid[i][j];
        return res;
    }
    @Override
    public boolean equals(Object s)
    {
        return this.toString().equals(s.toString());
    }
    
    /*
    another function we have to implement is a function which will determine if the state is a goal state or not
    according to a certain creitria determined by the problem.
    */
    /*
      //problem 1
    the goal state in problem 1 is only one state which string representation is: "123456780"
    */
    
    public boolean goalCheck()
    {
        if(this.toString().equals("123456780"))
            return true;
        return false;
    }
    //this function will evaluate the currnt state and give a heuristic to it(the expected cost to reach the goal state)
    //we will use this function in any heuristic based search like A* or hill climbing
    public int calculateHeuristic()
    {
        int res=0;
        String stateRepresentation=this.toString();
        for(int i=0;i<stateRepresentation.length();i++)
        {
            char correctPosition=(char)('0'+i+1);
            if(stateRepresentation.charAt(i)!='0' &&stateRepresentation.charAt(i)!=correctPosition)
            {
                res++;
            }
        }
        return res;
    }
}
