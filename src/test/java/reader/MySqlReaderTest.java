package reader;

import hello.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.database.HibernateCursorItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.hibernate.SessionFactory;
import org.springframework.test.context.junit4.SpringRunner;
import reader.mapper.CustomerCreditRowMapper;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= Application.class)
public class MySqlReaderTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void testReader() throws Exception {
        JdbcCursorItemReader itemReader = new JdbcCursorItemReader();
        itemReader.setDataSource(dataSource);
        itemReader.setSql("SELECT ID, NAME, CREDIT from CUSTOMER");
        itemReader.setRowMapper(new CustomerCreditRowMapper());
        int counter = 0;
        ExecutionContext executionContext = new ExecutionContext();
        itemReader.open(executionContext);
        Object customerCredit = new Object();
        while(customerCredit != null){
            customerCredit = itemReader.read();
            counter++;
        }
        itemReader.close();
    }

    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void testHiberMystReader() throws Exception {
        HibernateCursorItemReader itemReader = new HibernateCursorItemReader();
        itemReader.setQueryString("from CustomerCredit");
//For simplicity sake, assume sessionFactory already obtained.
        itemReader.setSessionFactory(sessionFactory);
        itemReader.setUseStatelessSession(true);
        int counter = 0;
        ExecutionContext executionContext = new ExecutionContext();
        itemReader.open(executionContext);
        Object customerCredit = new Object();
        while(customerCredit != null){
            customerCredit = itemReader.read();
            counter++;
        }
        itemReader.close();
    }
}
