package PrinterTest;

import Printer.MessagePrinter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Character.Lotto;
import Character.User;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class MessagePrinterTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    MessagePrinter messagePrinter = new MessagePrinter();
    User user = new User();

    @BeforeEach
    public void setUpStreams() {
        System.setOut((new PrintStream(output)));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void printInputMoneyTest() {
        String result = "구입금액을 입력해주세요.\r\n";
        messagePrinter.printInputMoneyMessage();
        assertThat(output.toString()).isEqualTo(result);
    }

    @Test
    void printPurchaseConfirmMessageTest() {
        int howManyLotto = 3;
        String result = "3개를 구매했습니다.\r\n";
        messagePrinter.printPurchaseConfirmMessage(howManyLotto);
        assertThat(output.toString()).isEqualTo(result);
    }

    @Test
    void printPurchasedLottoTest() {
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        List<Integer> numbers2 = List.of(11,12,13,14,21,22);
        Lotto lotto = new Lotto(numbers);
        Lotto lotto2  = new Lotto(numbers);
        List<Lotto> lottoBundle = new ArrayList<Lotto>();
        lottoBundle.add(lotto);
        lottoBundle.add(lotto2);
        String result = lotto.getLotto().toString()+"\r\n"+lotto2.getLotto().toString()+"\r\n";
        messagePrinter.printPurchasedLotto(lottoBundle);
        assertThat(output.toString()).isEqualTo(result);
    }

    @Test
    void printInputWinningNumberMessageTest() {
        String result = "당첨 번호를 입력해주세요.\r\n";
        messagePrinter.printInputWinningNumberMessage();
        assertThat(output.toString()).isEqualTo(result);
    }

    @Test
    void printInputBonusNumberMessageTest() {
        String result = "보너스 번호를 입력해 주세요.\r\n";
        messagePrinter.printInputBonusNumberMessage();
        assertThat(output.toString()).isEqualTo(result);
    }

    @Test
    void printWinningResultTest() {
        List<Integer> winningNumberCounting = List.of(0,1,2,2,1,0,1,0);
        String result = "당첨 통계\n---\r\n3개 일치 (5,000원) - "+"2개\r\n"+"4개 일치 (50,000원) - "+"1개\r\n"+"5개 일치 (1,500,000원) - "+"0개\r\n"+
                "5개 일치, 보너스 볼 일치 (30,000,000원) - "+"1개\r\n"+"6개 일치 (2,000,000,000원) - 0개\r\n";
        messagePrinter.printWinningResult(winningNumberCounting);
        assertThat(output.toString()).isEqualTo(result);
    }

    @Test
    void printEarningRateTest() {
        double EarningRate = 0.58;
        String result = "총 수익률은 58.0%입니다.\r\n";
        messagePrinter.printEarningsRate(EarningRate);
        assertThat(output.toString()).isEqualTo(result);
    }
}
