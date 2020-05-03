/*
author: MHD Yamen HADDAD
Advanced Algorithms
4th year IT student
HIAST
 */
package blindsearch;


public class EightCubeAction extends Action {
    
    /*problem 1
    the actions here are: move blank up-down-left-right wich will be represented as:
    1-move blank up: "up"
    2-move blank down: "down"
    3-move blank right: "right"
    4-move blank left: "left"
    */
    private String direction;
    public EightCubeAction(String direction)
    {
        this.direction=direction;
    }
    @Override
    public String toString()
    {
        return this.direction;
    }
    
    @Override
    public boolean isAvailableAction(State s1)
    {
        EightCubeState s=(EightCubeState) s1;//here we guarantee that the casting is correct because we
                                            //will use this function only with EightCubeState.
        if(this.toString().equals("up"))     //here the blank should not be in the first line of the grid
        {
            for(int i=0;i<3;i++)
            {
                if(s.grid[0][i]==0)
                    return false;
            }
        }
        else if(this.toString().equals("down"))   //here the blank should not be in the last line of the grid
        {
            for(int i=0;i<3;i++)
            {
                if(s.grid[2][i]==0)
                    return false;
            }
        }
        else if(this.toString().equals("right"))  //here the blank should not be in the last column of the grid
        {
            for(int i=0;i<3;i++)
            {
                if(s.grid[i][2]==0)
                    return false;
            }
        }
        else if(this.toString().equals("left"))  //here the blank should not be in the first column of the grid
        {
            for(int i=0;i<3;i++)
            {
                if(s.grid[i][0]==0)
                    return false;
            }
        } 
        return true;
    }
    
    //note: here we suppose we guarantee the current Action can be applied to the before state
    // we test the availability using the function: availableAction
    @Override
    public State doAction(State beforeActionState)
    {
        EightCubeState afterAction; //the new state after we apply the action and it will be returned as an output of
                           //the function.
        EightCubeState beforeAction=(EightCubeState)beforeActionState;
        int[][] temp=new int[3][3];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                temp[i][j]=beforeAction.grid[i][j];
        boolean done=false; // to determine if we move the blank or not yet
        if(this.toString().equals("up"))     //here the blank should not be in the first line of the grid
        {
            for(int i=1;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(temp[i][j]==0)
                    {   
                        //swap the blank with the upper element in the grid
                        int aux=temp[i-1][j];
                        temp[i-1][j]=0;   //move the blank up
                        temp[i][j]=aux;
                        done=true;
                        break;
                    }
                }
                    if(done)
                        break;
            }
        }
        else if(this.toString().equals("down"))   //here the blank should not be in the last line of the grid
        {
            for(int i=0;i<2;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(temp[i][j]==0)
                    {   
                        //swap the blank with the lower element in the grid
                        int aux=temp[i+1][j];
                        temp[i+1][j]=0;   //move the blank down
                        temp[i][j]=aux;
                        done=true;
                        break;
                    }
                }
                 if(done)
                  break;
        
            }
        }
        else if(this.toString().equals("right"))  //here the blank should not be in the last column of the grid
        {
            for(int j=0;j<2;j++)
            {
                for(int i=0;i<3;i++)
                {
                    if(temp[i][j]==0)
                    {   
                        //swap the blank with the right element in the grid
                        int aux=temp[i][j+1];
                        temp[i][j+1]=0;   //move the blank right
                        temp[i][j]=aux;
                        done=true;
                        break;
                    }
                }
                    if(done)
                        break;
            }
        }
        else if(this.toString().equals("left"))  //here the blank should not be in the first column of the grid
        {
            for(int j=1;j<3;j++)
            {
                for(int i=0;i<3;i++)
                {
                    if(temp[i][j]==0)
                    {   
                        //swap the blank with the left element in the grid
                        int aux=temp[i][j-1];
                        temp[i][j-1]=0;   //move the blank left
                        temp[i][j]=aux;
                        done=true;
                        break;
                    }
                }
                    if(done)
                        break;
            }
        }
        afterAction=new EightCubeState(temp);
        return afterAction;
    }
}
