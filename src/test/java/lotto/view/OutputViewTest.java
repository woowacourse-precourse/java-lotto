package lotto.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;

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
        String message = "구입금액을 입력해 주세요.\n";

        // When
        outputView.announceInsertMoney();

        // Then
        assertEquals(message, outContent.toString());
    }

    @Test
    @DisplayName("당첨 번호 입력 메세지 출력")
    void announceInputWinningNumbers() {
        // Given
        String message = "당첨 번호를 입력해 주세요.\n";

        // When
        outputView.announceInputWinningNumbers();

        // Then
        assertEquals(message, outContent.toString());
    }

    @Test
    @DisplayName("보너스 번호 입력 메세지 출력")
    void announceInputBonusNumber() {
        // Given
        String message = "보너스 번호를 입력해 주세요.\n";

        // When
        outputView.announceInputWinningNumbers();

        // Then
        assertEquals(message, outContent.toString());
    }

    @Test
    @DisplayName("lotto를 몇 개 구매했는지에 대한 메세지 출력")
    void announceNumberOfPurchases() {
        // Given
        BigInteger numberOfLottos = new BigInteger("987654321");
        String message = "개를 구매했습니다.\n";

        // When
        outputView.announceNumberOfPurchases(numberOfLottos);

        // Then
        String resultMessage = numberOfLottos + message;
        assertEquals(resultMessage, outContent.toString());
    }
    
}