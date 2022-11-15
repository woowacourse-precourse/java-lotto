package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.ErrorConstant;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("로또 번호에 null이 있으면 예외가 발생한다.")
    @Test
    void createLottoByComponentNull() {
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(null);
        test.add(4);
        test.add(5);
        test.add(15);
        assertThatThrownBy(() -> new Lotto(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstant.LOTTO_NOT_NUMBER_NULL);
    }
    @DisplayName("로또 번호에 숫자가 아닌 값이 있으면 예외가 발생한다.")
    @Test
    void createLottoByNotNumber() {
        assertThatThrownBy(() -> new Lotto("1,a,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstant.WINNING_LOTTO_COMPONENT);
    }
    @DisplayName("로또 번호가 1~45이외의 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 20, 300, 4, 5, 15)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstant.WINNING_LOTTO_OUT_RANGE);
    }
    @DisplayName("로또 번호가 앞자리에 0이 있으면 예외가 발생한다.")
    @Test
    void createLottoByStartWithZero() {
        assertThatThrownBy(() -> new Lotto("1,02,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstant.LOTTO_NUMBER_FIRST_NOT_ZERO);
    }
    @DisplayName("로또가 NULL이면 예외가 발생한다.")
    @Test
    void createLottoByNull() {
        List<Integer> test = null;
        assertThatThrownBy(() -> new Lotto(test))
                .hasMessageContaining(ErrorConstant.LOTTO_NOT_NULL);
    }
//    @DisplayName("로또가 NULL이면 예외가 발생한다.")
//    @Test
//    void createLottoByNull() {
//        assertThatThrownBy(() -> new Lotto(List.of()))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
//    @Test
//    void createLottoByDuplicatedNumber() {
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
//    @Test
//    void createLottoByDuplicatedNumber() {
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
    // 아래에 추가 테스트 작성 가능
}
