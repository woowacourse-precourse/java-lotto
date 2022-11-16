package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PurchaseMoneyTest {
    @ParameterizedTest
    @DisplayName("널값 또는 블랭크가 존재하는 경우")
    @ValueSource(strings = {" ", "", "   ", " "})
    void isBlank(String input) {
        assertThatThrownBy(() -> new PurchaseMoney(input))
                .hasMessage("[ERROR] 널값 또는 공백은 입력될 수 없습니다.");
    }
    @ParameterizedTest
    @DisplayName("구입 금액이 1000원 단위가 아닌 경우")
    @ValueSource(strings = {"1400", "2300", "1700", "2500"})
    void incorrectUnit(String input) {
        assertThatThrownBy(() -> new PurchaseMoney(input))
                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 가능합니다.");
    }

    @ParameterizedTest
    @DisplayName("숫자열 문자열이 아닌 경우")
    @ValueSource(strings = {"10k" , "11h", "1h1", "h11"})
    void incorrectData(String input){
        assertThatThrownBy(() -> new PurchaseMoney(input))
                .hasMessage("[ERROR] 숫자 문자열이 아닙니다.");
    }

    @ParameterizedTest
    @DisplayName("최소/최대로 구매할 수 있는 범위를 벗어난 경 ")
    @ValueSource(strings = {"800" , "900", "500", "350"})
    void incorrectRangeData(String input){
        assertThatThrownBy(() -> new PurchaseMoney(input))
                .hasMessage("[ERROR] 최소 1000원 이상부터 구입이 가능합니다.");
    }
}