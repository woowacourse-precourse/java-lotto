package lotto.view;

import lotto.enums.PrizeOfLotto;
import lotto.model.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputViewTest {
    OutputView outputView = new OutputView();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();    final PrintStream standardOut = System.out;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("구입금액 입력 메세지 출력")
    void announceInsertMoney() {
        // Given

        // When
        outputView.announceInsertMoney();

        // Then
        String message = "구입금액을 입력해 주세요.\n";
        assertEquals(message, outContent.toString());
    }

    @Test
    @DisplayName("당첨 번호 입력 메세지 출력")
    void announceInputWinningNumbers() {
        // Given

        // When
        outputView.announceInputWinningNumbers();

        // Then
        String message = "당첨 번호를 입력해 주세요.\n";
        assertEquals(message, outContent.toString());
    }

    @Test
    @DisplayName("보너스 번호 입력 메세지 출력")
    void announceInputBonusNumber() {
        // Given

        // When
        outputView.announceInputBonusNumber();

        // Then
        String message = "보너스 번호를 입력해 주세요.\n";
        assertEquals(message, outContent.toString());
    }

    @Test
    @DisplayName("lotto를 몇 개 구매했는지에 대한 메세지 출력")
    void announceNumberOfPurchases() {
        // Given
        BigInteger numberOfLottos = new BigInteger("987654321");

        // When
        outputView.announceNumberOfPurchases(numberOfLottos);

        // Then
        String message = "개를 구매했습니다.\n";
        String resultMessage = numberOfLottos + message;
        assertEquals(resultMessage, outContent.toString());
    }

    @Test
    @DisplayName("구매한 lotto들을 출력")
    void printLottos() {
        // Given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        // When
        outputView.printLottos(lottos);

        // Then
        String message =
                "[8, 21, 23, 41, 42, 43]\n"
                + "[3, 5, 11, 16, 32, 38]\n"
                + "[7, 11, 16, 35, 36, 44]\n"
                + "[1, 8, 11, 31, 41, 42]\n"
                + "[13, 14, 16, 38, 42, 45]\n"
                + "[7, 11, 30, 40, 42, 43]\n"
                + "[2, 13, 22, 32, 38, 45]\n"
                + "[1, 3, 5, 14, 22, 45]\n";
        assertEquals(message, outContent.toString());
    }

    @Test
    @DisplayName("결과에 대해 출력")
    void printResultOfLottos() {
        // Given
        Map<String, Integer> resultOfLottos = new HashMap<>(Map.of(
                PrizeOfLotto.FIRST.getRank(), 3,
                PrizeOfLotto.SECOND.getRank(), 0,
                PrizeOfLotto.THIRD.getRank(), 0,
                PrizeOfLotto.FOURTH.getRank(), 1,
                PrizeOfLotto.FIFTH.getRank(), 0
        ));
        float ratio = (float) 123714.3;

        // When
        outputView.printResultOfLottos(resultOfLottos, ratio);

        // Then
        String message =
                "당첨 통계\n"
                + "---\n"
                + "6개 일치 (2,000,000,000원) - 3개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "4개 일치 (50,000원) - 1개\n"
                + "3개 일치 (5,000원) - 0개\n"
                + "총 수익률은 123,714.3%입니다.";
        assertEquals(message, outContent.toString());
    }

}