package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @Nested
    @DisplayName("당첨 로또 생성 테스트")
    class CreateTest {
        @Test
        void 당첨_로또_생성_성공() {
            //given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            int bonusNumber = 7;

            //when then
            assertThatNoException()
                    .isThrownBy(() -> new WinningLotto(numbers, bonusNumber));
        }

        @Test
        void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
            //given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
            int bonusNumber = 7;

            //when then
            assertThatThrownBy(() -> new WinningLotto(numbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
            //given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
            int bonusNumber = 7;

            //when then
            assertThatThrownBy(() -> new WinningLotto(numbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("중복된 당첨 번호가 존재합니다.");
        }

        @Test
        void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다2() {
            //given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            int bonusNumber = 6;

            //when then
            assertThatThrownBy(() -> new WinningLotto(numbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("중복된 당첨 번호가 존재합니다.");
        }
    }
}