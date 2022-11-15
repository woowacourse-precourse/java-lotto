package lotto.domain;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCountTest {

    @DisplayName("구입 금액은 숫자외의 문자를 입력할 시 에러 발생")
    @Test
    void createPurchaseAmountUnvalidateType() {
        assertThatThrownBy(() -> new LottoCount("12,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해야 합니다.");
    }

    @DisplayName("구입 금액은 1000원 미만의 수를 입력할 시 에러 발생")
    @Test
    void createPurchaseAmountUnvalidateRange() {
        assertThatThrownBy(() -> new LottoCount("999"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000원 이상 구매해야 합니다.");
    }

    @DisplayName("구입 금액은 1000원 단위의 수를 입력하지 않을 시 에러 발생")
    @Test
    void createPurchaseAmountUnvalidateUnit() {
        assertThatThrownBy(() -> new LottoCount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000원 단위로 구매해야 합니다.");
    }

    @DisplayName("기준에 맞는 구입 금액이 입력될 시 정상적으로 리턴")
    @ParameterizedTest
    @CsvSource({"1000,1000", "15000,15000", "500000,500000", "1000000,1000000"})
    void createRightPurchaseAmount(String purchaseAmount, int expected) {
        LottoCount lottoCount = new LottoCount(purchaseAmount);
        assertThat(lottoCount.getPurchaseAmount()).isEqualTo(expected);
    }

    @DisplayName("기준에 맞는 구입 금액이 입력될 시 구입한 로또 수를 정상적으로 리턴")
    @ParameterizedTest
    @CsvSource({"1000,1", "15000,15", "500000,500", "1000000,1000"})
    void createRightLottoCount(String purchaseAmount, int expected) {
        LottoCount lottoCount = new LottoCount(purchaseAmount);
        assertThat(lottoCount.getLottoCount()).isEqualTo(expected);
    }
}