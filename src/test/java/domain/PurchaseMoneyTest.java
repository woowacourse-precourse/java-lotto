package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PurchaseMoneyTest {
    @ParameterizedTest
    @DisplayName("구입 금액이 1000원 단위가 아닌 경우")
    @ValueSource(strings = {"1400", "2300", "1700", "2500"})
    void incorrectUnit(String input) {
        assertThatThrownBy(() -> new PurchaseMoney(input))
                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 가능합니다");
    }

    @ParameterizedTest
    @DisplayName("널값 또는 블랭크가 존재하는 경우")
    @ValueSource(strings = {" ", "", "   ", " "})
    void isBlank(String input) {
        assertThatThrownBy(() -> new PurchaseMoney(input))
                .hasMessage("[ERROR] 널값 또는 공백은 입력될 수 없습니다.");
    }

    @Test
    @DisplayName("구매한 로또 개수")
    void buyLotto(){

    }
}