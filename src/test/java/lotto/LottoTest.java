package lotto;

import exception.DuplicateInputException;
import exception.InputSizeException;
import exception.OutOfRangeInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(InputSizeException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(DuplicateInputException.class)
                .hasMessageContaining("[ERROR]");;
    }

    @DisplayName("로또 번호중 하나가 1 미만 혹은 45 초과일때 예외가 발생한다")
    @Test
    void createLottoByTooSmallOrToLargeNumber() {
        assertThatThrownBy(()->new Lotto(List.of(-1,2,3,4,5,6)))
                .isInstanceOf(OutOfRangeInputException.class)
                .hasMessageContaining("[ERROR]");;

        assertThatThrownBy(()->new Lotto(List.of(1,2,3,4,56,6)))
                .isInstanceOf(OutOfRangeInputException.class)
                .hasMessageContaining("[ERROR]");;

    }


    // 아래에 추가 테스트 작성 가능
}
