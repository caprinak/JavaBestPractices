// Enum type with constant-specific class bodies and data
public enum OperationEnum {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };
    private final String symbol;

    OperationEnum(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public abstract double apply(double x, double y);

    // Switch on an enum to simulate a missing method
    public static OperationEnum inverse(OperationEnum op) {
        switch(op) {
            case PLUS: return OperationEnum.MINUS;
            case MINUS: return OperationEnum.PLUS;
            case TIMES: return OperationEnum.DIVIDE;
            case DIVIDE: return OperationEnum.TIMES;
            default: throw new AssertionError("Unknown op: " + op);
        }}

    public static void test(){
        double x = 4;
        double y = 2;
        for (OperationEnum op : OperationEnum.values())
            System.out.printf("%f %s %f = %f%n",
                x, op, y, op.apply(x, y));
    }
}
/*
    Use enums any time you need a set of
        constants whose members are known at compile time. Of course, this
        includes “natural enumerated types,” such as the planets, the days of the week,
        and the chess pieces, choices on a menu, operation codes, and
command line flags. */
/*
In summary, the advantages of enum types over int constants are
        compelling. Enums are more readable, safer, and more powerful. Many enums
        require no explicit constructors or members, but others benefit from associating
        data with each constant and providing methods whose behavior is affected by
        this data.*/
