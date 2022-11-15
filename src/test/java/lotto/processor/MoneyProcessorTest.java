package lotto.processor;

import lotto.domain.processor.MoneyProcessor;
import lotto.domain.processor.MoneyProcessorImpl;
import lotto.domain.enummodel.RankEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;
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

    @TestFactory
    @DisplayName("MoneyProcessor calculateWinning Test")
    Stream<DynamicTest> calculateCalculateWinningTest() {
        moneyProcessor = new MoneyProcessorImpl();

        return Stream.of(
                DynamicTest.dynamicTest("5등 당첨이 2개 있는경우", () -> {
                    final List<Integer> resultCount = new ArrayList<>(List.of(1, 2, 3, 3));

                    Integer result = moneyProcessor.calculateWinning(resultCount, RankEnum.FIFTH);

                    assertThat(result).isEqualTo(10000);
                }),
                DynamicTest.dynamicTest("1등 당첨이 1개 있는경우", () -> {
                    final List<Integer> resultCount = new ArrayList<>(List.of(1, 2, 5, 7));

                    Integer result = moneyProcessor.calculateWinning(resultCount, RankEnum.FIRST);

                    assertThat(result).isEqualTo(2000000000);
                }),
                DynamicTest.dynamicTest("2등 당첨이 2개 있는경우", () -> {
                    final List<Integer> resultCount = new ArrayList<>(List.of(1, 2, 6, 6));

                    Integer result = moneyProcessor.calculateWinning(resultCount, RankEnum.SECOND);

                    assertThat(result).isEqualTo(60000000);
                }),
                DynamicTest.dynamicTest("3등 당첨이 2개 있는경우", () -> {
                    final List<Integer> resultCount = new ArrayList<>(List.of(1, 5, 3, 5));

                    Integer result = moneyProcessor.calculateWinning(resultCount, RankEnum.THIRD);

                    assertThat(result).isEqualTo(3000000);
                })
        );
    }
}
