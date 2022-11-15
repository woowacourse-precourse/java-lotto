package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningLottoTest {

    @DisplayName("보너스 번호를 맞췄는지")
    @Nested
    class CheckBonus {
        List<Integer> winningNumber;
        WinningLotto winningLotto;
        List<Integer> myNumber;

        @DisplayName("로또번호 : 1,2,3,4,5,6 보너스 번호 : 7")
        @Test
        void case1() {
            winningNumber = List.of(1, 2, 3, 4, 5, 6);
            winningLotto = new WinningLotto(winningNumber, 7);
            myNumber = List.of(1, 2, 3, 4, 5, 6);

            assertThat(winningLotto.containsBonus(myNumber)).isEqualTo(false);
        }

        @DisplayName("로또번호 : 3,16,22,24,33,44 보너스 번호 :33")
        @Test
        void case2() {
            winningNumber = List.of(1, 2, 3, 4, 5, 6);
            winningLotto = new WinningLotto(winningNumber, 33);
            myNumber = List.of(3, 16, 22, 24, 33, 44);

            assertThat(winningLotto.containsBonus(myNumber)).isEqualTo(true);
        }

        @DisplayName("로또번호 : 5,7,13,22,25,45 보너스 번호 : 45")
        @Test
        void case3() {
            winningNumber = List.of(1, 2, 3, 4, 5, 6);
            winningLotto = new WinningLotto(winningNumber, 45);
            myNumber = List.of(5, 7, 13, 22, 25, 45);

            assertThat(winningLotto.containsBonus(myNumber)).isEqualTo(true);
        }
    }


    @DisplayName("예외 : 보너스가 중복일 경우")
    @Nested
    class CheckDuplicate {
        @DisplayName("당첨 번호 : 1,2,3,4,5,6 보너스 번호 : 6")
        @Test
        void case1() {
            assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호 : 5,6,8,23,33,44 보너스 번호 : 33")
        @Test
        void case2() {
            assertThatThrownBy(() -> new WinningLotto(List.of(5, 6, 8, 23, 33, 44), 33))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }


}