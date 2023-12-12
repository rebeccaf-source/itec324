package itec324;
/**
 * this is the operations class for Project 4
 * @author Rebecca Fonseth
 *
 */
public class Operations {
	Node head = null;
	Node tail = null;	//reference to the last node; feel free to use it (not mandatory though)
	/**
	 * this will fill the linked list with every multiple of 3 to 33
	 */
	void insert3x() {	//Step 1
		Node three = new Node(3);
		if (head == null) {
			head = three;
			tail = three;
			head.prev = null;
			tail.next = null;
		}
		int i = 2;
		int count = 1;
		while (count != 33) {
			count = 3 * i;
			Node nextNode = new Node(count);
			tail.next = nextNode;
			nextNode.prev = tail;
			tail = nextNode;
			tail.next = null;
			i++;
		}
	}
	/**
	 * this will print the linked list from head to tail
	 */
	void printForward() {	//Steps 2, 4, and 8
		if(head != null)
		{
			Node temp = head;
			//System.out.println(temp.next.data);
			while(temp != null)
			{
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
			System.out.println();
		}
	}
	/**
	 * this will insert a number before and after every node that isn't a multiple of 6
	 */
	void insertAdjacents3x_Non6x() {	//Step 3: tail to head
		
		if(tail != null)
		{
			
			Node temp = tail;
			while (temp != null) {
				
				if(temp.data % 6 != 0)
				{
					int bigger = temp.data + 1;
					int smaller = temp.data - 1;
					
					insertAfter(temp, bigger);
					insertBefore(temp, smaller);
					if(temp.prev != null)
					{
						temp = temp.prev;
					}
					else
					{
						break;
					}
				}
				if(temp.prev != null)
				{
					temp = temp.prev;
				}
				else
				{
					break;
				}
				

			}

		}
		
	}
	/**
	 * this is a helper method to insert a node after a given node
	 * @param prev_node the given node
	 * @param new_data the value going into the new node being inserted
	 */
	private void insertAfter(Node prev_node, int new_data)
	{
		if(prev_node == tail)
		{
			Node new_node = new Node(new_data);
			tail.next = new_node;
			new_node.prev = tail;
			tail = new_node;
			tail.next = null;
		}
		else if(prev_node != null)
		{
			Node new_node = new Node(new_data);
			new_node.next = prev_node.next;
			prev_node.next = new_node;
			new_node.prev = prev_node;
			if(new_node.next != null) 
			{
				new_node.next.prev = new_node;
			}
		}
	}
	/**
	 * this is a helper method to insert a node before a given node
	 * @param next_node the given node
	 * @param new_data the value going into the new node being inserted
	 */
	private void insertBefore(Node next_node, int new_data)
	{
		if(next_node != null)
		{
			Node new_node = new Node(new_data);
			new_node.prev = next_node.prev;
			next_node.prev = new_node;
			new_node.next = next_node;
			if(new_node.prev != null) 
			{
				new_node.prev.next = new_node;
			}
		}
	}
	/**
	 * This inserts two adjacent numbers to values that are multiples of 6
	 */
	void insertAdjacents6x() {		//Step 5: head to tail
		if(head != null)
		{
			
			Node temp = head;
			while (temp != null) {
				
				if(temp.data % 6 == 0)
				{

					int bigger = temp.data + 1;
					int smaller = temp.data - 1;
					
					insertAfter(temp, bigger);
					insertBefore(temp, smaller);
					if(temp.next != null)
					{
						temp = temp.next;
					}
					else
					{
						break;
					}
				}
				if(temp.next != null)
				{
					temp = temp.next;
				}
				else
				{
					break;
				}
				

			}

		}
	}
	/**
	 * this prints the linked list from tail to head
	 */
	void printBackward() {		//Step 6
		if(tail != null)
		{
			Node temp = tail;
			System.out.print(temp.data + " ");
			while(temp.prev  != null)
			{
				temp = temp.prev;
				System.out.print(temp.data + " ");
			}
			System.out.println();
		}
	}
	/**
	 * this is a helper method to delete a node
	 * @param current the node being deleted
	 */
	void deleteNode(Node current) {
		if (current != null) {
			if (head != null && head.data == current.data) {
				head = head.next;
				return;
			}
			
			if (current.next != null) {
				current.next.prev = current.prev;
			}
			if (current.prev != null) {
				current.prev.next = current.next;
			}
			current = null;
		}
	}
	/**
	 * this is used to delete every node whose value is not a multiple of 4
	 */
	void deleteNon4x() {	//Step 7: tail to headS
		if(tail != null)
		{
			Node temp = tail;
			while (temp != null) {
				if(temp.data % 4 != 0)
				{
					deleteNode(temp);
				}
				
				temp = temp.prev;

			}

		}
		
	}	

}
