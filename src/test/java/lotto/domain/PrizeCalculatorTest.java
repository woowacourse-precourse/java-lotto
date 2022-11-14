package lotto.domain;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

public class PrizeCalculatorTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @ParameterizedTest
    @MethodSource("provideParametersForCompareTest")
    @DisplayName("로또와 당첨 번호를 비교해서 일치하는 숫자 개수를 구한다")
    void compareLottoAndWinningNumber(Lotto lotto, List<Integer> winningNumber, int result) {
        PrizeCalculator prizeCalculator = new PrizeCalculator();
        assertThat(prizeCalculator.compareWinningNumbers(lotto, winningNumber)).isEqualTo(result);
    }
    private static Stream<Arguments> provideParametersForCompareTest() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1,2,3,4,5,6)), List.of(7,8,9,10,11,12), 0),
                Arguments.of(new Lotto(List.of(1,2,3,4,5,7)), List.of(7,8,9,10,11,12), 1),
                Arguments.of(new Lotto(List.of(1,2,3,4,7,8)), List.of(7,8,9,10,11,12), 2),
                Arguments.of(new Lotto(List.of(1,2,3,7,8,9)), List.of(7,8,9,10,11,12), 3),
                Arguments.of(new Lotto(List.of(1,2,7,8,9,10)), List.of(7,8,9,10,11,12), 4),
                Arguments.of(new Lotto(List.of(1,7,8,9,10,11)), List.of(7,8,9,10,11,12), 5),
                Arguments.of(new Lotto(List.of(7,8,9,10,11,12)), List.of(7,8,9,10,11,12), 6)
        );
    }

    @DisplayName("일치하는 숫자 개수와 보너스 숫자 일치 여부가 주어지면 그에 맞는 상금을 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "0,false,0",
            "1,false,0",
            "2,false,0",
            "3,false,5000",
            "4,false,50000",
            "5,false,1_500_000",
            "5,true,30_000_000",
            "6,false,2_000_000_000"
    })
    void returnMatchingPrize(int matchingNumber, boolean bonus, long prizeAmount) {
        PrizeCalculator prizeCalculator = new PrizeCalculator();
        assertThat(prizeCalculator.getPrizeAmount(matchingNumber, bonus)).isEqualTo(prizeAmount);
    }

    @Test
    @DisplayName("3개 일치 하나인 경우의 로또 결과를 출력한다.")
    void getResultStringForLottoOne3Match() {
        PrizeCalculator prizeCalculator = new PrizeCalculator();
        prizeCalculator.getResultForLotto(new Lotto(List.of(1,2,3,7,8,9)), List.of(7,8,9,10,11,12), 13);
        prizeCalculator.printPrizeResult();
        assertThat(output()).contains("당첨 통계", "3개 일치 (5,000원) - 1개", "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개", "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개");
    }

    @Test
    @DisplayName("5개 일치 하나와 6개일치 하나인 경우의 로또 결과를 출력한다.")
    void getResultStringForLottoOne5MatchOne6Match() {
        PrizeCalculator prizeCalculator = new PrizeCalculator();
        prizeCalculator.getResultForLotto(new Lotto(List.of(12,11,3,7,8,9)), List.of(7,8,9,10,11,12), 13);
        prizeCalculator.getResultForLotto(new Lotto(List.of(12,11,10,7,8,9)), List.of(7,8,9,10,11,12), 13);
        prizeCalculator.printPrizeResult();
        assertThat(output()).contains("당첨 통계", "3개 일치 (5,000원) - 0개", "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 1개", "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 1개");
    }

    @Test
    @DisplayName("일치가 없는 경우의 로또 결과를 출력한다.")
    void getResultStringForLottoNoMatch() {
        PrizeCalculator prizeCalculator = new PrizeCalculator();
        prizeCalculator.printPrizeResult();
        assertThat(output()).contains("당첨 통계", "3개 일치 (5,000원) - 0개", "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개", "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개");
    }
}
