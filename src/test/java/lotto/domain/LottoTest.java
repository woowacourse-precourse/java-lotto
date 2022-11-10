package lotto.domain;

import lotto.domain.validator.LottoNumbersValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    
    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_MESSAGE);
    }
    
    @Test
    @DisplayName("올바른 로또 번호 입력 시")
    void correctLottoNumbers() {
        assertThatNoException()
                .isThrownBy(() -> new Lotto(List.of(1, 10, 30, 35, 40, 45)));
    }
    
    @DisplayName("예외 처리 : 6개의 숫자 중, 1~45 범위를 벗어난 숫자가 존재하는 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(ints = {0, 46})
    void outOfRangeException(int lottoNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, lottoNumber)))
                .withMessageStartingWith(ERROR_MESSAGE);
    }
}
