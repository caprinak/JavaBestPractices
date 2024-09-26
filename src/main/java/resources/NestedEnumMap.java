import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class NestedEnumMap {
    // Using a nested EnumMap to associate data with enum pairs
    public enum Phase {
        SOLID, LIQUID, GAS;
        public enum Transition {
            MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
            BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
            SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);
            private final Phase from;
            private final Phase to;
            Transition(Phase from, Phase to) {
                this.from = from;
                this.to = to;
            }
            // Initialize the phase transition map
            private static final Map<Phase, Map<Phase, Transition>>
                    m = Stream.of(values()).collect(groupingBy(t -> t.from,
                    () -> new EnumMap<>(Phase.class),
                    toMap(t -> t.to, t -> t,
                            (x, y) -> {
                        System.out.println("x " + x);
                                System.out.println("y " + y);
                            return y;
                        }, () -> new EnumMap<>(Phase.class))));

      /*      The merge
            function in the second collector ((x, y) -> y)) is unused; it is required only
            because we need to specify a map factory in order to get an EnumMap, and
            Collectors provides telescoping factories.*/
            public static Transition from(Phase from, Phase to) {
                return m.get(from).get(to);
            }
        }
    }
    public static void test(){
        System.out.println(Phase.Transition.from(Phase.GAS,Phase.SOLID));
    }

}
