package lotto.view;

import lotto.vo.LottoAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private final OutputView outputView = new OutputViewImpl();

    @Test
    @DisplayName("발행한 로또 개수를 메시지 포맷에 담아 출력할 수 있다.")
    void givenLottoAmount_whenRunningOutputView_thenPrintsLottoAmountMessage() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        LottoAmount lottoAmount = LottoAmount.of(10);

        //when
        outputView.printLottoAmount(lottoAmount);

        //then
        assertThat(out.toString().trim()).isEqualTo(String.format(OutputViewImpl.BUYED_LOTTO_AMOUNT_MESSAGE_FORMAT, 10));
    }

}