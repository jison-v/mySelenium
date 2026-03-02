package selenium.runner;

import com.intuit.karate.Runner;
import org.testng.annotations.Test;

public class APIRunner {

    @Test
    public void testParallel() {

        Runner.Builder builder = new Runner.Builder();
        builder.path("classpath:features/api")
                .tags("@GetAllProductList")
                .parallel(5);
    }

}
