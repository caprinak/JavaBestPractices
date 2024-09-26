import java.math.BigInteger;

public class ThreadSafeGet {
    public static BigInteger safeInstance(BigInteger val) {
        return val.getClass() == BigInteger.class ?
                val : new BigInteger(val.toByteArray());
    }
}
