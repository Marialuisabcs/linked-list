

public interface List {
	
	// Retorna o valor armazenado na posicao pos da minha lista
	Object get(int pos);
	
	// Adiciona um valor na posicao pos da minha lista
	boolean add(int pos, Object item);
	
	// Adiciona um valor na PRIMEIRA posicao da lista
	boolean add(Object item);
	
	// Remove o no na posicao pos
	boolean remove(int pos);
	
	// Retorna TRUE se a lista esta VAZIA; FALSE em caso contrario
	boolean isEmpty();
	
	// Retorna o TAMANHO da minha lista
	int size();
}
