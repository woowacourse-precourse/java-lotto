package lotto.domain;

import lotto.ui.LottoValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoGeneratorTest {

    private LottoGenerator generator;

    @BeforeEach
    public void before() {
        generator = new LottoGenerator();
    }

    @DisplayName("구입금액 만큼 로또를 생성해야한다.")
    @Test
    void lottoCountTest() {
        List<Lotto> lottoPacks = generator.generate("13000");

        Assertions.assertThat(lottoPacks.size()).isEqualTo(13);
    }

    @DisplayName("생성한 로또는 6자리여야 한다.")
    @Test
    void eachLottoDigitTest() {
        List<Lotto> lottoPacks = generator.generate("48000");

        for (Lotto lottoPack : lottoPacks) {
            Assertions.assertThat(lottoPack.getNumbers().size()).isEqualTo(6);
        }
    }

    @DisplayName("생성한 로또는 중복이 없어야한다.")
    @Test
    void lottoDuplicationTest() {
        List<Lotto> lottoPacks = generator.generate("11000");

        for (Lotto lottoPack : lottoPacks) {
            boolean valid = LottoValidator.isDuplication(lottoPack.getNumbers());
            Assertions.assertThat(valid).isEqualTo(false);
        }
    }
}