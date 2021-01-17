import lesson6.Tasker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestFirstTask {
    private int[] result;
    private int[] tested;
    Tasker tasker;

    public TestFirstTask(int[] tested, int[] result) {
        this.result = result;
        this.tested = tested;
    }

    @Before
    public void init() {
        tasker = new Tasker();
    }

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new int[][][]{
                {{1,2,3,4,5,6},{5,6}},
                {{1,2,3,5,6,4},{}},
                {{1,4,5,6,2,3},{5,6,2,3}}
        });
    }

    @Test
    public void test_SublistAfterLastNumber(){
//        Assert.assertArrayEquals(result, tasker.sublistAfterLastNumber(tested));
    }
}
