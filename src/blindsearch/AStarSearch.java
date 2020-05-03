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


public class AStarSearch extends Algorithm{
    PriorityQueue<Node> open=new PriorityQueue<Node>();
    ArrayList<Action> allActions=new ArrayList<Action>();
    
    public AStarSearch(Node startNode,ArrayList<Action> allActions){
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
            if(x.isGoal())
            {
                answer=x;
                return true;
            }
            x.expand(allActions,true);
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
            System.out.println("the cost of the solution is: "+answer.depth);
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
    
    //those are special function for the frame view of the solution of the eight cube
    public ArrayList<int[][]> savePath()
    {
        ArrayList<int[][]> res=new ArrayList<int[][]>();
        generatePath(answer,res);
        return res;
    }
    public void generatePath(Node x,ArrayList<int[][]> res)
    {
         int count=0;
        int [][] temp=new int [4][4];
        if(x.parent==null)
        {
            for(int i=0;i<3;i++)
                for(int j=0;j<3;j++)
                {
                    temp[i][j]=Integer.parseInt(""+x.toString().charAt(count));
                    count++;
                }
            res.add(temp);
            return;
        }
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                temp[i][j]=Integer.parseInt(""+x.toString().charAt(count));
                count++;
            }

        generatePath(x.parent,res);  //recursive call
        res.add(temp);
    }
}
