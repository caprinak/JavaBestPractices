package Lambda;

import Annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class FlatMapDemo {
    List<List<String>> nestedList = asList(
            asList("one:one"),
            asList("two:one", "two:two", "two:three"),
            asList("three:one", "three:two", "three:three", "three:four"));

    public <T> List<T> flattenListOfListsImperatively(
            List<List<T>> nestedList) {
        List<T> ls = new ArrayList<>();
        nestedList.forEach(ls::addAll);
        return ls;
    }
    @Test
    public void givenNestedList_thenFlattenImperatively() {
        List<String> ls = flattenListOfListsImperatively(nestedList);

        assertNotNull(ls);
        assertTrue(ls.size() == 8);
        assertThat(ls, IsIterableContainingInOrder.contains(
                "one:one",
                "two:one", "two:two", "two:three", "three:one",
                "three:two", "three:three", "three:four"));
    }
}
