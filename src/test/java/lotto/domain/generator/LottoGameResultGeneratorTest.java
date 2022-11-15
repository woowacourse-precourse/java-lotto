package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameResultGeneratorTest {
    LottoGameResultGenerator lottoGameResultGenerator;

    @Nested
    class WinningCountTest {
        @BeforeEach
        void initGenerator() {
            lottoGameResultGenerator = new LottoGameResultGenerator();
        }

        @DisplayName("당첨번호가 하나도 안 겹치는 경우")
        @Test
        void case1() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            WinningNumbers winningNumbers = new WinningNumbers(List.of(7, 8, 9, 10, 11, 12));

            int winningCount = lottoGameResultGenerator.calculateWinningCount(lotto, winningNumbers);

            assertThat(winningCount).isEqualTo(0);
        }

        @DisplayName("당첨번호가 하나만 겹치는 경우")
        @Test
        void case2() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            WinningNumbers winningNumbers = new WinningNumbers(List.of(6, 7, 8, 9, 10, 11));

            int winningCount = lottoGameResultGenerator.calculateWinningCount(lotto, winningNumbers);

            assertThat(winningCount).isEqualTo(1);
        }
        @DisplayName("당첨번호가 두 개 겹치는 경우")
        @Test
        void case3() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            WinningNumbers winningNumbers = new WinningNumbers(List.of(5, 6, 7, 8, 9, 10));

            int winningCount = lottoGameResultGenerator.calculateWinningCount(lotto, winningNumbers);

            assertThat(winningCount).isEqualTo(2);
        }

        @DisplayName("당첨번호가 세 개 겹치는 경우")
        @Test
        void case4() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            WinningNumbers winningNumbers = new WinningNumbers(List.of(4, 5, 6, 7, 8, 9));

            int winningCount = lottoGameResultGenerator.calculateWinningCount(lotto, winningNumbers);

            assertThat(winningCount).isEqualTo(3);
        }

        @DisplayName("당첨번호가 네 개 겹치는 경우")
        @Test
        void case5() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            WinningNumbers winningNumbers = new WinningNumbers(List.of(3, 4, 5, 6, 7, 8));

            int winningCount = lottoGameResultGenerator.calculateWinningCount(lotto, winningNumbers);

            assertThat(winningCount).isEqualTo(4);
        }

        @DisplayName("당첨번호가 다섯 개 겹치는 경우")
        @Test
        void case6() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            WinningNumbers winningNumbers = new WinningNumbers(List.of(2, 3, 4, 5, 6, 7));

            int winningCount = lottoGameResultGenerator.calculateWinningCount(lotto, winningNumbers);

            assertThat(winningCount).isEqualTo(5);
        }

        @DisplayName("당첨번호가 여섯 개 겹치는 경우")
        @Test
        void case7() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

            int winningCount = lottoGameResultGenerator.calculateWinningCount(lotto, winningNumbers);

            assertThat(winningCount).isEqualTo(6);
        }
    }
}
