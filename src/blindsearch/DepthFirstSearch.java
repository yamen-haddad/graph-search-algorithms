/*
author: MHD Yamen HADDAD
Advanced Algorithms
4th year IT student
HIAST
 */
package blindsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class DepthFirstSearch extends Algorithm {
    Stack<Node> open=new Stack();
    ArrayList<Action> allActions=new ArrayList<Action>();
    
    public DepthFirstSearch(Node startNode,ArrayList<Action> allActions){
        this.startNode=startNode;
        this.allActions=allActions;
        open.clear();
        visited.clear();
        fringe.clear();
    }
    @Override
    public boolean found()
    {
        open.clear();
        open.add(startNode);
        visited.clear();
        while(!open.isEmpty())
        {
            Node x=open.pop();
            if(x.isGoal())
            {
                answer=x;
                return true;
            }
            x.expand(allActions,false);
            visited.add(x);
            for(int i=0;i<x.children.size();i++)
            {
                Node tempChild=x.children.get(i);
                if(visited.contains(tempChild) || (fringe.contains(tempChild)))
                {
                    x.children.remove(tempChild);
                }
                else
                {
                    open.push(tempChild);
                }
            }
        }
        answer=null;
        return false;
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
