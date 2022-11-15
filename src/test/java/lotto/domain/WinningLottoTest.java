package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.ErrorConstant.ERROR_DUPLICATE_NUMBER;
import static lotto.constant.ErrorConstant.ERROR_NOT_VALID_COUNT;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {
    @DisplayName("예외 처리 : 당첨 번호와 보너스 번호가 중복인지 검증")
    @Test
    void isContainBonusNumberInLotto() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6),6))
                .withMessageStartingWith(ERROR_DUPLICATE_NUMBER);
    }
}
