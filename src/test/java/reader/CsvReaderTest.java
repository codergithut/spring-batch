package reader;

import hello.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.junit4.SpringRunner;
import hello.bean.CustomerInfo;
import hello.bean.Player;
import reader.mapper.PlayerFieldSetMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= Application.class)
public class CsvReaderTest {

    @Test
    public void testReader() throws Exception {
        FlatFileItemReader<Player> itemReader = new FlatFileItemReader<Player>();
        itemReader.setResource(new FileSystemResource("players.csv"));
        DefaultLineMapper<Player> lineMapper = new DefaultLineMapper<Player>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames(new String[] {"ID", "lastName","firstName","position","birthYear","debutYear"});
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(new PlayerFieldSetMapper());
        itemReader.setLineMapper(lineMapper);
        itemReader.open(new ExecutionContext());
        Player player = itemReader.read();
        System.out.println(player.getBirthYear());
    }

    @Test
    public void testReaderWrap() throws Exception {

        /**
         * 对象封装
         */
        BeanWrapperFieldSetMapper beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<Player>();
        beanWrapperFieldSetMapper.setTargetType(Player.class);

        /**
         * 数据头封装
         */
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames(new String[] {"ID", "lastName","firstName","position","birthYear","debutYear"});

        /**
         * 封装集合组合
         */
        DefaultLineMapper defaultLineMapper = new DefaultLineMapper<Player>();
        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
        defaultLineMapper.setLineTokenizer(tokenizer);

        FlatFileItemReader<Player> itemReader = new FlatFileItemReader<Player>();
        itemReader.setResource(new FileSystemResource("players.csv"));

        itemReader.setLineMapper(defaultLineMapper);
        itemReader.open(new ExecutionContext());
        Player player = itemReader.read();

        System.out.println(player.getBirthYear());
    }

    @Test
    public void testReaderSplit() throws Exception {
        FixedLengthTokenizer fixedLengthTokenizer = new FixedLengthTokenizer();
        Range[] ranges = new Range[] {new Range(1, 12), new Range(13, 15), new Range(16, 20), new Range(21, 29)};
        String[] titles = new String[] {"ISIN" , "Quantity" , "Price" , "Customer"};
        fixedLengthTokenizer.setColumns(ranges);
        fixedLengthTokenizer.setNames(titles);

        /**
         * 对象封装
         */
        BeanWrapperFieldSetMapper beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<Player>();
        beanWrapperFieldSetMapper.setTargetType(CustomerInfo.class);

        /**
         * 封装集合组合
         */
        DefaultLineMapper defaultLineMapper = new DefaultLineMapper<CustomerInfo>();
        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
        defaultLineMapper.setLineTokenizer(fixedLengthTokenizer);


        /**
         * 数据信息
         */
        FlatFileItemReader<CustomerInfo> itemReader = new FlatFileItemReader<CustomerInfo>();
        itemReader.setResource(new FileSystemResource("format.csv"));

        itemReader.setLineMapper(defaultLineMapper);
        itemReader.open(new ExecutionContext());
        CustomerInfo player = itemReader.read();

        System.out.println(player.getCustomer());

    }





}
