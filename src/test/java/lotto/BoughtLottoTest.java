package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.User.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class BoughtLottoTest {

    @DisplayName("생성된 랜덤 변수 내에 중복값이 있거나 1부터 46 사이의 자연수가 아니거나, 6개 숫자가 아니면 예외가 발생한다.")
    @Test
    void BoughtLottoTest() {
        new BoughtLotto();
    }
}
