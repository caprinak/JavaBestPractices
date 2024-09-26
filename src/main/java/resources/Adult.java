public class Adult {
    public static void main(String[] args) {
        try (Room myRoom = new Room(7)) {
            System.out.println("Goodbye");

        }
        Teenager.neverClean();
    }
    public class Teenager {
        public static void neverClean() {new Room(99);
            System.out.println("Peace out");
            System.gc();
        }

    }
}
/*
    In summary, don’t use cleaners, or in releases prior to Java 9, finalizers,
        except as a safety net or to terminate noncritical native resources. Even then,
        beware the indeterminacy and performance consequences*/
