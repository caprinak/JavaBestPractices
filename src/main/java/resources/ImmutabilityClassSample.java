public class ImmutabilityClassSample {

    // Immutable complex number class
    public final class Complex {
        private final double re;
        private final double im;

        public Complex(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double realPart() {
            return re;
        }

        public double imaginaryPart() {
            return im;
        }

        public Complex plus(Complex c) {
            return new Complex(re + c.re, im + c.im);
        }

        public Complex minus(Complex c) {
            return new Complex(re - c.re, im - c.im);
        }

        public Complex times(Complex c) {
            return new Complex(re * c.re - im * c.im,
                    re * c.im + im * c.re);
        }

        public Complex dividedBy(Complex c) {
            double tmp = c.re * c.re + c.im * c.im;
            return new Complex((re * c.re + im * c.im) / tmp,
                    (im * c.re - re * c.im) / tmp);
        }

        @
                Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof Complex))
                return false;
            Complex c = (Complex) o;
// See page 47 to find out why we use compare instead of ==
            return Double.compare(c.re, re) == 0
                    && Double.compare(c.im, im) == 0;
        }

        @
                Override
        public int hashCode() {
            return 31 * Double.hashCode(re) + Double.hashCode(im);
        }

        @
                Override
        public String toString() {
            return "(" + re + " + " + im + "i)";

        }
    }
}

/*
    In addition to the standard Object methods, it provides
        accessors for the real and imaginary parts and provides the four basic arithmetic operations: addition, subtraction, multiplication,
         and division. Notice how the arithmetic operations create and return a new Complex instance rather than modifying this instance.
      This pattern is known as the functional approach because methods return the result of applying a function to their operand,
    without modifying it. The functional approach may appear unnatural if you’re not familiar with it, but it enables immutability, which has
    many advantages. Immutable objects are simple. An immutable object can be in exactly one state, the state in which it was created.
Immutable objects are inherently thread-safe; they require no synchronization. They cannot be corrupted by multiple threads accessing them
concurrently. This is far and away the easiest approach to achieve thread safety. Since no thread can ever observe any effect of another thread on an immutable
object, immutable objects can be shared freely. Immutable classes should therefore encourage clients to reuse existing instances wherever possible. One
easy way to do this is to provide public static final constants for commonly used values. For example, the Complex class might provide these constants:

                public static final Complex ZERO = new Complex(0, 0);
                public static final Complex ONE = new Complex(1, 0);
                public static final Complex I = new Complex(0, 1);
                         */
