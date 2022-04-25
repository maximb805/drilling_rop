import edu.analytics.rop.buiseness.WellService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:springContext.xml")
public class WellServiceTest {

    @Autowired
    private WellService ws;

    @Test
    public void test() {
        ws.testSave();
    }
}
