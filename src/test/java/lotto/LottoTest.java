package lotto;

import lotto.check.Validator;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 ,가 아닌 다른 구분자가 있으면 예외가 발생한다.")
    @Test
    void 콤마_외_구분자_체크(){
        String input = "1/2/3/ㄴ/5/6";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.isSpliterComma(input));
    }

    @DisplayName("로또 번호 입력값들이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호_숫자_체크(){
        String input = "1,g,3,d,g,5";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.isSplitNumber(input));
    }

    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void 여섯개_숫자_길이_체크(){
        String input = "2,3,4,5,6,7,8";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.isLength(input));
    }

    @DisplayName("1~45 숫자 범위 내에 있지 않으면 예외가 발생한다.")
    @Test
    void 숫자_범위_체크(){
        String input = "2,34,65,88,6,3";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.isRangeNumber(input));
    }

    @DisplayName("입력한 로또 번호가 중복된 숫자가 있는지")
    @Test
    void 로또_번호_중복_숫자_체크(){
        String input = "1,2,3,4,5,4";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.isDuplicateLuckyNumber(input));
    }
}
