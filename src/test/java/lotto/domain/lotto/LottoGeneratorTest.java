package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("구매 개수에 맞는 로또를 생성하는지 확인한다.")
    @Test
    void createLottoByValidNumber() {
        //given
        int numOfLotto = 12;
        //when
        LottoGenerator lottos = new LottoGenerator(numOfLotto);
        //then
        assertThat(lottos.getLottos().size()).isEqualTo(12);
    }
}