package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorUtilityTest {

    public CalculatorUtility calculatorUtility;
    @BeforeEach
    void setUp() {
        calculatorUtility = new CalculatorUtility();
    }

    @DisplayName("구입 금액을 발행할 로또 개수로 변환하는 테스트")
    @Test
    void convertMoneyToTickets() {
        int purchasingAmount = 10000;

        int tickets = calculatorUtility.convertMoneyToTickets(10000);

        Assertions.assertThat(tickets).isEqualTo(10);
    }

}