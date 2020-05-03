/*
author: MHD Yamen HADDAD
Advanced Algorithms
4th year IT student
HIAST
 */
package blindsearch;

import java.util.HashSet;
import java.util.Set;

public abstract class Algorithm { //this is the general class for all the algorithms
    Node startNode;
    Set<Node> visited=new HashSet<Node>();
    Set<Node> fringe=new HashSet<Node>();
    Node answer;//it will holdthe solution if any was found by the algorithm
    public abstract boolean found();
    public abstract void printSolution();
    
    
        //here we guarantee there is a solution
    public abstract void printPath(Node x);
}
