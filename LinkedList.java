public class LinkedList implements List {
	Node head;
	int size;
	
	public LinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	public LinkedList(Node newNode) {
		this.head = newNode;
		this.size = 1;
	}
	
	public LinkedList (Object value) {
		Node newNode = new Node(value);
		this.head = newNode;
		this.size = 1;
	}

	@Override
	public Object get(int pos) {
		if(pos<0 || pos >= size) {
			return null;
		}
		else {
			Node aux = this.head;
			for(int i=0; i<pos; i++)
				aux = aux.next;
			return aux.value;
		}
	}
	
	public Node getNode(int pos) {
		if(pos<0 || pos >= size) {
			return null;
		}
		else {
			Node aux = this.head;
			for(int i=0; i<pos; i++)
				aux = aux.next;
			return aux;
		}
	}

	@Override
	
	public boolean add(int pos, Object item) {
		Node aux;
		if(pos < 0 || pos > size) {
			return false;
		}
		else {			
			if(pos == 0)
				add(item);
			else {
				Node newNode = new Node(item);
				aux = this.head;
				for(int i=0; i<pos-1; i++)
					aux = aux.next;
				newNode.next = aux.next;
				aux.next = newNode;
				size++;					
			}
			return true;
		}			
	}

	@Override
	//Inserir um novo valor na primeira posição da lista
	public boolean add(Object item) {
		//Node newNode = new Node(item);
		//newNode.next = this.head;
		Node newNode = new Node(item, head);
		this.head = newNode;
		size++;
		return true;
	}

	@Override
	public boolean remove(int pos) {
		Node aux;		
		if(pos < 0 || pos >= size) {
			return false;
		}		
		else if (pos == 0) {
			head = head.next;
		}		
		else {
			aux = head;
			for(int i = 0; i < pos - 1; i++)
				aux = aux.next;
			aux.next = aux.next.next;
		}		
		size--;
		
		return true;
	}

	@Override
	public boolean isEmpty() {		
		return (size == 0);
	}

	@Override
	public int size() {		
		return size;
	}
	
	public String toString() {
		String content = "";
		Node aux = head;
		
		while(aux != null) {
			content += aux.value + "\n";
			aux = aux.next;
		}
		
		return content;
	}
	
	public void concat (LinkedList otherList) {
		Node aux = head;
		while(aux.next != null)
			aux = aux.next;
		aux.next = otherList.head;
	}
	
	public void trocarElementos(int pos1, int pos2) {//Trocas dois nós em uma lista
		if(pos1>pos2) {
			int aux = pos1;
			pos1 = pos2;
			pos2 = aux;
		}
		boolean tail=false;
		if(get(pos2+1)==null)
			tail=true;			
		
		Node p1=getNode(pos1), p2=getNode(pos2);
		if(tail) {
			Node prox1=getNode(pos1+1), ant1=getNode(pos1-1);
			ant1.next = p2;
			p2.next = p1.next;
			p1.next = null;
			prox1.next = p1;			
		}			
		
		else if (pos1!=1){
			Node prox1=getNode(pos1+1), prox2=getNode(pos2+1), ant1=getNode(pos1-1);
			ant1.next = p2;
			p2.next = p1.next;
			p1.next = prox2;
			prox1.next = p1;
		}
		
		else if(pos1==1) {
			Node prox1=getNode(pos1+1), prox2=getNode(pos2+1);
			head = p2;
			p2.next = p1.next;
			prox1.next = p1;
			p1.next = prox2;
		}					
	}
	
	public void inverteLista() {
		//inverter uma lista
		
	}
	

	public static void main(String[]args) {
		LinkedList newList = new LinkedList();
		//LinkedList otherList = new LinkedList();
		newList.add("Terceiro");
		newList.add("Segundo");
		newList.add("Primeiro");
		
		
		//System.out.println(newList.toString());
		//System.out.println("=============================\n");
		
		//System.out.println(newList.toString()+"\n");
		//System.out.println("=============================\n");
		newList.trocarElementos(2, 3);
		System.out.println("Lista trocada\n"+newList.toString());
		
		/*
		newList.add(2, "Quarto");
		newList.add(1, "Quinto");
		
		System.out.println(newList.toString());
		System.out.println("=============================");
		
		newList.remove(0);
		newList.remove(2);
		
		System.out.println(newList.toString());
		System.out.println("=============================");
		
		otherList.add("blablabla");
		otherList.add("blabla");
		otherList.add("bla");
		newList.concat(otherList);
		System.out.println(otherList.toString());*/
			
		
	}
	

}
