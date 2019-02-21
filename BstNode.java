package Game;
/**
 * 
 * A class that sets up the nodes as a part of the binary
 * search tree.
 */
public class BstNode {
	public BstNode(int i) // Constructor
	{
		leftNode = null;
		rightNode = null;
		intData = i;
	}

	public int intData;
	public BstNode leftNode;
	public BstNode rightNode;
}
