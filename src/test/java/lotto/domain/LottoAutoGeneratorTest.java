package lotto.domain;

import lotto.constant.LottoRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAutoGeneratorTest {
    @DisplayName("금액에 맞춰서 로또를 자동생성해준다.")
    @Test
    void givenMoney_whenCreateLottos_thenReturnLottosAccordingToMoney() {
        //given
        int money = 7000;

        //when
        List<Lotto> result = LottoAutoGenerator.generateLottoCollection(money);

        //then
        assertThat(result.size())
                .isEqualTo(money/LottoRule.COST.getValueForRule());
    }
}