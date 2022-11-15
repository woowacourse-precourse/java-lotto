package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest  {

    LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("구입금액 입력 테스트")
    @Test
    void insertMoneyTest() {
        String input = "5000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int money = lottoMachine.insertMoney(); // 5000원 입력하면 5000원
        assertThat(money).isEqualTo(5000);
    }

    @DisplayName("로또 발행 과정 테스트")
    @Test
    void createLottoTest(){
        List<Lotto> lottoBought = lottoMachine.createLotto(5000);
        assertThat(5).isEqualTo(lottoBought.size());
    }

    @DisplayName("로또 발행 개수 테스트")
    @Test
    void printLottoBoughtTest() {
        List<Lotto> lottoBought = lottoMachine.createLotto(5000);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        lottoMachine.printLottoBought(lottoBought);
        String testMsg = "5개를 구매했습니다.";
        assertThat(out.toString()).contains(testMsg);
    }
}