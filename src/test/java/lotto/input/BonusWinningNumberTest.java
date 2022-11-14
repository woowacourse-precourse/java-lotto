package lotto.input;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BonusWinningNumberTest {
    List<Integer> testValue = Arrays.asList(1, 2, 3, 4, 5, 6);
    BonusWinningNumber bonusWinningNumber = new BonusWinningNumber();

    @Test
    void putBonusNumTest() {
        String InputTestCase1 = "10";
        String InputTestCase2 = "1";
        System.setIn(new ByteArrayInputStream(InputTestCase1.getBytes()));
        assertThat(bonusWinningNumber.putBonusNum(testValue)).isEqualTo(Integer.parseInt(InputTestCase1));

        System.setIn(new ByteArrayInputStream(InputTestCase2.getBytes()));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> bonusWinningNumber.putBonusNum(testValue));
    }//putBonusNumTest
}//end class
