package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Sets up frame that displays the game.
 */

public class Frames extends JFrame {

	private static final int FRAME_WIDTH = 1200;
	private static final int FRAME_HEIGHT = 500;

	
	private JLabel numLabelLeft1, numLabelLeft2, numLabelRight1, numLabelRight2;
	private JButton QuitButton, RestartButton;

	private JLabel numValueLeft1 = new JLabel(), numValueLeft2 = new JLabel();
	private JLabel numValueRight1 = new JLabel(), numValueRight2 = new JLabel();

	public static JLabel TopField;

	private JPanel Player1Panel = new JPanel(), Player2Panel = new JPanel();	
	private JPanel TopPanel = new JPanel(), BottomPanel = new JPanel(), ButtonsPanel = new JPanel();

	public static JButton Player1Button1a, Player1Button1b, Player1Button2a, Player1Button2b;
	public static JButton Player2Button1a, Player2Button1b, Player2Button2a, Player2Button2b;
	// initialize the components.

	private Numbers newNum = new Numbers(1, 1, 1, 1);
	private int turn = 1;
	private int FinalNum;
	private boolean run = true;
	private int moves1 = 0, moves2 = 0;
	
	
	public static ArrayList<Integer> TimeListPlayer1 = new ArrayList<Integer>();
	public static ArrayList<Integer> TimeListPlayer2 = new ArrayList<Integer>();
	
	//ArrayLists to store the time taken. 
	
	
	public Frames(int n) {
		FinalNum = n;//Uses the user input as the final number.
		createPlayer1Field();
		createPlayer1Panel();
		add(Player1Panel, BorderLayout.WEST);
		add(Player2Panel, BorderLayout.EAST);
		createPlayer2Field();
		createPlayer2Panel();//Calls the methods to create each player's panels.
		createTopPanel();
		add(TopPanel, BorderLayout.NORTH);
		createBottomPanel();
		add(BottomPanel, BorderLayout.SOUTH);

		createButtons();
		createButtonsPanel();
		add(ButtonsPanel, BorderLayout.CENTER);//Creates the buttons and add them to the panel. 

		setSize(FRAME_WIDTH, FRAME_HEIGHT);

	}// Constructor that creates the panel and calls each method to start.

	private void createPlayer1Field() {

		numLabelLeft1 = new JLabel("Player1's 1st Number-");
		numLabelLeft1.setForeground(Color.white);//The color of this text is white.
		numLabelLeft2 = new JLabel("Player1's 2nd Number-");
		numLabelLeft2.setForeground(Color.white);
		numValueLeft1.setText("1");
		numValueLeft1.setFont(new Font("Serif", Font.BOLD, 82));//The font is Serif, Bolded, and size 82.
		numValueLeft1.setForeground(Color.CYAN);//The color is cyan.
		numValueLeft2.setText("1");
		numValueLeft2.setFont(new Font("Serif", Font.BOLD, 82));
		numValueLeft2.setForeground(Color.CYAN);
	}
	
	private void createPlayer1Panel() {
		Player1Panel.setLayout(new BorderLayout());
		JLabel leftBack = new JLabel(new ImageIcon("Users/ouiku/Documents/CS302_linkedFiles/BackLeft.png"));
		//JLabel leftBack = new JLabel(new ImageIcon("/Users/ouiku/Desktop/BackLeft.png"));
		///Users/ouiku/Documents/CS302_linkedFiles
		//Sets the background picture. 
		Player1Panel.add(leftBack);
		leftBack.setLayout(new GridLayout(2, 2));
		leftBack.add(numLabelLeft1);
		leftBack.add(new JLabel(" "));// Tap to create eye-pleasing effect of
										// space around the numbers.
		leftBack.add(numValueLeft1);
		leftBack.add(numLabelLeft2);
		leftBack.add(new JLabel(" "));
		leftBack.add(numValueLeft2);
		// Adds the labels to the panel.
	}

	private void createPlayer2Field() {

		numLabelRight1 = new JLabel("-Player2's 1st Number");
		numLabelRight1.setForeground(Color.white);//The color of the text is white. 
		numLabelRight2 = new JLabel("-Player2's 2nd Number");
		numLabelRight2.setForeground(Color.white);
		numValueRight1.setText("1");
		numValueRight1.setFont(new Font("Serif", Font.BOLD, 82));
		numValueRight1.setForeground(Color.CYAN);//The color of the text is cyan. 
		numValueRight2.setText("1");
		numValueRight2.setFont(new Font("Serif", Font.BOLD, 82));
		numValueRight2.setForeground(Color.CYAN);

	}// Change font

	private void createPlayer2Panel() {
		Player2Panel.setLayout(new BorderLayout());
		JLabel rightBack = new JLabel(new ImageIcon("/Users/ouiku/Documents/CS302_linkedFiles/BackRight.png"));
		//Adds the background picture
		Player2Panel.add(rightBack);
		rightBack.setLayout(new GridLayout(2, 2));
		//2 rows and 2 columns.
		rightBack.add(new JLabel(" "));
		rightBack.add(numValueRight1);
		rightBack.add(numLabelRight1);
		rightBack.add(new JLabel(" "));
		rightBack.add(numValueRight2);
		rightBack.add(numLabelRight2);
		//Adds the components.
	}

