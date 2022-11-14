package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


class IOControllerTest {

    @Test
    void readBuyingMoneyTest() {
        InputStream in = new ByteArrayInputStream("abc".getBytes());
        System.setIn(in);
        Assertions.assertThrows(IllegalArgumentException.class, IOController::readBuyingMoney);

        in = new ByteArrayInputStream("12345".getBytes());
        System.setIn(in);
        Assertions.assertThrows(IllegalArgumentException.class, IOController::readBuyingMoney);

        in = new ByteArrayInputStream("14000".getBytes());
        System.setIn(in);
    }

}
