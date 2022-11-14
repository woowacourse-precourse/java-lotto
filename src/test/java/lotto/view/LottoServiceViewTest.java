package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceViewTest {

    LottoServiceView lottoServiceView;

    @BeforeEach
    void beforeEach() {
        lottoServiceView = new LottoServiceView();
    }

    @ParameterizedTest
    @DisplayName("유효성 검사 테스트 - 오버플로우 검사")
    @ValueSource(strings = {"2147483648", "1000000000"})
    void checkOverFlowTest(String inputMoney) {
        assertThatThrownBy(() -> lottoServiceView.checkOverFlow(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매 금액은 최대 10억 미만으로 입력해야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("유효성 검사 테스트 - 자연수 입력 확인")
    @ValueSource(strings = {"as", "abasd", "1234.5", "-5123", "0.1234", "&*(^&@#$%@$  !@#", " 12345", "12 45 43"})
    void checkOnlyIntegerTest(String inputMoney) {
        assertThatThrownBy(() -> lottoServiceView.checkOnlyInteger(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매 금액은 숫자만 입력되어야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("유효성 검사 테스트 - 최소금액 검사")
    @CsvSource(value = {"123", "567", "4", "56", "0", "1"})
    void checkMinimumAmountTest(String inputMoney) {

        assertThatThrownBy(() -> lottoServiceView.validateInputMoney(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 최소 구매 금액은 1,000원 이상입니다.");
    }
}