/*
 * Performs calculations on displayed numbers according to user operation
 */
package Game;

public class Numbers {
	
	public Numbers(int Int1, int Int2, int Int3, int Int4){
		left1 = Int1;
		left2 = Int2;
		right1 = Int3;
		right2 = Int4;
	}//Constructor that allows for input of all number values. 
	public String clicked (int input){//Provides the calculation when the eight buttons are pressed.
		int FinalNum = Tester.getNum();
		if (input ==1){
			left1 = left1 + right1;
			if (left1>FinalNum){
				left1 = left1-FinalNum;
			}//This is the case that button 1 is pressed. 
			
			return Integer.toString(left1);
		} else if (input ==2){
			left1 = left1 + right2;
			if (left1>FinalNum){
				left1 = left1-FinalNum;
			}
			return Integer.toString(left1);
		} else if (input ==3){
			left2 = left2 + right1;
			if (left2>FinalNum){
				left2 = left2-FinalNum;
			}
			return Integer.toString(left2);
		} else if (input ==4){
			left2 = left2 + right2;
			if (left2>FinalNum){
				left2 = left2-FinalNum;
			}
			return Integer.toString(left2);
		} else if (input ==5){
			right1 = right1 + left1;
			if (right1>FinalNum){
				right1 = right1-FinalNum;
			}
			return Integer.toString(right1);
		} else if (input ==6){
			right1 = right1 + left2;
			if (right1>FinalNum){
				right1 = right1-FinalNum;
			}
			return Integer.toString(right1);
		} else if (input ==7){
			right2 = right2 + left1;
			if (right2>FinalNum){
				right2 = right2-FinalNum;
			}
			return Integer.toString(right2);
		} else if (input ==8){
			right2 = right2 + left2;
			if (right2>FinalNum){
				right2 = right2-FinalNum;
			}
			return Integer.toString(right2);
		} else{
			return Integer.toString(0);
		}
		//I used if-else instead of switch statement because returning a value ends the code and there is no where to place the break statement.
		
	
		
	}
	public void clear(){
		left1 = 1;
		left2 = 1;
		right1 = 1;
		right2 = 1;
		//method to clear all numbers, turns all numbers to 1. 
	}
	public int left1,left2,right1,right2;
}



