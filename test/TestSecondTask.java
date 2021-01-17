import lesson6.Tasker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestSecondTask {
    private int[] tested;
    Tasker tasker;


    public TestSecondTask(int[] tested) {
        this.tested = tested;
    }

    @Before
    public void init() {
        tasker = new Tasker();
    }

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new int[][]{
                {1, 1, 1, 1, 1, 4},
                {4, 4, 4, 4},
                {1, 1, 4, 1, 1, 1},
                {1, 1, 1, 4, 1, 1},
                {4, 1, 1, 4, 2, 1},
                {4, 1, 1, 4, 2, 3},
                {1, 1, 1, 1, 1, 1}
        });
    }

    @Test
    public void test_SublistAfterLastNumber(){
//        Assert.assertTrue(tasker.checkArray(tested));
    }
}