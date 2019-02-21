package Game;
/*
 * Sorts data of user's times taken for each move in a binary search tree
 */
public class BST {
   BstNode rootNode;

	public BST(int i) // constructor: Root node added at the time of creation of
	// the tree
	{
		rootNode = new BstNode(i);
	}

		public void addNode(int i) {
			BstNode currentNode = rootNode;
			boolean finished = false;
			do {
				BstNode curLeftNode = currentNode.leftNode;
				BstNode curRightNode = currentNode.rightNode;
				int curIntData = currentNode.intData;

				if (i > curIntData) // look down the right branch
				{
					if (curRightNode == null) { // create a new node referenced with
												// currentNode.rightNode
						currentNode.rightNode = new BstNode(i);
						finished = true;
					} else // keep looking by assigning a new current node one level
							// down
					{
						currentNode = currentNode.rightNode;
					}
				} else // look down the left branch
				{
					if (curLeftNode == null) { // create a new node referenced with
												// currentNode.leftNode
						currentNode.leftNode = new BstNode(i);
						finished = true;
					} else { // keep looking by assigning a new current node one
								// level down

						currentNode = currentNode.leftNode;
					}
				}
			} while (!finished);
		}
		BstNode ParentNode;
		public void printSideways() {
			printSideways(rootNode, "");
			}
		private void printSideways(BstNode root,String indent) {
			if (root != null) {
				printSideways(root.rightNode, indent + "  ");
				System.out.println(indent + root.intData);
				printSideways(root.leftNode, indent + "  ");
			}//Recursive methods to print the binary tree.
			}
}
