package lotto.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoControllerTest {
    @ParameterizedTest(name = "잘못된 입력 예외 테스트")
    @CsvSource(value = {
            "^([1-9,]{4,})$;가나,다라.마바",
            "^(\\d+[0][0][0]){4,}$;123",
            "^(\\d+[0][0][0]){4,}$;1234",
            "^([1-9]{1,2})$;123",
            "^([1-9]{1,2})$;가나다"
    }, delimiter = ';')
    void validateByWrongInput(String regex, String input) {
        assertThatThrownBy(() -> LottoController.validateInput(regex, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "잘못된 문자 변환 예외 테스트")
    @ValueSource(strings = {
            "가", "a", "1w"
    })
    void parseIntByWrongInput(String input) {
        assertThatThrownBy(() -> LottoController.parseInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
