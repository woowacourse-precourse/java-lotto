package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class IOControllerTest {

    @Test
    void readBuyingMoneyTest() {
        InputStream in = new ByteArrayInputStream("12345".getBytes());
        in = new ByteArrayInputStream("abc".getBytes());
        System.setIn(in);
        Assertions.assertThatThrownBy(IOController::readBuyingMoney).isInstanceOf(IllegalArgumentException.class);

        in = new ByteArrayInputStream("12345".getBytes());
        System.setIn(in);
        Assertions.assertThatThrownBy(IOController::readBuyingMoney).isInstanceOf(IllegalArgumentException.class);

        in = new ByteArrayInputStream("14000".getBytes());
        System.setIn(in);
        Assertions.assertThat(IOController.readBuyingMoney()).isEqualTo(14);
    }

}
