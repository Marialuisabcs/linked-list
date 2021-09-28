public class Node{
	 Object value;
	 Node next;

	public Node(){
		this(null, null);
	}
	
	public Node(Object value) {
		this(value, null);
	}

	public Node(Object value, Node next){
		this.value = value;
		this.next = next;
	}

	
	
}