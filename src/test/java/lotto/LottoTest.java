package lotto;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.exception.Exceptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    // 아래에 추가 테스트 작성 가능
    @Test
    void 중복_체크(){
        boolean overlap = Exceptions.isOverLapNumber("1,2,3,4,5,5");
        assertThat(overlap).isFalse();
    }

    @Test
    void 숫자_이외에_값_입력_체크(){
        boolean correct = Exceptions.isRightLottoNumbersType("1,2,3,4,5,a");
        assertThat(correct).isFalse();
    }

    @Test
    void 로또_크기_체크(){
        boolean correctSize = Exceptions.isCorrectSize("1,2,3,4,5");
        assertThat(correctSize).isFalse();
    }

}
