package reader;

import hello.bean.CustomerCredit;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import java.util.HashMap;
import java.util.Map;

public class XmlReaderTest {

    public void testXml() throws Exception {
        StaxEventItemReader xmlStaxEventItemReader = new StaxEventItemReader<CustomerCredit>();

        FileSystemResource xmlResource = new FileSystemResource("players.csv");
        Resource resource = new ByteArrayResource("xs".getBytes());

        Map aliases = new HashMap();
        aliases.put("trade","org.springframework.batch.sample.domain.Trade");
        aliases.put("price","java.math.BigDecimal");
        aliases.put("customer","java.lang.String");
        XStreamMarshaller unmarshaller = new XStreamMarshaller();
        unmarshaller.setAliases(aliases);
        xmlStaxEventItemReader.setUnmarshaller(unmarshaller);
        xmlStaxEventItemReader.setResource(resource);
        xmlStaxEventItemReader.setFragmentRootElementName("trade");
        xmlStaxEventItemReader.open(new ExecutionContext());

        boolean hasNext = true;

        CustomerCredit credit = null;

        while (hasNext) {
            credit = (CustomerCredit)xmlStaxEventItemReader.read();
            if (credit == null) {
                hasNext = false;
            }
            else {
                System.out.println(credit);
            }
        }
    }
}
