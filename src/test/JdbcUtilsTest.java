package test;

import org.junit.Test;
import utils.JdbcUtils;

public class JdbcUtilsTest {

    @Test
    public void getConnectionTest() {
        System.out.println(JdbcUtils.getConnection());
    }

}
