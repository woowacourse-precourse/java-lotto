package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrizeNumTest extends NsTest {

    @AfterEach
    void afterEach() {
        PrizeNum.prizeClear();
    }

    @Test
    @DisplayName("로또 당첨 번호가 중복으로 들어오면 예외 발생")
    void createDuplicateLottoNumber() {
        String inputPrize = "1,2,3,4,5,5";

        assertThatThrownBy(() -> PrizeNum.setPrizeNum(inputPrize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 당첨 번호가 6개가 아니면 예외 발생")
    void createNotSixLottoNumber() {
        String inputPrize = "1,2,3,4,5";

        assertThatThrownBy(() -> PrizeNum.setPrizeNum(inputPrize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유효한 로또 당첨 번호면 로또 당첨 번호 List 생성")
    void createPrizeWithPrizeNum() {
        PrizeNum.setPrizeNum("1, 2, 3, 4, 5, 6");
        List<Integer> expectedPrize = List.of(1, 2, 3, 4, 5, 6);

        assertEquals(expectedPrize, PrizeNum.getPrize());
    }



    @Override
    protected void runMain() {

    }
}
