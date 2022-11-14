package lotto.domain.lotto.repository;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.enumtype.LottoNumberInclusive;
import lotto.constant.enumtype.UserInterfaceMessage;
import org.junit.jupiter.api.Test;

class LottoBonusTest {
    @Test
    void 범위를_벗어나는_보너스_번호_추가_예외_테스트() {
        Integer bonusNumber = 46;
        List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new LottoBonus(bonusNumber, lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(UserInterfaceMessage.ERROR_NUMBER_INCLUSIVE.getValue(),
                        LottoNumberInclusive.START.getValue(), LottoNumberInclusive.END.getValue()));
    }

    @Test
    void 로또번호와_중복되는_보너스_번호_추가_예외_테스트() {
        Integer bonusNumber = 1;
        List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new LottoBonus(bonusNumber, lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UserInterfaceMessage.ERROR_INPUT_BONUS_NUMBER_DUPLICATED.getValue());
    }
}