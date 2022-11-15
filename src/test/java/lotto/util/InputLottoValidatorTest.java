package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputLottoValidatorTest {

    @DisplayName("로또 입력 형식에 쉼표 사이에 숫자가 없으면 예외를 발생한다.")
    @Test
    void createLottoByWrongFormat() {
        assertThatThrownBy( () -> InputLottoValidator.validateInputLotto("1,,,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("로또 입력 형식에 공백이 있으면 예외를 발생한다.")
    @Test
    void createLottoByBlank() {
        assertThatThrownBy( () -> InputLottoValidator.validateInputLotto("1, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 입력 숫자가 6개가 아니면 예외를 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy( () -> InputLottoValidator.validateLottoCount(List.of(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 입력 숫자가 중복되면 예외를 발생한다.")
    @Test
    void createLottoByDuplicate() {
        assertThatThrownBy( () -> InputLottoValidator.validateDuplicateLottoNumber(List.of(1,1,3,4,5,6),1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}