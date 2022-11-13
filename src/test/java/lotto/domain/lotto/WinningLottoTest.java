package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.place.MatchResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7));
    }

    @Test
    void 유효성_검사_예외() {
        List<Integer> only6 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> duplicate = List.of(1, 2, 3, 4, 5, 6, 6);
        List<Integer> over7 = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> overValue = List.of(1, 2, 3, 4, 5, 6, 7, 55);
        List<Integer> underValue = List.of(0, 2, 3, 4, 5, 6, 7, 55);

        assertThatThrownBy(() -> new WinningLotto(only6)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLotto(duplicate)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLotto(over7)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLotto(overValue)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLotto(underValue)).isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    @DisplayName("매칭_결과_검사")
    class MatchResultTest {
        @Test
        @DisplayName("1등 검사")
        void check_1_place() {
            PurchaseLotto purchaseLotto = new PurchaseLotto(List.of(1, 2, 3, 4, 5, 6, 7));
            MatchResult expected = MatchResult.FIRST_PLACE;

            MatchResult matchResult = winningLotto.makeMatchResult(purchaseLotto);

            assertThat(matchResult).isEqualTo(expected);
        }

        @Test
        @DisplayName("2등 검사")
        void check_2_place() {
            PurchaseLotto purchaseLotto = new PurchaseLotto(List.of(11, 2, 3, 4, 5, 6, 7));
            MatchResult expected = MatchResult.SECOND_PLACE;

            MatchResult matchResult = winningLotto.makeMatchResult(purchaseLotto);

            assertThat(matchResult).isEqualTo(expected);
        }

        @Test
        @DisplayName("3등 검사")
        void check_3_place() {
            PurchaseLotto purchaseLotto = new PurchaseLotto(List.of(1, 2, 3, 34, 5, 6, 17));
            MatchResult expected = MatchResult.THIRD_PLACE;

            MatchResult matchResult = winningLotto.makeMatchResult(purchaseLotto);

            assertThat(matchResult).isEqualTo(expected);
        }

        @Test
        @DisplayName("4등 검사")
        void check_4_place() {
            PurchaseLotto purchaseLotto = new PurchaseLotto(List.of(11, 12, 3, 4, 5, 6, 7));
            MatchResult expected = MatchResult.FOURTH_PLACE;

            MatchResult matchResult = winningLotto.makeMatchResult(purchaseLotto);

            assertThat(matchResult).isEqualTo(expected);
        }

        @Test
        @DisplayName("5등 검사")
        void check_5_place() {
            PurchaseLotto purchaseLotto = new PurchaseLotto(List.of(11, 12, 3, 14, 5, 6, 7));
            MatchResult expected = MatchResult.FIFTH_PLACE;

            MatchResult matchResult = winningLotto.makeMatchResult(purchaseLotto);

            assertThat(matchResult).isEqualTo(expected);
        }

        @Test
        @DisplayName("그외 검사")
        void check_rest_place() {
            PurchaseLotto purchaseLotto = new PurchaseLotto(List.of(11, 12, 3, 14, 15, 6, 7));
            MatchResult expected = MatchResult.NONE;

            MatchResult matchResult = winningLotto.makeMatchResult(purchaseLotto);

            assertThat(matchResult).isEqualTo(expected);
        }
    }
}