package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;


class IOControllerTest {

    @Test
    void readBuyingMoneyTest() {
        InputStream in = new ByteArrayInputStream("abcde".getBytes());
        System.setIn(in);
        Assertions.assertThatThrownBy(IOController::readBuyingMoney)
                .isInstanceOf(IllegalArgumentException.class);

        in = new ByteArrayInputStream("12345".getBytes());
        System.setIn(in);
        Assertions.assertThatThrownBy(IOController::readBuyingMoney)
                .isInstanceOf(IllegalArgumentException.class);

        in = new ByteArrayInputStream("14000".getBytes());
        System.setIn(in);
        Assertions.assertThat(IOController.readBuyingMoney()).isEqualTo(14);
    }

    @Test
    void readWinningLottoTest() {
        InputStream in = new ByteArrayInputStream("1,2,3,4,5,6".getBytes());
        System.setIn(in);
        Assertions.assertThat(IOController.readWinningNumbers())
                .isEqualTo(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        in = new ByteArrayInputStream("1,2,3,4,5".getBytes());
        System.setIn(in);
        Assertions.assertThatThrownBy(IOController::readBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);

        in = new ByteArrayInputStream("1,2,3,4,5,46".getBytes());
        System.setIn(in);
        Assertions.assertThatThrownBy(IOController::readBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readBonusNumberTest() {
        InputStream in = new ByteArrayInputStream("7".getBytes());
        System.setIn(in);
        Assertions.assertThat(IOController.readBonusNumber()).isEqualTo(7);

        in = new ByteArrayInputStream("123".getBytes());
        System.setIn(in);
        Assertions.assertThatThrownBy(IOController::readBonusNumber).isInstanceOf(IllegalArgumentException.class);

        in = new ByteArrayInputStream("123".getBytes());
        System.setIn(in);
        Assertions.assertThatThrownBy(IOController::readBonusNumber).isInstanceOf(IllegalArgumentException.class);
    }

//    @Test
//    void validateNumberRangeTest() {
//        Assertions.assertThatThrownBy(() -> IOController.validateNumberRange(0))
//                .isInstanceOf(IllegalArgumentException.class);
//        Assertions.assertThatThrownBy(() -> IOController.validateNumberRange(46))
//                .isInstanceOf(IllegalArgumentException.class);
//    }

}
