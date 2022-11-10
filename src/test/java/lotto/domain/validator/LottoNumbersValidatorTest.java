package lotto.domain.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersValidatorTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void createLottoByOverSize() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbersValidator.validate(List.of(1, 2, 3, 4, 5, 6, 7)));
    }
    
    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void createLottoByDuplicatedNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbersValidator.validate(List.of(1, 2, 3, 4, 5, 5)));
    }
    
    @DisplayName("예외 처리 : 6개의 숫자 중, 1~45 범위를 벗어난 숫자가 존재하는 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(ints = {0, 46})
    void outOfRangeException(int lottoNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbersValidator.validate(List.of(1, 2, 3, 4, 5, lottoNumber)));
    }
}