package itec324;
/**
 * this is the node class for Project 4
 *
 */
public class Node {
	int data;
	Node next;		//reference to next node
	Node prev;		//reference to previous node

	Node(int value){
		data = value;
		next = null;
		prev = null;
	}
}
