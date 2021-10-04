package huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class huffman {
	
	public static Map<Character, Integer> frequency = new HashMap<Character, Integer>();
	public static PriorityQueue<node> nodesPQ = new PriorityQueue<node>();
	public static node root = new node(null,null,null,null);

	public static void main(String[] args) {
		
		/* get input */
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		/* fill Hashmap with <Char, # of occurrences of Char in string from keyboard */
		frequency = inputFrequency(frequency,input);
		scanner.close();
		
		/* create nodes (left = null, right = null, Char, # of occurrences of Char in string from keyboard */
		nodesPQ = createNodes(nodesPQ, frequency);
		
		/* create original root of Huffman tree. */
		root = createHuffman(nodesPQ);
		
		
		/* create HuffmanTree */
         node.printBinaryTree(root, 0);
         encode(root,"");
        
        
	

	}
	
	
	/* counts occurrences of letters in output returns Map<Char, # of occurrences> */
	public static Map<Character,Integer> inputFrequency(Map<Character,Integer> map,String input){
		/* split input into char Array */
		char[] charsArray = input.toCharArray();
		
		/* fill hashmap ['Char', # of occurrences] */
		for(char i : charsArray) {
			int count = 0;                                                			
			for(char j : charsArray){
				if(i == j) {
				 count++;			 
				}
				map.put(i,count);					
			}
		}
		return map;
	}
	
	
	
	/* take Map of <Character, # of occurrences> and create nodes inside PQ*/
	public static PriorityQueue<node> createNodes(PriorityQueue<node> nodePQ,Map<Character,Integer> map){  
			// create nodes inside PQ
	        for (Map.Entry<Character,Integer> i : frequency.entrySet())  {
	        	Character character = i.getKey();
	        	Integer occurrences = i.getValue();
	        	node n = new node(null,null,occurrences,character);
//	        	System.out.println(n.getFrequency() + " " + n.getLetter().toString()); CHECK CREATION OF NODES
	        		nodePQ.add(n);
	    	    }        
	      
	        return nodePQ;
	        } 
	
	public static node createHuffman(PriorityQueue<node> nodePQ) {
		
	       //create minHeap of parent nodes
			while(nodesPQ.size() > 1) {
				node left,right,parent = new node(null,null,null,null);
				left = nodesPQ.poll();
				right = nodesPQ.poll();
				parent = new node(left,right,left.getFrequency()+right.getFrequency(),null);
				nodesPQ.offer(parent);
			}
			return nodesPQ.poll();
			
		}
	
	 public static void encode(node root, String s)
	    {
	        if (root.getLeft() == null && root.getRight() == null && Character.isLetter(root.getLetter()) || Character.isWhitespace(root.getLetter())) {
	            System.out.println(root.getLetter() + ":" + s);
	            return;
	        } 	        
	        encode(root.getLeft(), s + "0");
	        encode(root.getRight(), s + "1");
	    }
		
}
	
	