package lotto.domain;

import lotto.util.RankingType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Nested
    @DisplayName("로또 번호 생성 로직 검증")
    class CreateLotto {

        @Test
        @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
        void createLottoByOverSize() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("로또 번호 개수가 6개 이하면 예외 발생")
        void 로또_개수_6개_이하() {
            // given
            List<Integer> lst = List.of(1, 2, 48);
            // when
            // then
            assertThatThrownBy(() -> new Lotto(lst))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        void createLottoByDuplicatedNumber() {
            // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("로또 번호가 1~45 사이의 범위가 아니면 예외 발생")
        void 범위_벗어난_로또() {
            // given
            List<Integer> lst = List.of(1, 2, 3, 4, 5, 48);
            // when
            // then
            assertThatThrownBy(() -> new Lotto(lst))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }


    @Nested
    @DisplayName("당첨 번호와 비교해서 몇 등인지 출력하는 로직 검증")
    class GetRanking {
        WinningLotto winningLotto;

        @BeforeEach
        void 로또_초기화() {
            winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
            winningLotto.updateBonus(7);
        }

        @Test
        @DisplayName("1등")
        void 일등() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            // when
            RankingType result = lotto.getRankingType(winningLotto);
            // then
            assertThat(result).isEqualTo(RankingType.FIRST);
        }

        @Test
        @DisplayName("2등")
        void 이등() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
            // when
            RankingType result = lotto.getRankingType(winningLotto);
            // then
            assertThat(result).isEqualTo(RankingType.SECOND);
        }

        @Test
        @DisplayName("3등")
        void 삼등() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
            // when
            RankingType result = lotto.getRankingType(winningLotto);
            // then
            assertThat(result).isEqualTo(RankingType.THIRD);
        }

        @Test
        @DisplayName("4등")
        void 사등() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
            // when
            RankingType result = lotto.getRankingType(winningLotto);
            // then
            assertThat(result).isEqualTo(RankingType.FOURTH);
        }

        @Test
        @DisplayName("5등")
        void 오등() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
            // when
            RankingType result = lotto.getRankingType(winningLotto);
            // then
            assertThat(result).isEqualTo(RankingType.FIFTH);
        }

        @Test
        @DisplayName("탈락")
        void 탈락() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));
            // when
            RankingType result = lotto.getRankingType(winningLotto);
            // then
            assertThat(result).isEqualTo(RankingType.DROP_OUT);
        }
    }

    @Nested
    @DisplayName("로또 번호 String화 로직 검증")
    class LottoToString {

        @Test
        @DisplayName("정렬 검증 [6,3,4,1,2,5] -> \"[1, 2, 3, 4, 5, 6]\"")
        void 로또_번호_정렬_검증() {
            // given
            List<Integer> integers = Arrays.asList(6, 3, 4, 1, 2, 5);
            // when
            Lotto lotto = new Lotto(integers);
            String result = lotto.getSortedNumbersString();
            // then
            assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]");
        }
    }

}
