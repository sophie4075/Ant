import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class HelloWorldTest {

    @Test
    public void testExecute() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Act
            HelloWorld.main(new String[]{});


            String expectedOutput = "Hello World" + System.lineSeparator();
            String actualOutput = outContent.toString();


            System.err.println("Expected: " + expectedOutput);
            System.err.println("Actual: " + actualOutput);

            assertEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            throw e;
        } finally {
            // Reset the System.out
            System.setOut(originalOut);
        }
    }
}

