package writer;

import hello.bean.Name;
import hello.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= Application.class)
public class WriterTest {

    public void testWriter() {
        FlatFileItemWriter flatFileItemWriter = new FlatFileItemWriter();
        flatFileItemWriter.setResource(new FileSystemResource("writeFile"));

        DelimitedLineAggregator delimitedLineAggregator = new DelimitedLineAggregator();
        BeanWrapperFieldExtractor beanWrapperFieldExtractor = new BeanWrapperFieldExtractor();
        delimitedLineAggregator.setDelimiter(",");
        beanWrapperFieldExtractor.setNames(new String[]{"name", "credit"});
        delimitedLineAggregator.setFieldExtractor(beanWrapperFieldExtractor);
        flatFileItemWriter.setLineAggregator(delimitedLineAggregator);
    }

    @Test
    public void BeanWrapperFieldExtractorTest() {
        BeanWrapperFieldExtractor<Name> extractor = new BeanWrapperFieldExtractor<Name>();
        extractor.setNames(new String[] { "first", "last", "born" });

        String first = "Alan";
        String last = "Turing";
        int born = 1912;

        Name n = new Name(first, last, born);
        Object[] values = extractor.extract(n);

        assertEquals(first, values[0]);
        assertEquals(last, values[1]);
        assertEquals(born, values[2]);
    }
}
