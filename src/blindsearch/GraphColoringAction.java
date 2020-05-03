/*
author: MHD Yamen HADDAD
Advanced Algorithms
4th year IT student
HIAST
 */
package blindsearch;

import java.util.ArrayList;


public class GraphColoringAction extends Action {
    int id;
    /*
    note: here we have three actions which they are:
    -color the first uncolored city with red and we will identify this action with number 1 in te id.
    -color the first uncolored city with green and we will identify this action with number 1 in te id.
    -color the first uncolored city with blue and we will identify this action with number 1 in te id.
    note that in the general case(more than three colors), then each coloring action will have its own id
    in this case more than three ids available.
    */
    public GraphColoringAction(int id)
    {
        this.id=id;
    }
    @Override
    public String toString() {
        return Integer.toString(id);
    }
    /*
    note: this function will return true if the action can be applied to the current state.
    here we discuss it only for three colors as required. but if we want to solve the general problem 
    (with n colors). we only have to iterate throw the line of the same color as the action.
    if the action id is 5 for exemple we will search for adjecants in the 5th line in the 2D color array
    the line is: color[5] 1D arrary 
    */
    @Override
    public boolean isAvailableAction(State s1) {
        GraphColoringState s=(GraphColoringState) s1;//here we guarantee that the casting is correct because we
                                            //will use this function only with EightCubeState.
        if(this.toString().equals("1")) //if we want to color the new city with red then it should not
                                        //be adjacent to any city in the red Array of cities
        {
            for(int i=0;i<s.red.size();i++)
            {
                if(GraphColoringState.g[s.red.get(i)][s.uncolored.get(0)]==1) //then they are adjecant
                    return false;
            }
        }
        else if(this.toString().equals("2"))//if we want to color the new city with green then it should not
                                        //be adjacent to any city in the green Array of cities
        {
            for(int i=0;i<s.green.size();i++)
            {
                if(GraphColoringState.g[s.green.get(i)][s.uncolored.get(0)]==1) //then they are adjecant
                    return false;
            }
        }
        else if(this.toString().equals("3"))//if we want to color the new city with blue then it should not
                                        //be adjacent to any city in the blue Array of cities
        {
            for(int i=0;i<s.blue.size();i++)
            {
                if(GraphColoringState.g[s.blue.get(i)][s.uncolored.get(0)]==1) //then they are adjecant
                    return false;
            }
        }
        return true;
    }

        //note: here we suppose we guarantee the current Action can be applied to the before state
    // we test the availability using the function: availableAction
    @Override
    public State doAction(State beforeActionState) {
        GraphColoringState afterAction; //the new state after we apply the action and it will be returned as an output of
                           //the function.
        GraphColoringState beforeAction=(GraphColoringState)beforeActionState;
        //we will create a temporary arrays to hold the modification in state after we aplly the action then
        //build the new state (the after state) and return it as output of the function.
        ArrayList<Integer> tempRed = new ArrayList<Integer>();
        tempRed.addAll(beforeAction.red);
        ArrayList<Integer> tempGreen= new ArrayList<Integer>();
        tempGreen.addAll(beforeAction.green);
        ArrayList<Integer> tempBlue= new ArrayList<Integer>();
        tempBlue.addAll(beforeAction.blue);
        ArrayList<Integer> tempUncolored= new ArrayList<Integer>();
        tempUncolored.addAll(beforeAction.uncolored);
        if(this.toString().equals("1")) //we need to move the first uncolored city to the red array
        {
            tempRed.add(tempUncolored.get(0));
            tempUncolored.remove(0);
        }
        else if(this.toString().equals("2")) //we need to move the first uncolored city to the green array
        {
            tempGreen.add(tempUncolored.get(0));
            tempUncolored.remove(0);
        }
        else if(this.toString().equals("3")) //we need to move the first uncolored city to the blue array
        {
            tempBlue.add(tempUncolored.get(0));
            tempUncolored.remove(0);
        }
        afterAction=new GraphColoringState(tempRed,tempGreen,tempBlue,tempUncolored);
        return afterAction;
    }
    
}
