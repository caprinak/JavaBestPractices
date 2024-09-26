import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class Plant {
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    // Using an EnumMap to associate data with an enum
    public static Map<LifeCycle, Set<Plant>> getPlantsByLifeCycle(List<Plant> garden) {
        Map<LifeCycle, Set<Plant>> plantsByLifeCycle =
                new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());
        for (Plant p : garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        System.out.println(plantsByLifeCycle);

     /*   // Using a stream and an EnumMap to associate data with an enum
        Map<LifeCycle, Set<Plant>> plantsByLifeCycle = garden.stream()
                .collect(groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(LifeCycle.class), toSet()));
// LifeCycle.class set to EnumMap is a bounded key token*/
        return plantsByLifeCycle;

    }

    public static void test() {
        Plant guava = new Plant("guava", LifeCycle.PERENNIAL);
        Plant cherry = new Plant("cherry", LifeCycle.PERENNIAL);
        Plant bina = new Plant("bina", LifeCycle.ANNUAL);

        System.out.println(getPlantsByLifeCycle(List.of(guava,cherry,bina)));

    }
}

