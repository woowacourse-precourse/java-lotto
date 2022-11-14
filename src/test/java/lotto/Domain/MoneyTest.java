package lotto.Domain;

import lotto.Domain.MainValue.Money;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    SoftAssertions softAssertions = new SoftAssertions();

    @DisplayName("1000원으로 나눠지지 않으면 에러가 발생한다")
    @Test
    void createMoneyNotThousand() {
        softAssertions.assertThatThrownBy(() -> new Money("100"))
                .hasMessageContaining("ERROR")
                .isInstanceOf(IllegalArgumentException.class);

        softAssertions.assertAll();
    }

    @DisplayName("문자가 입력되면 에러가 발생한다")
    @Test
    void createMoneyChar() {
        softAssertions.assertThatThrownBy(() -> new Money("1000a"))
                .hasMessageContaining("ERROR")
                .isInstanceOf(IllegalArgumentException.class);

        softAssertions.assertAll();
    }
}
