package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/*
 * 당첨 번호 입력 프롬프트 출력 및 입력 수행
 */
public class LottoConsoleTest {

    @Test
    @DisplayName("로또 구매 금액 입력 프롬프트 출력")
    public void promptAskBuyingMessage() {
        final var sut = new LottoConsole();

        final String buyingAskMessage = sut.buyingAskMessage();

        assertEquals("구입금액을 입력해 주세요.", buyingAskMessage);
    }

    @Test
    @DisplayName("로또 구매 금액 개수 및 로또 번호 출력")
    public void promptBoughtLottoMessage() {
        final var sut = new LottoConsole();
        final var firstOne = Arrays.asList(1, 2, 3, 4, 5, 6);
        final var secondOne = Arrays.asList(1, 2, 3, 4, 5, 6);
        final var thirdOne = Arrays.asList(1, 2, 3, 4, 5, 6);
        final var lottos = Arrays.asList(firstOne, secondOne, thirdOne);

        final String buoughtLottoMessage = sut.boughtLottoMessage(lottos);

        assertEquals(
            "3개를 구매했습니다.\n[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]",
            buoughtLottoMessage
        );
    }

    @Test
    @DisplayName("당첨 번호 입력 프롬프트 출력")
    public void promptAskWinningNumbersMessage() {
        final var sut = new LottoConsole();

        final String winningNumbersMessage = sut.winningNumbersAskMessage();

        assertEquals("당첨 번호를 입력해 주세요.", winningNumbersMessage);
    }

    @Test
    @DisplayName("당첨 번호 입력 프롬프트 출력")
    public void promptAskBonusNumbersMessage() {
        final var sut = new LottoConsole();

        final String winningNumbersMessage = sut.bonusNumbersAskMessage();

        assertEquals("보너스 번호를 입력해 주세요.", winningNumbersMessage);
    }

    @Test
    @DisplayName("당첨 통계 메시지 출력")
    public void printWinningStatisticsHeaderMessage() {
        final var sut = new LottoConsole();

        final String winningStatisticsHeaderMessage = sut.winningStatisticsHeaderMessage();

        assertEquals("당첨 통계\n---", winningStatisticsHeaderMessage);
    }

    @ParameterizedTest
    @MethodSource("numbersWon")
    @DisplayName("당첨 내역 출력")
    public void printNumbersWhetherItWonOrNot(
        final int numberOfCorrectDigits,
        final boolean bonusMatched,
        final int prize,
        final int numberOfWinning,
        String expectedText
    ) {
        final var sut = new LottoConsole();

        final String messageOfNumbersWhetherItWonOrNot = sut.messageOfNumbersWhetherItWonOrNot(
            numberOfCorrectDigits,
            bonusMatched,
            prize,
            numberOfWinning
        );

        assertEquals(expectedText, messageOfNumbersWhetherItWonOrNot);
    }

    static Stream<Arguments> numbersWon() throws Throwable {
        return Stream.of(
            Arguments.of(3, false, 5000, 1, "3개 일치 (5,000원) - 1개"),
            Arguments.of(4, false, 50000, 0, "4개 일치 (50,000원) - 0개"),
            Arguments.of(5, false, 1500000, 0, "5개 일치 (1,500,000원) - 0개"),
            Arguments.of(5, true, 30000000, 0, "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개"),
            Arguments.of(6, false, 2000000000, 0, "6개 일치 (2,000,000,000원) - 0개")
        );
    }

    @Test
    @DisplayName("수익률 출력")
    public void printRoi() {
        final var sut = new LottoConsole();
        final double roi = 62.5d;

        final String roiMessage = sut.roiMessage(roi);

        assertEquals("총 수익률은 62.5%입니다.", roiMessage);
    }
}
