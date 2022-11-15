package lotto;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoGenerator;
import lotto.model.statistics.LottoResult;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동 로또 생성 테스트")
    @Test
    void autoLottoGenerateTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoGenerator lottoGenerator = new LottoGenerator();
                    Lotto lotto = lottoGenerator.autoGenerate();
                    assertThat(lotto.getNumbers()).isEqualTo(List.of(13, 14, 16, 38, 42, 45));
                },
                List.of(38, 16, 42, 13, 14, 45)
        );
    }

    @DisplayName("2등 로또 확인 테스트")
    @Test
    void checkSecondLottoTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoGenerator lottoGenerator = new LottoGenerator();
                    Lotto lotto = lottoGenerator.autoGenerate();

                    Lotto winningLotto = lottoGenerator.generate(List.of(1, 13, 14, 16, 38, 42));
                    WinningNumbers winningNumbers = new WinningNumbers(winningLotto, 45);
                    assertThat(winningNumbers.checkLotto(lotto)).isEqualTo(LottoResult.SECOND);
                },
                List.of(38, 16, 42, 13, 14, 45)
        );
    }

    @DisplayName("3등 로또 확인 테스트")
    @Test
    void checkThirdLottoTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoGenerator lottoGenerator = new LottoGenerator();
                    Lotto lotto = lottoGenerator.autoGenerate();

                    Lotto winningLotto = lottoGenerator.generate(List.of(1, 13, 14, 16, 38, 42));
                    WinningNumbers winningNumbers = new WinningNumbers(winningLotto, 3);

                    assertThat(winningNumbers.checkLotto(lotto)).isEqualTo(LottoResult.THIRD);
                },
                List.of(38, 16, 42, 13, 14, 45)
        );
    }

    @DisplayName("4등 로또 확인 테스트")
    @Test
    void checkFourthLottoTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoGenerator lottoGenerator = new LottoGenerator();
                    Lotto lotto = lottoGenerator.autoGenerate();

                    Lotto winningLotto = lottoGenerator.generate(List.of(1, 38, 13, 16, 42, 43));
                    WinningNumbers winningNumbers = new WinningNumbers(winningLotto, 45);

                    assertThat(winningNumbers.checkLotto(lotto)).isEqualTo(LottoResult.FOURTH);
                },
                List.of(38, 16, 42, 13, 14, 45)
        );
    }
}
