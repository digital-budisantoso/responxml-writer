import com.xmlwriter.example.service.IbkFullValidator;
import com.xmlwriter.example.service.IbkValidator;
import com.xmlwriter.example.service.IbkWriterSvc;

import java.net.URL;
import java.time.Duration;
import java.time.Instant;

/**
 * Created by usrdjp on 4/13/2021.
 */
    public class IbkXmlwriterExp {
        public static void main(String[] args) throws Exception {
            IbkWriterSvc writer = new IbkWriterSvc();
            writer.marshal();

        }
}
