package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CheckInputTest {
    @Test
    void checkPurchaseAmountPattern_예외_테스트() {
        assertThatThrownBy(() -> new CheckInput().checkPurchaseAmountPattern("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkPurchaseAmountRange_예외_테스트() {
        assertThatThrownBy(() -> new CheckInput().checkPurchaseAmountRange(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkPurchaseAmountUnit_예외_테스트() {
        assertThatThrownBy(() -> new CheckInput().checkPurchaseAmountUnit(5500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkPurchaseAmountValid_테스트() {
        assertThat(new CheckInput().checkPurchaseAmountValid("5000")).isEqualTo(5000);
    }
}