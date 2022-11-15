package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {

    private LottoGame game;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        game = new LottoGame();

        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    static Stream<Arguments> generateCompareLotteriesResultArg() {
        List<Lotto> lotteries = List.of(
                new Lotto(List.of(1, 2, 7, 8, 9, 10)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        return Stream.of(
                Arguments.of(lotteries, winningNumbers, bonus)
        );
    }


    @ParameterizedTest
    @ValueSource(strings = {"2000", "3000", "4000", "5000"})
    @DisplayName("로또의 구입 금액을 정상적으로 입력했을 때 파싱되는지 테스트")
    void parseBuyPriceTest(String userInput) {
        assertThat(game.parseBuyPrice(userInput)).isEqualTo(Integer.parseInt(userInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {"200A", "3200", "4050", "ABCD"})
    @DisplayName("로또의 구입 금액을 잘못 입력했을 때 파싱되는지 테스트")
    void parseBuyPriceFailureTest(String userInput) {
        assertThatThrownBy(() -> game.parseBuyPrice(userInput)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "7,12,24,25,27,40", "12,14,26,30,32,39"})
    @DisplayName("당첨 번호를 파싱 성공하는 기능 테스트")
    void parseWinningNumbers(String winningNumberInput) {
        assertThat(game.parseWinningNumbers(winningNumberInput).size()).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "7,12,24,25,27", "12.14.26.30.32.39", "12,14,26,30,2!,39", "12,14,26,30,32,72"})
    @DisplayName("당첨 번호를 파싱 성공하는 기능 테스트")
    void parseWinningFailureNumbers(String winningNumberInput) {
        assertThatThrownBy(() -> game.parseWinningNumbers(winningNumberInput)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("generateCompareLotteriesResultArg")
    @DisplayName("당첨 결과를 비교하는 기능 테스트")
    void compareLotteriesResult(List<Lotto> lotteries, List<Integer> winningNumbers, int bonus) {


        Map<LottoResult, Integer> actual = game.compareLotteriesResult(lotteries, winningNumbers, bonus);

        assertThat(actual.containsKey(LottoResult.Match3)).isEqualTo(true);
        assertThat(actual.containsKey(LottoResult.Match4)).isEqualTo(true);
        assertThat(actual.containsKey(LottoResult.Match5AndBonus)).isEqualTo(true);
        assertThat(actual.containsKey(LottoResult.Match6)).isEqualTo(true);
        assertThat(actual.containsKey(LottoResult.None)).isEqualTo(false);
        assertThat(actual.containsKey(LottoResult.Match5)).isEqualTo(false);

        assertThat(actual.get(LottoResult.Match3)).isEqualTo(1);
        assertThat(actual.get(LottoResult.Match4)).isEqualTo(1);
        assertThat(actual.get(LottoResult.Match5AndBonus)).isEqualTo(1);
        assertThat(actual.get(LottoResult.Match6)).isEqualTo(1);
    }


    @Test
    @DisplayName("로또 당첨 결과를 출력하는 기능 테스트")
    void printResultTest() {
        Map<LottoResult, Integer> lotteryResult = new HashMap<>();
        lotteryResult.put(LottoResult.Match3, 1);

        game.printResult(8000, lotteryResult);
        assertThat(captor.toString().trim()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 62.5%입니다."
        );
    }

}