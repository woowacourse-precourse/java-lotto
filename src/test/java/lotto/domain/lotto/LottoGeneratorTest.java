package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @DisplayName("[성공] 랜덤한 로또 번호 6개를 생성한 로또 객체 만들기")
    @Test
    public void createLottoWithRandomNumbers() {
        Lotto lotto = LottoGenerator.createLottoWithRandomNumbers();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }
}
