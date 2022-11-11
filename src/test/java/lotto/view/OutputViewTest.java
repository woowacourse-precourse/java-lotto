package lotto.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    OutputView outputView = new OutputView();

    @BeforeEach
    public void setUpStreamsAndInit() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void 로또_구매_개수_출력() {
        String purchaseLottoCountMessage = "8개를 구매했습니다.\n";
        outputView.printPurchaseLottoCount(8);
        assertThat(output.toString()).isEqualTo(purchaseLottoCountMessage);
    }

}