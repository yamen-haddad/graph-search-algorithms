/*
author: MHD Yamen HADDAD
Advanced Algorithms
4th year IT student
HIAST
 */
package blindsearch;

import java.util.ArrayList;


public class GraphColoringState extends State {

    /*
    to define the state here we will use 4 arrays as follows:
    red: to mark the nodes(cities) whose color is red.
     green: to mark the nodes(cities) whose color is green.
     blue: to mark the nodes(cities) whose color is blue.
     uncolored: to mark the nodes(cities) whose color is not defined yet.
    */
    //note: we will also suppose that the graph is 2d arrary of integers.
    //if the two cities i & j are adjecent in the map then there is an edge of weight 1 between
    //them in the Graph array G.
    //note: we will define the graph array Static to save memory and because it is the same graph 
    //for all out states.
    int n; //num of cities
    public static int[][] g;
    ArrayList<Integer> red;
    ArrayList<Integer> blue;
    ArrayList<Integer> green;
    ArrayList<Integer> uncolored;
    //note: if we want to solve the general case we will define 2d Array of size (n+1)*n
    //where each line represents a color and the cities with that color on that line.
    public GraphColoringState(ArrayList<Integer> r,ArrayList<Integer> gr,ArrayList<Integer> b,ArrayList<Integer> u)
    {
        red=r;
        green=gr;
        blue=b;
        uncolored=u;
    }
    //here at the beginnig of the problem we will build the graph corresponding to the map
    //notice that we define it as static because it is the same map for all the instances of the state.
    //so in this case we will save memory from storing the same graph again and again for each state instance.
    public static void setGraph(int n,int[][]graph)
    {
        g=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                GraphColoringState.g[i][j]=graph[i][j];
    }
    
    /*
    the string representation of each state is as follows:
    each line will contain the cities colored with the same color starting from red-green-blue-uncolored 
    for example:
    13
    4
    56
    02
    will mean :
    cities 1 & 3 are red
    cities 4 are green
    cities 5 & 6 are blue
    cities 0 & 2 are uncolored
    */
    @Override
    public String toString() {
        String res="";
        for(int i=0;i<red.size();i++)
            res+=red.get(i).toString();
        res+="\n";
        for(int i=0;i<green.size();i++)
            res+=green.get(i).toString();
        res+="\n";
        for(int i=0;i<blue.size();i++)
            res+=blue.get(i).toString();
        res+="\n";
        for(int i=0;i<uncolored.size();i++)
            res+=uncolored.get(i).toString();
        res+="\n";
        return res;
    }

    @Override
    public boolean equals(Object s) {
        return this.toString().equals(s.toString());
    }

    @Override
    public boolean goalCheck() {
            return uncolored.isEmpty(); //if all the cities get colores so the goal state is reached because
                                        //we guarantee that we respect the rule of adjacency durin the coloring action
    }
    public int calculateHeuristic()
    {
        return 0;
    }
    
}
