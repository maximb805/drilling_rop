//import edu.analytics.rop.Main;
import edu.analytics.rop.services.WellServiceAdd;
import edu.analytics.rop.config.SpringConfig;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class)
@WebAppConfiguration
public class WellServiceTest {

//    @Autowired
//    private Main main;

    @Autowired
    private WellServiceAdd add;

    @Test
    public void test() {
//        add.aaa();
//        main.fillDB();
//        System.out.println("test");
    }
}
