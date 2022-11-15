package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import repository.MoneyRepository;

import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyServiceTest {
    MoneyService moneyService = new MoneyService(new MoneyRepository());

    @DisplayName("구입 금액 입력 형식 검사")
    @ParameterizedTest
    @ValueSource(strings = {"11,000", "3000원", "1_000", "5000won"})
    public void 구입_금액_입력_형식_예외(String purchaseAmount) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> moneyService.savePurchaseAmount(purchaseAmount));
        assertThat(e.getMessage()).isEqualTo(Error.PURCHASE_AMOUNT_FORMAT.getText());
    }

    @DisplayName("구입 금액 입력 단위 검사")
    @ParameterizedTest
    @ValueSource(strings = {"14500", "1250", "270", "0"})
    public void 구입_금액_입력_단위_예외(String purchaseAmount) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> moneyService.savePurchaseAmount(purchaseAmount));
        assertThat(e.getMessage()).isEqualTo(Error.PURCHASE_AMOUNT_VALUE.getText());
    }

    @DisplayName("수익률 계산 검사")
    @Test
    public void 수익률_계산_확인() {
        moneyService.savePurchaseAmount("8000");

        EnumMap<Winner, Integer> winners = new EnumMap<>(Winner.class);
        winners.put(Winner.FIFTH_PLACE, 1);

        moneyService.saveRateOfReturn(winners);
        double rateOfReturn = moneyService.getRateOfReturn();

        double expected = (Winner.FIFTH_PLACE.getPrize() / 8000D) * 100;

        assertThat(rateOfReturn).isEqualTo(expected);
    }
}
