/*
author: MHD Yamen HADDAD
Advanced Algorithms
4th year IT student
HIAST
 */
package blindsearch;



/*
    this class wil define the action that will be done to transfer from one state to another in a search space.
    this class has two methods:
    1- boolean availableAction(State): it will test if the current action can be applied to the parameter state
    2- state doAction(State): it will apply the action on the parameter state and return the new state
        generated after applieng the current action to the parameter State.
*/

public abstract class Action {
    //here we have to define the actions so the code here needs modification according to the problem
    
    /*problem 1
    the actions here are: move blank up-down-left-right wich will be represented as:
    1-move blank up: "up"
    2-move blank down: "down"
    3-move blank right: "right"
    4-move blank left: "left"
    */
    @Override
    public abstract String toString();
    
    public abstract boolean isAvailableAction(State s);
    
    //note: here we suppose we guarantee the current Action can be applied to the before state
    // we test the availability using the function: availableAction
    public abstract State  doAction(State beforeAction);
}
