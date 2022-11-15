package lotto.view;

import lotto.model.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
        outputView.announceInputWinningNumbers();

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

}