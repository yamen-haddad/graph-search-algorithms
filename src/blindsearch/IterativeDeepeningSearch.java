/*
author: MHD Yamen HADDAD
Advanced Algorithms
4th year IT student
HIAST
 */
package blindsearch;

import java.util.ArrayList;
import java.util.Stack;

public class IterativeDeepeningSearch extends  Algorithm{
    Stack<Node> open=new Stack();
    ArrayList<Action> allActions=new ArrayList<Action>();
    
    public IterativeDeepeningSearch(Node startNode,ArrayList<Action> allActions){
        this.startNode=startNode;
        this.allActions=allActions;
        open.clear();
        visited.clear();
        fringe.clear();
    }
    @Override
    public boolean found() //here we will iteratively create instances of DepthLimitedSearch class and increment the limit feild 
                           //until we find the solution
    {
        for(int depth=0;;depth++)
        {
            DepthLimitedSearch temp=new DepthLimitedSearch(this.startNode,this.allActions,depth);
            if(temp.found())
            {
                answer=temp.getAnswer();
                return true;
            }
        }
    }
    public void printSolution()
    {
        if(!found())
            System.out.println("no solution");
        else
        {
            printPath(answer);
            System.out.println("the cost of the solution is: "+answer.cost);
        }
    }
    //here we guarantee there is a solution
    public void printPath(Node x)
    {
        if(x.parent==null)
        {
            System.out.println(x);
            return;
        }
        printPath(x.parent);  //recursive call
        System.out.println(x);
    }
}
