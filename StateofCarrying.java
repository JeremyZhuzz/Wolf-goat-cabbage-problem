public class StateofCarrying
{    
    static int n =4;
    int stateA[];

public StateofCarrying(int[] stateA){
    this.stateA = stateA;
} 



//It has to be a copy of values not reference because we will 
//create many states and don't want to overwrite the same array.
public StateofCarrying(StateofCarrying state) {
    stateA = new int[4];
    for(int i =0;i<4;i++){
        this.stateA[i] = state.stateA[i];
    }
}

// public boolean equals(Object s){

//     StateofCarrying state = (StateofCarrying) s;
//     for(int i =0; i<4; i++){
//         if(this.stateA[i] != state.stateA[i]){
//             return false;
//         }
//     }
//     return true;
// }

public int hashcode(){
    return stateA[0]*1000 + stateA[1]*100 + stateA[2]*10 + stateA[3];
}


public String toString() {
    String s = "";
	for(int i =0;i<4;i++){
        s = s+stateA[i]+" ";
    }
    return s;
}
}