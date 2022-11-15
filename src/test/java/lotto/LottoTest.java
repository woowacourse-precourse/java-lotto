package lotto;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoGenerator;
import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.WinningNumbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThatThrownBy(() -> lottoGenerator.generate(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThatThrownBy(() -> lottoGenerator.generate(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동 로또 생성 테스트")
    @Test
    void autoLottoGenerateTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoGenerator lottoGenerator = new LottoGenerator();
                    Lotto lotto = lottoGenerator.autoGenerate();
                    Lotto result = lottoGenerator.generate(List.of(13, 14, 16, 38, 42, 45));
                    assertThat(lotto).isEqualTo(result);
                },
                List.of(38, 16, 42, 13, 14, 45)
        );
    }

    @DisplayName("로또 일치 개수 확인 테스트")
    @Test
    void checkMatchCountTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoGenerator lottoGenerator = new LottoGenerator();
                    Lotto lotto = lottoGenerator.autoGenerate();

                    Lotto winningLotto = lottoGenerator.generate(List.of(1, 13, 14, 16, 38, 42));
                    WinningNumbers winningNumbers = new WinningNumbers(winningLotto, new LottoNumber(3));

                    int result = 5;
                    assertThat(winningNumbers.checkMatchCount(lotto)).isEqualTo(result);
                },
                List.of(38, 16, 42, 13, 14, 45)
        );
    }

    @DisplayName("보너스 숫자 확인 테스트")
    @Test
    void checkFourthLottoTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoGenerator lottoGenerator = new LottoGenerator();
                    Lotto lotto = lottoGenerator.autoGenerate();

                    Lotto winningLotto = lottoGenerator.generate(List.of(1, 38, 13, 16, 42, 43));
                    WinningNumbers winningNumbers = new WinningNumbers(winningLotto, new LottoNumber(45));

                    boolean result = true;
                    assertThat(winningNumbers.checkBonusMatch(lotto)).isEqualTo(result);
                },
                List.of(38, 16, 42, 13, 14, 45)
        );
    }
}
