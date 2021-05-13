import java.util.HashSet;
import java.util.Set;

public class ProblemofCarrying extends Problem {

	static final int n = 4;
	static final int farmer = 0;//farmer 
	static final int wolf = 1;//wolf
	static final int goat = 2;//goat
	static final int cabbage = 3;//cabbage 
    //0 means didnot get over the river
    //1 means get over the river
boolean goal_test(Object state){
	StateofCarrying carrying_state = (StateofCarrying) state;

	if(carrying_state.stateA[farmer] == 1&&carrying_state.stateA[wolf] == 1&&carrying_state.stateA[goat] == 1&&carrying_state.stateA[cabbage] ==1){
		return true;
	}else{
		return false;
	}
}
Set<Object> getSuccessors(Object state) {
	
    Set<Object> set = new HashSet<Object>();
    StateofCarrying s = (StateofCarrying) state;
    //int i0 = s.i0, j0 = s.j0;
    
    StateofCarrying successorS; //successor state
        //Only farmer on the boat!
    	if(s.stateA[farmer]==0){
    		successorS = new StateofCarrying(s);
            //Changes farmer states to 1
    		successorS.stateA[farmer]=1;
    		set.add(successorS);
    		if(!checkif(s)){
    			return set;
    		}
    	}
        //farmer back on the bank 
    	if(s.stateA[farmer]==1){
    		successorS = new StateofCarrying(s);
    		successorS.stateA[farmer]=0;
    		set.add(successorS);
    		if(!checkif(s)){
    			return set;
    		}

    	}
        //farmer gets on the boat with wolf
    	if(s.stateA[farmer]==0&&s.stateA[wolf]==0){
    		successorS = new StateofCarrying(s);
    		successorS.stateA[farmer]=1;
    		successorS.stateA[wolf]=1;
    		set.add(successorS);
        	if(!checkif(s)){
    			return set;
    		}

    	}
        //farmer gets on the boat with goat
    	if(s.stateA[farmer]==0&&s.stateA[goat]==0){
    		successorS = new StateofCarrying(s);
    		successorS.stateA[farmer]=1;
    		successorS.stateA[goat]=1;
    		set.add(successorS);
    		if(!checkif(s)){
    			return set;
    		}

    	}
        //farmer gets on the boat with cabbage
    	if(s.stateA[farmer]==0&&s.stateA[cabbage]==0){
    		successorS = new StateofCarrying(s);
    		successorS.stateA[farmer]=1;
    		successorS.stateA[cabbage]=1;
    		set.add(successorS);
    		if(!checkif(s)){
    			return set;
    		}

    	}
        //farmer is back with wolf
        if(s.stateA[farmer]==1&&s.stateA[wolf]==1){
    		successorS = new StateofCarrying(s);
    		successorS.stateA[farmer]=0;
    		successorS.stateA[farmer]=0;
    		set.add(successorS);
    		if(!checkif(s)){
    			return set;
    		}

    	}
        //farmer is back with goat
    	if(s.stateA[farmer]==1&&s.stateA[goat]==1){
    		successorS = new StateofCarrying(s);
    		successorS.stateA[farmer]=0;
    		successorS.stateA[goat]=0;
    		set.add(successorS);
    		if(!checkif(s)){
    			return set;
    		}
    	}
        //farmer is back with cabbage
    	if(s.stateA[farmer]==1&&s.stateA[cabbage]==1){
    		successorS = new StateofCarrying(s);
    		successorS.stateA[farmer]=0;
    		successorS.stateA[cabbage]=0;
    		set.add(successorS);

    		if(!checkif(s)){
    			return set;
    		}
    	}
    

    
    return set;
}

public boolean checkif(StateofCarrying state){
    //check if the goat is not with wolf or cabbage
	if(state.stateA[farmer] == 0 && state.stateA[goat] ==1 && state.stateA[wolf]==1){
		return false;
	}
	if(state.stateA[farmer] == 0 && state.stateA[goat] ==1 && state.stateA[cabbage]==1){
		return false;
	}
	if(state.stateA[farmer] == 1 && state.stateA[goat] ==0 && state.stateA[wolf]==0){
		return false;
	}
	if(state.stateA[farmer] == 1 && state.stateA[goat] ==0 && state.stateA[cabbage]==0){
		return false;
	}
	return true;
}
double step_cost(Object fromState, Object toState) { 
    return 1; 
}

public double h(Object state){
	return 0;
}

public static void main(String[] args) throws Exception {

	ProblemofCarrying problem = new ProblemofCarrying();
	//1 represent 
	int[] init = new int[n];
	//int[] init2 = new int[n];
	problem.initialState = new StateofCarrying(init); 
	
	Search search  = new Search(problem);
	
	System.out.println("TreeSearch------------------------");
	System.out.println("BreadthFirstTreeSearch:\t\t" + search.BreadthFirstTreeSearch());
	System.out.println("UniformCostTreeSearch:\t\t" + search.UniformCostTreeSearch());
	System.out.println("DepthFirstTreeSearch:\t\t" + search.DepthFirstTreeSearch());
	System.out.println("GreedyBestFirstTreeSearch:\t" + search.GreedyBestFirstTreeSearch());
	System.out.println("AstarTreeSearch:\t\t" + search.AstarTreeSearch());
	
	System.out.println("\n\nGraphSearch----------------------");
	System.out.println("BreadthFirstGraphSearch:\t" + search.BreadthFirstGraphSearch());
	System.out.println("UniformCostGraphSearch:\t\t" + search.UniformCostGraphSearch());
	System.out.println("DepthFirstGraphSearch:\t\t" + search.DepthFirstGraphSearch());
	System.out.println("GreedyBestGraphSearch:\t\t" + search.GreedyBestFirstGraphSearch());
	System.out.println("AstarGraphSearch:\t\t" + search.AstarGraphSearch());
	
	System.out.println("\n\nIterativeDeepening----------------------");
	System.out.println("IterativeDeepeningTreeSearch:\t" + search.IterativeDeepeningTreeSearch());
	System.out.println("IterativeDeepeningGraphSearch:\t" + search.IterativeDeepeningGraphSearch());
}

}