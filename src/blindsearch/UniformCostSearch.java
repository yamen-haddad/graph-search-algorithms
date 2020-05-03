/*
author: MHD Yamen HADDAD
Advanced Algorithms
4th year IT student
HIAST
 */
package blindsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class UniformCostSearch extends Algorithm{
    PriorityQueue<Node> open=new PriorityQueue<Node>();
    ArrayList<Action> allActions=new ArrayList<Action>();
    
    public UniformCostSearch(Node startNode,ArrayList<Action> allActions){
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
            Node x=open.poll();
            System.out.println(x);
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
                    open.add(tempChild);
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
