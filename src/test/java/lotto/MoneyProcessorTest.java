package lotto;

import lotto.domain.MoneyProcessor;
import lotto.domain.MoneyProcessorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyProcessorTest {

    private MoneyProcessor moneyProcessor;

    @TestFactory
    @DisplayName("MoneyProcessor calculateMargin Test")
    Stream<DynamicTest> calculateMarginTest() {
        moneyProcessor = new MoneyProcessorImpl();

        return Stream.of(
                DynamicTest.dynamicTest("투자 8000원, 수익 5000원인 경우", () -> {
                    final double money = 8000;
                    final double after = 5000;
                    String result = moneyProcessor.calculateMargin(money, after);

                    assertThat(result).isEqualTo("62.5");
                })
        );
    }

    @TestFactory
    @DisplayName("MoneyProcessor calculateLottoCount Test")
    Stream<DynamicTest> calculateLottoCountTest() {
        moneyProcessor = new MoneyProcessorImpl();

        return Stream.of(
                DynamicTest.dynamicTest("투자 8000원, 수익 5000원인 경우", () -> {
                    final Integer money = 8000;
                    Integer result = moneyProcessor.calculateLottoCount(money);

                    assertThat(result).isEqualTo(8);
                })
        );
    }
}
