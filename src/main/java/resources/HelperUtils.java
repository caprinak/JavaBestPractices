public class HelperUtils {
    public static OperationEnum inverse(OperationEnum op) {
        switch(op) {
            case PLUS: return OperationEnum.MINUS;
            case MINUS: return OperationEnum.PLUS;
            case TIMES: return OperationEnum.DIVIDE;
            case DIVIDE: return OperationEnum.TIMES;
            default: throw new AssertionError("Unknown op: " + op);
        }}
}
