package Game;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


import javax.swing.JFrame;

public class Tester {
	private static JFrame frame;
	private static int FinalNum = 0;

	public static void main(String[] args) {
		frame = new Frames(FinalNum);
		frame.setTitle("The Advanced Chopsticks Game Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		Scanner kbReader = new Scanner(System.in);
		System.out.println("------------------------------------Welcome to the Advanced Chopsticks Game!-----------------------------------");
		System.out.println(
				"The rule is to let both of your numbers reach the exact number you set up in the beginning in order to win.");
		System.out.println("Within the four buttons on each side, two correspond with one number.");
		System.out.println(
				"The top one of the two buttons indicates to add the first number on the other side to the number it correponds, and vice versa.");
		System.out.println(
				"For example, the button → to the right of player one's first number means to add the first number of player two to it if clicked.");
		System.out.println(
				"If your number exceeds the destined number, it will be replaced by the difference subtracted from the destined number.");//Description of rules.
		System.out.print("Enter the number you what the game to reach to_");
		try {
			FinalNum = kbReader.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Input is not a valid integer. " + e);
			System.out.println("Please start again or consult someone if experiencing difficulties on entering input.");
			System.exit(0);
		} // Catches the exception of user input is not an integer.

		System.out.println("It is recorded, the game is starting on a seperate window.");
		
		frame = new Frames(FinalNum);
		frame.setTitle("The Advanced Chopsticks Game Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	} // Creates the frame.
	public static void startResult() throws IOException{
		
		Scanner kbReader = new Scanner(System.in);
		System.out.print("Enter the filepath you want the result to be saved to: ");
		String filepath = kbReader.nextLine();
		DataPrinting newData = new DataPrinting(Frames.TimeListPlayer1, Frames.TimeListPlayer2,filepath);
		newData.printDataToFile();//Saves the data to the file using the method in the DataPrinting class.
		System.out.println("Your data is saved.");
		newData.printTree();//prints the data to the file using the printTree method in the DataPrinting class
		
		System.out.println("The shortest time taken for player 1 to make a move is: "+newData.findShortestTime1()+"s.");
		System.out.println("The shortest time taken for player 2 to make a move is: "+newData.findShortestTime2()+"s.");//Shows the result of sorting.
		System.out.println("The demonstration of your result is completed. Thank your for playing!");
	}
	public static int getNum() {
		return FinalNum;
	}

	public static void quit() {
		frame.setVisible(false);
		frame.dispose();
	}

	// Set the frame to be invisible and disposes it.

}
