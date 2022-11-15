package lotto.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

class LottoServiceViewTest {

    LottoBuyView lottoServiceView;

    @BeforeEach
    void beforeEach() {
        lottoServiceView = new LottoBuyView();
    }

    @ParameterizedTest
    @DisplayName("로또 구입 기능 통합 테스트")
    @CsvSource(value = {"20000, 20", "300000, 300", "1000, 1"})
    void buyLottoTest(String inputMoney, int expected) {

        InputStream inputStream = new ByteArrayInputStream(inputMoney.getBytes());
        System.setIn(inputStream);

        int numberOfLotto = lottoServiceView.buyLotto();

        assertThat(numberOfLotto).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("유효성 검사 통합 테스트")
    @CsvSource(value = {"10004, [ERROR] 구매 금액의 최소 단위", "2147483648, [ERROR] 구매 금액은 최대 10억 미만",
            "as, [ERROR] 구매 금액은 숫자만 입력되어야 합니다.", "123, [ERROR] 최소 구매 금액은 1,000원 이상입니다."})
    void validateInputMoneyTest(String inputMoney, String errorMessage) {
        assertThatThrownBy(() -> lottoServiceView.validateInputMoney(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("유효성 검사 테스트 - 화폐 최소 단위 검사")
    @ValueSource(strings = {"10004", "112334", "123040", "111400"})
    void checkMonetaryUnitTest(String inputMoney) {
        assertThatThrownBy(() -> lottoServiceView.checkMonetaryUnit(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매 금액의 최소 단위는 1,000 입니다. 1,000 단위로 다시 입력해주세요.");
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