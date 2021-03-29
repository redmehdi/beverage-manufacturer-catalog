import com.red.one.haufe.CatalogueApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CatalogueApplication.class}) // the actual configuration
public class TestApplication {
}