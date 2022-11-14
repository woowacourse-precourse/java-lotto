package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyServiceTest {
    MoneyService moneyService = new MoneyService();

    @DisplayName("구입 금액 입력 형식 검사")
    @ParameterizedTest
    @ValueSource(strings = {"11,000", "3000원", "1_000", "5000won"})
    public void 구입_금액_입력_형식_예외(String purchaseAmount) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> moneyService.savePurchaseAmount(purchaseAmount));
        assertThat(e.getMessage()).isEqualTo("[ERROR] 구입 금액은 숫자만 입력해야 합니다.");
    }

    @DisplayName("구입 금액 입력 단위 검사")
    @ParameterizedTest
    @ValueSource(strings = {"14500", "1250", "270", "0"})
    public void 구입_금액_입력_단위_예외(String purchaseAmount) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> moneyService.savePurchaseAmount(purchaseAmount));
        assertThat(e.getMessage()).isEqualTo("[ERROR] 구입 금액은 1,000원 단위만 입력해야 합니다.");
    }

}
