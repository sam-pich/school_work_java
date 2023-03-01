public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {
        // Your code here.
        elems = (E[]) new Object[capacity];
        top = 0;
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() {
        return elems[ top-1 ];
    }

    @SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack
    public E pop() {
        // Your code here.
        if (elems[getCapacity()-DEFAULT_INC] == null) {
            E[] temp = (E[]) new Object[getCapacity()-DEFAULT_INC];
            for (int i = 0; i<getCapacity()-DEFAULT_INC; i++) {
                temp[i] = elems[i];
            }
            E saved = elems[--top];
            elems[top] = null;
            elems = temp;
            return saved;
        } else {        
            E saved = elems[ -- top];

            elems[top] = null;
            
            return saved;
        }
        
    }

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) {
        // Your code here.


        if (elems[getCapacity()-1] != null) {
            E[] temp = (E[]) new Object[getCapacity() + DEFAULT_INC];
            for (int i = 0; i<getCapacity()+DEFAULT_INC; i++){
                temp[i] = elems[i];
            }
            elems [top++] = element;
            elems = temp;
        } else if (elems[getCapacity()-DEFAULT_INC] == null && elems[getCapacity()-26] == null) {
            E[] temp = (E[]) new Object[getCapacity()-DEFAULT_INC];
            for (int i = 0; i<getCapacity()-DEFAULT_INC; i++) {
                temp[i] = elems[i];
            }
            elems[top++] = element;
            elems = temp;
        } else elems [top ++] = element;
        // make an else if statement for this so that it reduces array size when you come back
 
    }

    @SuppressWarnings( "unchecked" )

    public void clear() {
        // Your code here.
        elems = (E[]) new Object[getCapacity()];
        top = 0;
    }

}