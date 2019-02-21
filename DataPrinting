package Game;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class DataPrinting {
	private ArrayList<Integer> TimeListPlayer1 = new ArrayList<Integer>();
	private ArrayList<Integer> TimeListPlayer2 = new ArrayList<Integer>();
	private String filepath;

	public DataPrinting(ArrayList<Integer> a, ArrayList<Integer> b, String c) {

		TimeListPlayer1 = a;
		TimeListPlayer2 = b;
		filepath = c;
	}//constructor
	public int findShortestTime1(){//Uses selection sort to sort the times.
		int min, minIndex;
		for(int i = 0;i < TimeListPlayer1.size(); ++i)
			//Recurses the same time as the number of integers
		{
			min = TimeListPlayer1.get(i);//Initially set the first as minimum
			minIndex = i;
			for (int j = i + 1; j < TimeListPlayer1.size(); ++j) // Find minimum
			{
				if (TimeListPlayer1.get(j) < min) //salient feature
				{
					min = TimeListPlayer1.get(j);
					minIndex = j;
				}
			}
			TimeListPlayer1.set(minIndex, TimeListPlayer1.get(i));
			 // the swap
			TimeListPlayer1.set(i, min);
			}
		return TimeListPlayer1.get(0);//Returns the first integer as the shortest time taken.
	}
	
	public int findShortestTime2(){//Uses selection sort to sort the times.
		int min, minIndex;
		for(int i = 0;i < TimeListPlayer2.size(); ++i)
			//Recurses the same time as the number of integers
		{
			min = TimeListPlayer2.get(i);//Initially set the first as minimum
			minIndex = i;
			for (int j = i + 1; j < TimeListPlayer2.size(); ++j) // Find minimum
			{
				if (TimeListPlayer2.get(j) < min) //salient feature
				{
					min = TimeListPlayer2.get(j);
					minIndex = j;
				}
			}
			TimeListPlayer2.set(minIndex, TimeListPlayer2.get(i));
			 // the swap
			TimeListPlayer2.set(i, min);
			}
		return TimeListPlayer2.get(0);//Returns the first integer as the shortest time taken.
	}
	
	
	public void printTree() {
		BST bstObj1 = new BST(TimeListPlayer1.get(0));//Add the first as root node
		for(int x=1; x<TimeListPlayer1.size(); x++){
			bstObj1.addNode(TimeListPlayer1.get(x));
		}//Adds the integers in the first list to the first binary tree
		System.out.println("The first player's time in the form of a binary search tree: ");
		bstObj1.printSideways(); //print the tree sideways
		BST bstObj2 = new BST(TimeListPlayer1.get(0));//Add the first as root node
		for(int y=2; y<TimeListPlayer2.size(); y++){
			bstObj2.addNode(TimeListPlayer2.get(y));
		}//Adds the integers in the second list to the second binary tree
		System.out.println("The second player's time in the form of a binary search tree: ");
		bstObj2.printSideways() ;//print the tree sideways
	}

	public void printDataToFile() throws IOException {

		FileWriter fw = new FileWriter(filepath);
		PrintWriter output = new PrintWriter(fw);
		output.println("------List of Player 1's Time Taken for Each Move-------");
		for (int i = 0; i < TimeListPlayer1.size(); i++) {
			output.println("Turn: " + (i + 1) + "\t" + " Time(s): " + TimeListPlayer1.get(i) + "\n");
		}//Print player1's data
		output.println("------List of Player 2's Time Taken for Each Move-------");
		for (int i = 0; i < TimeListPlayer2.size(); i++) {
			output.println("Turn: " + (i + 1) + "\t" + " Time(s): " + TimeListPlayer2.get(i) + "\n");
		}//Print player 2's data
		output.close();	
	}// Method to print the Data Table to the file indicated.

}
