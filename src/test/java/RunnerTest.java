import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        format="html:output",
        features={"src/test/java/features"},
        glue={"steps"},
        tags ={"@success"}
)

public class RunnerTest{
}
