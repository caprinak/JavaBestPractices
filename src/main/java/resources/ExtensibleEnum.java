import java.util.Collection;

public class ExtensibleEnum {
    // Emulated extensible enum using an interface
    public interface Operation {
  /*      The basic idea is to take advantage of the fact that enum types can implement arbitrary
          interfaces by defining an interface for the opcode type and an enum that is the standard implementation of the interface.*/
        double apply(double x, double y);
    }
    public enum BasicOperation implements Operation {
        PLUS("+") {
            public double apply(double x, double y) { return x + y; }
        },
        MINUS("-") {
            public double apply(double x, double y) { return x - y; }
        },
        TIMES("*") {
            public double apply(double x, double y) { return x * y; }
        },
        DIVIDE("/") {
            public double apply(double x, double y) { return x / y; }
        };
        private final String symbol;
        BasicOperation(String symbol) {
            this.symbol = symbol;
        }
        @Override public String toString() {
            return symbol;
        }
    }
    // Emulated extension enum
    public enum ExtendedOperation implements Operation {
        EXP("^") {
            public double apply(double x, double y) {
                return Math.pow(x, y);
            }
        },
        REMAINDER("%") {
            public double apply(double x, double y) {
                return x % y;
            }
        };
        private final String symbol;

        ExtendedOperation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }
    }
    static <T extends Enum<T> & Operation> void test(
            Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants())
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
    }
    static void test2(Collection<? extends Operation> opSet,
                      double x, double y) {
        for (Operation op : opSet)
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
    }

/*    In summary, while you cannot write an extensible enum type, you can   emulate it by writing an interface to accompany a basic enum type that
     implements the interface. This allows clients to write their own enums (or other types) that implement the interface. Instances of these
     types can then be  used wherever instances of the basic enum type can be used, assuming APIs are  written in terms of the interface.*/


}
