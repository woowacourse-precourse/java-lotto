package lotto.domain.lotto;

import java.util.List;
import lotto.common.InputErrors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoDrawTest {
    private static final String ERROR_PREFIX = "[ERROR]";

    @Test
    public void 보너스_번호는_당첨_번호와_중복_될_수_없다() {
        //given
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        Assertions.assertThatThrownBy(() -> LottoDraw.of(winNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining(InputErrors.BONUS_NUMBER_DUPLICATED_WIN_NUMBER.getMessage());
    }


}