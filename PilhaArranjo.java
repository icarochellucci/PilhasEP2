class PilhaArranjo<E> implements Stack <E> {
  protected int capacity;
  public static final int CAPACITY = 1000;
  protected ArranjoIndex<E> S;
  protected int top = -1;

  public PilhaArranjo(){
    this(CAPACITY);
  }

  public PilhaArranjo(int cap){
    S = new ArranjoIndex(cap);
  }

  public int size(){ return S.size(); }

  public boolean isEmpty(){return S.isEmpty();}

  public E top() throws EmptyStackException {
    if(isEmpty()) throw new EmptyStackException("Pilha vazia");
    return S.get(size() - 1);
  }

  public void push(E element) {
    S.add(size(), element);
  }

  public E pop() throws EmptyStackException {
    if(isEmpty()) throw new EmptyStackException("Pilha vazia");
    return S.remove(size() - 1);
  }
}