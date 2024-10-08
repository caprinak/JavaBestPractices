package Lambda;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

public class Mersenne {
    public static void main(String[] args) {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(20))
                .limit(20)
               /* .forEach(System.out::println);*/
        .forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
    }
        static Stream<BigInteger> primes () {
            return Stream.iterate(TWO, BigInteger::nextProbablePrime);
        }
    }
