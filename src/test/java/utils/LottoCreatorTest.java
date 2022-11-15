package utils;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoCreatorTest {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;

    @DisplayName("랜덤한 숫자를 생성한다.")
    @Test
    public void createLotto() {
        Lotto lotto = LottoCreator.createLotto();

        for (int number : lotto.getLottoNumbers()) {
            assertThat(number).isBetween(START_INCLUSIVE, END_INCLUSIVE);
        }
    }

    @DisplayName("로또 번호가 6개인지 확인한다.")
    @Test
    public void checkLottoNumberCount() {
        Lotto lotto = LottoCreator.createLotto();

        assertThat(lotto.getLottoNumbers().size()).isEqualTo(LOTTO_NUMBER_COUNT);
    }
}
