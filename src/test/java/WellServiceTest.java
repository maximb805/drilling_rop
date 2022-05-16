import edu.analytics.rop.buiseness.WellServiceAdd;
import edu.analytics.rop.config.SpringConfig;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class)
@WebAppConfiguration
public class WellServiceTest {

    @Autowired
    private WellServiceAdd ws;

    @Test
    public void test() {
        System.out.println("test");
    }
}
