package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoGeneratorTest {

    @Test
    void 여섯_자리의_로또_번호를_생성한다() {
        Lotto lotto = AutoLottoGenerator.generate();
        assertThat(lotto.getNumbers().size()).isEqualTo(AutoLottoGenerator.LOTTO_SIZE);
    }
}