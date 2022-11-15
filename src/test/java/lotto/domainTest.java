package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.User.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class domainTest {


    @Test
    void 로또_Valid_테스트(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(1,2,3,4,5)));
        assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(1,1,2,3,4,5)));
    }
    @Test
    void 당첨_번호_개수_테스트(){
        assertThat(countCoincidentNumber(List.of(1,2,3,4,5,6),List.of(1,2,3,4,5,6))).isEqualTo(6);
    }

    @Test
    void 보너스_번호_테스트(){
        assertThat(countBonusNumber(List.of(1,2,3,4,5,6),7)).isEqualTo(false);
        assertThat(countBonusNumber(List.of(1,2,3,4,5,6),3)).isEqualTo(true);
    }

    @Test
    void 구매_금액_1000단위_테스트() {
        assertThrows(IllegalArgumentException.class, () -> NumberOfLottoVaildTest("19800"));
    }

    @Test
    void 구매_금액_문자포함_테스트() {
        assertThrows(NoSuchElementException.class, () -> NumberOfLottoVaildTest("10000J."));
    }

    @Test
    void 구매_금액_로또구매개수_테스트() {
        String firstInput = "18000";
        String secondInput = "1,2,3,4,5,6";
        String thirdInput = "7";
        InputStream price = new ByteArrayInputStream(firstInput.getBytes());
        InputStream winningNumbers = new ByteArrayInputStream(secondInput.getBytes());
        InputStream bonusNumbers = new ByteArrayInputStream(thirdInput.getBytes());
        System.setIn(price);
        User userTest = new User();

        System.setIn(winningNumbers);
        System.setIn(bonusNumbers);
        assertThat(userTest.numberOfLotto).isEqualTo(18);
    }

}
