/*
author: MHD Yamen HADDAD
Advanced Algorithms
4th year IT student
HIAST
 */
package blindsearch;


//here we define each state uniquely as we will use instances of this class to represent the states of our problem.
public abstract class State 
{
    //the feilds in this class depends on the problem we want to solve
    
    /*
    //here we will implement toString method so that each state has a unique string representation
    //we will use this string representation to know if we have already processed this state before in our algorithm
    //so that we will avoid repetetion.
    //note: in most of our blind search algorithm we will use a set data structure called "closed" to identify 
    // all the state that have been processed so that we will not process them again.
    */
    @Override
    public abstract String toString();
    @Override
    public abstract boolean equals(Object s);
    
    /*
    another function we have to implement is a function which will determine if the state is a goal state or not
    according to a certain creitria determined by the problem.
    */
    /*
      //problem 1
    the goal state in problem 1 is only one state which string representation is: "123456780"
    */
    
    public abstract boolean goalCheck();
    
    public abstract int calculateHeuristic();
}
