package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Nested
    @DisplayName("당첨 로또는 주어진 형식을 만족한다.")
    class describe_condition_of_Lotto {

        @Nested
        @DisplayName("당첨 로또는 6개의 숫자 + 보너스 숫자로 구성되어야 한다.")
        class lotto_is_consist_of_6_numbers {

            @Test
            @DisplayName("숫자가 6개가 로또 형식을 지키지 않는 경우 예외가 발생한다.")
            void createWinningLottoNotFollowsRule() {
                assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7), 8)).isInstanceOf(
                        IllegalArgumentException.class);
            }

            @Test
            @DisplayName("보너스 번호가 로또 번호 안에 있는 경우 예외가 발생한다.")
            void createWinningLottoBonusNumInLottoNumbers() {
                assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 5))
                        .isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("보너스 번호가 [1,45] 범위를 벗어난 경우 예외가 발생한다.")
            void createWinningLottoBonusNumOutOfRange() {
                assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 46))
                        .isInstanceOf(IllegalArgumentException.class);

                assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 0))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }


        @Test
        @DisplayName("모든 조건을 만족하면 Winning Lotto 객체를 생성한다")
        void createNormalLotto() {
            new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
            new WinningLotto(List.of(42, 2, 3, 4, 5, 6), 45);
            new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        }
    }

    @Nested
    @DisplayName("getCompareResult 메서드는")
    class describe_getCompareResult {

        @Test
        @DisplayName("로또 객체와의 비교 결과를 LottoGrade 형태로 반환한다.")
        void returnCompareResultAsLottoGrade() {
            WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

            Lotto lottoForFirst = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto lottoForSecond = new Lotto(List.of(1, 2, 3, 4, 5, 7));
            Lotto lottoForThird = new Lotto(List.of(1, 2, 3, 4, 5, 11));
            Lotto lottoForFourth = new Lotto(List.of(1, 2, 3, 4, 10, 11));
            Lotto lottoForFifth = new Lotto(List.of(1, 2, 3, 10, 11, 12));
            Lotto lottoForFail = new Lotto(List.of(1, 2, 10, 11, 12, 13));

            assertThat(winningLotto.getCompareResult(lottoForFirst)).isEqualTo(LottoGrade.FIRST);
            assertThat(winningLotto.getCompareResult(lottoForSecond)).isEqualTo(LottoGrade.SECOND);
            assertThat(winningLotto.getCompareResult(lottoForThird)).isEqualTo(LottoGrade.THIRD);
            assertThat(winningLotto.getCompareResult(lottoForFourth)).isEqualTo(LottoGrade.FOURTH);
            assertThat(winningLotto.getCompareResult(lottoForFifth)).isEqualTo(LottoGrade.FIFTH);
            assertThat(winningLotto.getCompareResult(lottoForFail)).isEqualTo(LottoGrade.FAIL);

        }
    }
}
