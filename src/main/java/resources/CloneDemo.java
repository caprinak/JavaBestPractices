import java.util.Arrays;
import java.util.EmptyStackException;

public class CloneDemo {

    public class Stack {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        public Stack() {
            this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(Object e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public Object pop() {
            if (size == 0)
                throw new EmptyStackException();
            Object result = elements[--size];
            elements[size] = null; // Eliminate obsolete reference
            return result;
        }

        // Ensure space for at least one more element.
        private void ensureCapacity() {
            if (elements.length == size)
                elements = Arrays.copyOf(elements, 2 * size + 1);
        }

        // Clone method for class with references to mutable state

        /*In effect, the clone method functions as a constructor;
        you must ensure that it does no harm to the original object and that it
        properly establishes invariants on the clone. In order for the clone method
        on Stack to work properly, it must copy the internals of the stack. The easiest
        way to do this is to call clone recursively on the elements array*/
        @Override
        public Stack clone() {
            try {
                Stack result = (Stack) super.clone();
                result.elements = elements.clone();
                return result;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
           /* Note that we do not have to cast the result of elements.clone to
            Object[]. Calling clone on an array returns an array whose runtime and
            compile-time types are identical to those of the array being cloned. This is the
            preferred idiom to duplicate an array. In fact, arrays are the sole compelling use
            of the clone facility*/

        }
    }
}
