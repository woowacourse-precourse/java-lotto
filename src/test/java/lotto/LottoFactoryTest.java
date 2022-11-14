package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import lotto.domain.LottoFactory;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {

    private static final LottoFactory lottoFactory = new LottoFactory();

    @Test
    @DisplayName("로또 팩토리는 랜덤한 숫자를 생성한다.")
    void generateRandomNumber() {
        List<Integer> lotto = lottoFactory.chooseNumbers().lottoNumbers();
        lotto.forEach(lottoNumber -> assertTrue(lottoNumber >= 1 && lottoNumber <= 45));
    }

    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다.")
    void generateNumbers() {
        assertThat(lottoFactory.chooseNumbers().lottoNumbers().size()).isEqualTo(6);
    }
}