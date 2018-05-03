package reader;

import reader.bean.Player;
import hello.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.junit4.SpringRunner;
import reader.mapper.PlayerFieldSetMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= Application.class)
public class ReaderItemTest {

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

}
