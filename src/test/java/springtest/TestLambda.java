package springtest;

import Lambda.FlatMapDemo;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TestLambda {
    @Test
    public void givenNestedList_thenFlattenImperatively() {
        List<String> ls = FlatMapDemo.givenNestedList_thenFlattenImperatively();
        assertNotNull(ls);
        assertEquals(ls.size(),7);
        assertTrue(ls.size() == 9);
        assertThat(ls, IsIterableContainingInOrder.contains(
                "one:one","two:two",
                "two:one", "two:two", "two:three", "three:one",
                "three:two", "three:three", "three:four"));
    }
}
