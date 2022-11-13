package lotto;

import lotto.Domain.Lotto;
import lotto.Domain.LottoShop;
import lotto.Domain.Statistic;
import lotto.Utils.LottoInspector;
import lotto.Utils.Printer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static lotto.Enum.ErrorMessage.*;
import static lotto.Enum.StatisticMessage.TOTAL_YIELD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    // 아래에 추가 테스트 작성 가능

    @DisplayName("당첨번호를 입력할때 예외를 확인한다.")
    @Test
    void inputWinningNumbers() {
        LottoInspector inspector = new LottoInspector();

        String input01 = "1,2,3,4,5,5";
        assertThatThrownBy(() -> inspector.winningNumberToList(input01))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_NUMBERS.toMessage());

        String input02 = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> inspector.winningNumberToList(input02))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_PROPER_WINNING_NUMBER_LENGTH.toMessage());

        String input03 = "1,2,3,4,5";
        assertThatThrownBy(() -> inspector.winningNumberToList(input03))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_PROPER_WINNING_NUMBER_LENGTH.toMessage());

        String input04 = "1,2,삼,4,5,6";
        assertThatThrownBy(() -> inspector.winningNumberToList(input04))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_INPUT_INTEGER_VALUE.toMessage());
    }

    @DisplayName("당첨시 수익률을 확인한다.(구매금액을 제외하지 않는다.)")
    @Test
    void checkYield() {
        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOutput));

        LottoShop shop = new LottoShop();
        Statistic statistic = new Statistic();
        String message = TOTAL_YIELD.getMessage();

        shop.money = 1000;
        shop.winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        shop.bonusNumber = 7;

        List<Double> expectedYieldPercentList = List.of(
                500.0,
                200000000.0,
                3000000.0,
                0.0
        );

        List<List<Integer>> sampleLottoList = List.of(
                List.of(1, 2, 3, 31, 32, 33),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 7, 45),
                List.of(21, 22, 23, 24, 25, 26)
        );

        for (int i = 0; i < expectedYieldPercentList.size(); i++) {
            consoleOutput.reset();

            shop.soldLottoList = List.of( sampleLottoList.get(i));
            statistic.analyze();

            double expectedYieldPercent = expectedYieldPercentList.get(i);
            String expectedYield = String.format("%.1f", expectedYieldPercent);
            System.out.printf(message, expectedYieldPercent);

            assertThat(consoleOutput.toString()).isEqualTo("총 수익률은 " + expectedYield + "%입니다.\n");
        }

    }

}
