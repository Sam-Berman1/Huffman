package huffman;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import huffman.TreePrinter.node;

public class node implements Comparable<node> {

	@SuppressWarnings("unused")
	private node left, right;
	private Integer frequency;
	private Character letter;
	
	public node(node left, node right, Integer frequency, Character letter) {
		this.setLeft(left);
		this.setRight(right);
		this.setFrequency(frequency);
		this.setLetter(letter);
		
	}

	public node getLeft() {
		return left;
	}

	private void setLeft(node left) {
		this.left = left;
	}
	
	public node getRight() {
		return right;	
	}

	private void setRight(node right) {
		this.right = right;
	}

	public Character getLetter() {
		return letter;
	}

	public void setLetter(Character letter) {
		this.letter = letter;
	}

	public Integer getFrequency() {
		return frequency;
	}

	private void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	@Override
	public int compareTo(node o) {
		// TODO Auto-generated method stub
		return this.getFrequency().compareTo(o.getFrequency());
	}
	
	public static boolean isLeaf(node o) {
		if(o.getLeft() == null && o.getRight() == null) {
			return true;
		}
		return false;
	}
		
	public void inorderPrint( )
	{
	   if (left != null)
	      left.inorderPrint( );
	   System.out.println(frequency);
	   if (right != null)
	      right.inorderPrint( );
	}  
	
	
	public static void printBinaryTree(node root, int level){
	    if(root==null)
	         return;
	    printBinaryTree(root.right, level+1);
	    if(level!=0){
	        for(int i=0;i<level-1;i++)
	            System.out.print("|\t");
	            System.out.println("|-------"+ root.letter + ":" +root.frequency);
	    }
	    else
	        System.out.print(root.letter + ":" + root.frequency);
	    printBinaryTree(root.left, level+1);
	}    
	
	public static void printRoot(node view) {
		System.out.println("my value: " + view.getFrequency() 
		+ "\nleft letter: " + view.getLeft().getLetter() + " left frequency: " + view.getLeft().getFrequency() 
		+ "\nright letter: " + view.getRight().getLetter() + " right frequency: " + view.getRight().getFrequency() + "\n");
	}
}