	private void createTopPanel() {
		TopField = new JLabel();

		TopField.setText("Welcome to the Advanced Chopsticks Game! It's player 1's turn!");
		TopField.setFont(new Font("Serif", Font.BOLD, 32));

		TopPanel.add(TopField);

	}// Sets up the label and the text field.

	private void createBottomPanel() {
		BottomPanel.setLayout(new BorderLayout());
		JLabel bottomBack = new JLabel(new ImageIcon("Users/ouiku/Documents/CS302_linkedFiles/BackBottom.png"));
		BottomPanel.add(bottomBack);
		bottomBack.setLayout(new GridLayout(1, 5));
		RestartButton = new JButton("RESTART");
		class AddRestartListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				numValueLeft1.setText("1");
				numValueLeft2.setText("1");
				numValueRight1.setText("1");
				numValueRight2.setText("1");
				newNum.clear();//Sets all values to 1.
				turn = 1;
				TopField.setText("The Game is Restarted. It's Player 1's Turn.");
				run = true;
			}
		}
		ActionListener RestartListener = new AddRestartListener();
		RestartButton.addActionListener(RestartListener);
		bottomBack.add(RestartButton);
		bottomBack.add(new JLabel(" "));
		bottomBack.add(new JLabel(" "));
		bottomBack.add(new JLabel(" "));// Eye-pleasing space between the two
										// buttons
		QuitButton = new JButton("QUIT");
		class AddQuitListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				System.out.println("--------------------");
				System.out.println("The game is quitted.");
				Tester.quit();//Create and implement the quit function.
				try {
					Tester.startResult();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		ActionListener QuitListener = new AddQuitListener();
		QuitButton.addActionListener(QuitListener);
		bottomBack.add(QuitButton);

	}
	Stopwatch watch1 = new Stopwatch();
	Stopwatch watch2 = new Stopwatch();
	
	private void createButtons() {

		class AddButtonListener1 implements ActionListener {
//Detects if the buttons are pressed
			public void actionPerformed(ActionEvent event) {
				//Each player are detected and their times are recorded separately. 
				
					if (turn == 1 && run) {//case that player 1 moves
						if (moves1>0){
							//Only records after the first move.
							watch2.stop();//Stops the timer that started when player 2 finished.
							long temp = watch2.getElapsedTime();
							//System.out.println("num of moves for player 1- " + moves1 +": " + temp);
							//Can be used when testing, or if the user prefers to see the time for each move.
							TimeListPlayer1.add((int)temp);
							//Stores the number to the array-list.
						}
						
					if (event.getSource() == Frames.Player1Button1a) {
						moves1++;//Increments the number of moves by 1. 
						numValueLeft1.setText(newNum.clicked(1));//calls the case that button 1 is pressed.
						TopField.setText("Left has moved. It's Right's Turn!");
						turn = 2;//Set it to be right side's turn.
						watch1.start();//Case of "11a".
					} else if (event.getSource() == Frames.Player1Button1b) {
						moves1++;
						numValueLeft1.setText(newNum.clicked(2));//calls the case that button 2 is pressed.
						TopField.setText("Left has moved. It's Right's Turn!");
						turn = 2;
						watch1.start();
					} else if (event.getSource() == Frames.Player1Button2a) {
						moves1++;
						numValueLeft2.setText(newNum.clicked(3));//calls the case that button 3 is pressed.
						TopField.setText("Left has moved. It's Right's Turn!");
						turn = 2;
						watch1.start();
					} else if (event.getSource() == Frames.Player1Button2b) {
						moves1++;
						numValueLeft2.setText(newNum.clicked(4));//calls the case that button 4 is pressed.
						TopField.setText("Left has moved. It's Right's Turn!");
						turn = 2;
						watch1.start();
					} else 
					{
						TopField.setText("Wrong Move. It's player 1 (left)'s turn!");
					}//Case that a player 2's button is pressed mistakenly.
					if (Integer.valueOf(numValueLeft1.getText()) == FinalNum
							&& Integer.valueOf(numValueLeft2.getText()) == FinalNum) {		
						//Both numbers of player 1 reach the final number
						TopField.setText("Player 1 Wins! Congratulations!");
						run = false;
					}
					}
				} 				
			}
		
		class AddButtonListener2 implements ActionListener {
			//Detects if the buttons are pressed
			public void actionPerformed(ActionEvent event) {
				if (turn == 2 && run) {//Case that player 2 moves.
					if (moves2>0){
						//Only records after the first move.
						watch1.stop();//Stops the timer that started when player 1 finished moving.
						long temp = watch1.getElapsedTime();
						//System.out.println("num of moves for player 2- " + moves2 +": " + temp);
						//Can be used when testing, or if the user prefers to see the time for each move.
						TimeListPlayer2.add((int)temp);//Stores the number to the array-list.
					}
				if (event.getSource() == Frames.Player2Button1a) {
					moves2++;//Increments the number of moves by 1. 
					numValueRight1.setText(newNum.clicked(5));//calls the case that button 5 is pressed.
					TopField.setText("Right has moved. It's Left's Turn!");
					turn = 1;//Set it to be left side's turn.
					watch2.start();
				} else if (event.getSource() == Frames.Player2Button1b) {
					moves2++;
					numValueRight1.setText(newNum.clicked(6));//calls the case that button 6 is pressed.
					TopField.setText("Right has moved. It's Left's Turn!");
					turn = 1;//Set it to be left side's turn.
					watch2.start();
				} else if (event.getSource() == Frames.Player2Button2a) {
					moves2++;
					numValueRight2.setText(newNum.clicked(7));//calls the case that button 7 is pressed.
					TopField.setText("Right has moved. It's Left's Turn!");
					turn = 1;//Set it to be left side's turn.
					watch2.start();
				} else if (event.getSource() == Frames.Player2Button2b) {
					moves2++;
					numValueRight2.setText(newNum.clicked(8));//calls the case that button 8 is pressed.
					TopField.setText("Right has moved. It's Left's Turn!");
					turn = 1;//Set it to be left side's turn.
					watch2.start();
				} 
				else {
					TopField.setText("Wrong Move, it's player 2 (Right)'s turn!");
					//Case that a player 1's button is pressed mistakenly.
				}
				if (Integer.valueOf(numValueRight1.getText()) == FinalNum
						&& Integer.valueOf(numValueRight2.getText()) == FinalNum) {
					//Both numbers of player 2 reach the final number
					TopField.setText("Player 2 Wins! Congratulations!");
					run = false;
				}
			}
			
		}
		}
			
				//Each player are detected and their times are recorded separately. 
		
			


		Player1Button1a = new JButton("→ ");
		Player1Button1b = new JButton("↘");
		Player1Button2a = new JButton("↗");
		Player1Button2b = new JButton("→ ");
		Player2Button1a = new JButton("←");
		Player2Button1b = new JButton("↙");
		Player2Button2a = new JButton("↖");
		Player2Button2b = new JButton("←");
//Initializes all the buttons
		ActionListener Buttonlistener1 = new AddButtonListener1();
		ActionListener Buttonlistener2 = new AddButtonListener2();
		Player1Button1a.addActionListener(Buttonlistener1);
		Player1Button1b.addActionListener(Buttonlistener1);
		Player1Button2a.addActionListener(Buttonlistener1);
		Player1Button2b.addActionListener(Buttonlistener1);
		Player2Button1a.addActionListener(Buttonlistener2);
		Player2Button1b.addActionListener(Buttonlistener2);
		Player2Button2a.addActionListener(Buttonlistener2);
		Player2Button2b.addActionListener(Buttonlistener2);//These listeners are useful for manipulating the numbers
		
		Player1Button1a.addActionListener(Buttonlistener2);
		Player1Button1b.addActionListener(Buttonlistener2);
		Player1Button2a.addActionListener(Buttonlistener2);
		Player1Button2b.addActionListener(Buttonlistener2);
		Player2Button1a.addActionListener(Buttonlistener1);
		Player2Button1b.addActionListener(Buttonlistener1);
		Player2Button2a.addActionListener(Buttonlistener1);
		Player2Button2b.addActionListener(Buttonlistener1);//The addition of these listeners are in case a mistake in whose turn it is happens.

	}// Add the listener to all buttons.

	private void createButtonsPanel() {
		ButtonsPanel.setLayout(new BorderLayout());
		JLabel middleBack = new JLabel(new ImageIcon("/Users/ouiku/Desktop/electric_laser_flame_wallpaper10.jpg"));
		//Add the background to the buttons panel. 
		ButtonsPanel.add(middleBack);
		
		middleBack.setLayout(new GridLayout(4, 5)); //the layout is 4 rows and 5 columns.
		middleBack.add(Player1Button1a);
		middleBack.add(new JLabel(" "));
		middleBack.add(new JLabel(" "));
		middleBack.add(new JLabel(" ")); //Eye-pleasing space between the buttons on the two sides.
		middleBack.add(Player2Button1a);
		middleBack.add(Player1Button1b);
		middleBack.add(new JLabel(" "));
		middleBack.add(new JLabel(" "));
		middleBack.add(new JLabel(" "));
		middleBack.add(Player2Button1b);
		middleBack.add(Player1Button2a);
		middleBack.add(new JLabel(" "));
		middleBack.add(new JLabel(" "));
		middleBack.add(new JLabel(" "));
		middleBack.add(Player2Button2a);
		middleBack.add(Player1Button2b);
		middleBack.add(new JLabel(" "));
		middleBack.add(new JLabel(" "));
		middleBack.add(new JLabel(" "));
		middleBack.add(Player2Button2b);
	}//Adds all buttons to the panel

}
