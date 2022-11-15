package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {
    private static final int LOTTOCOUNT = 6;
    private static final int MAX = 45;
    private static final int MIN = 1;

    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    void 당첨_번호_생성_테스트() {
        final List<Integer> expected = numberGenerator.createWinningNumbers(List.of("1", "2", "3", "4", "5", "6"));
        assertThat(expected).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 보너스_번호_생성_테스트() {
        final int expected = numberGenerator.createBonusNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertThat(expected).isEqualTo(7);
    }

    @Test
    void 당첨번호_숫자_판단_테스트() {
        try {
            numberGenerator.checkNumber("1,2,a,,3,4,5");
        } catch (IllegalArgumentException e) {
            assertThat("당첨 번호에 문자가 포함되어있습니다.").isEqualTo(e.getMessage());
        }
    }

    @Test
    void 보너스_번호_범위_테스트() {
        assertThatThrownBy(() -> numberGenerator.checkScope(55))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_중복_테스트() {
        assertThatThrownBy(() -> numberGenerator.bonusNumberOverlap(Arrays.asList(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_생성_테스트() {
        List<Integer> lotto = numberGenerator.createLottoNumbers();
        assertThat(lotto.size()).isEqualTo(LOTTOCOUNT);
        for (Integer number : lotto) {
            assertThat(number).isGreaterThan(MIN - 1).isLessThan(MAX + 1);
        }
    }
}