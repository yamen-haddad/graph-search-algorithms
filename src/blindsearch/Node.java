/*
author: MHD Yamen HADDAD
Advanced Algorithms
4th year IT student
HIAST
 */
package blindsearch;

import java.util.ArrayList;


public class Node implements Comparable<Node>{
    State state;
    int totalCost;// it is used in A* algorithm only (totalCost=cost+heuristic)
    int cost; //the cost to from the start node to this node
    int heuristic; //the expected cost from the current Node to the Goal Node(user in heuristic search algorithm only)
    int depth; //the dipth of the node in the space search tree
    Node parent;
    ArrayList<Node> children;
    public Node(State s)
    {
        this.state=s;
        cost=0;
        depth=0;
    }
    public Node(State s,Node parent,int cost,int depth)
    {
        this.parent=parent;
        this.state=s;
        this.cost=cost;
        this.depth=depth;
    }
    @Override
    public String toString()
    {
        return this.state.toString();
    }
    /*
    this method will use the allActions ArrayList to determine the availabe action for this node and thn
    create an ArrayList of the children of this state
    the boolean parameter is used to specify if we want to use heuristic or not
    */
    void expand(ArrayList<Action> allActions,boolean withHeuristic)
    {
        children=new ArrayList<Node>();
        for(int i=0;i<allActions.size();i++)
        {
            if(allActions.get(i).isAvailableAction(state)) //if we can apply the acton to the current sate then we
            {                                              //can generate a new child and add it to the children
                                                            // ArrayList
                State childState=allActions.get(i).doAction(state);
                Node availableChild;
                if(withHeuristic)
                {
                    cost=cost+1;
                    this.heuristic=this.state.calculateHeuristic();
                    totalCost=this.cost+this.heuristic;
                    availableChild=new Node(childState,this,totalCost,depth+1);
                }
                else
                {
                    availableChild=new Node(childState,this,cost+1,depth+1);
                }
                children.add(availableChild);
            }
        }
    }
    public boolean isGoal()
    {
        return this.state.goalCheck();
    }

    @Override
    public int compareTo(Node o) {
        return this.cost-o.cost;
        }
    
}
