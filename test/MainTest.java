import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class MainTest {
    public static void main(String[] args) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));

        Result result = junit.run(
                TestFirstTask.class,
                TestSecondTask.class);

        resultReport(result);
    }

    public static void resultReport(Result result) {
        System.out.println("Закончено. Результы: \n" +
                "С ошибкой: " + result.getFailureCount() + ".\n " +
                "Ignored: " + result.getIgnoreCount() + ".\n" +
                " Tests run: " + result.getRunCount() + ".\n" +
                " Time: " + result.getRunTime() + "ms.");
    }
}
