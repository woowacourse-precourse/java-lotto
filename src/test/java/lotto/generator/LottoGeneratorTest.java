package lotto.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constant.Constants;
import lotto.constant.LottoNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @Test
    @DisplayName("입력한 구매 금액에 맞는 로또를 발행 해주는지 테스트")
    void generateAppropriateAmountByMoney() {
        // given
        int money = Constants.UNIT_OF_LOTTO_PURCHASE * LottoNumber.NUMBER_OF_LOTTO_NUMBERS.getNumber();

        // when
        List<Lotto> lottos = LottoGenerator.generateByMoney(money);

        // then
        assertThat(lottos.size()).isEqualTo(LottoNumber.NUMBER_OF_LOTTO_NUMBERS.getNumber());
    }
}
