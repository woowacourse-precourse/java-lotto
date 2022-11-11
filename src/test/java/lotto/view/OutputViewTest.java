package lotto.view;

import lotto.Lotto;
import lotto.system.LottoApplication;
import lotto.vo.LottoAmount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private final OutputView outputView = new OutputViewImpl();

    @BeforeEach
    void setup() {
        LottoApplication.initializeValidators();
        LottoApplication.initializeConverters();
    }

    @AfterEach
    void runAfter() {
        LottoApplication.doAfter();
    }

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
        assertThat(out.toString())
                .isEqualTo(String.format("%s\n", String.format(OutputViewImpl.BUYED_LOTTO_AMOUNT_MESSAGE_FORMAT, 10)));
    }

    @Test
    @DisplayName("요청한 로또 개수 수만큼 발행한 로또 번호를 출력할 수 있다.")
    void givenLottoList_whenRunningOutputView_thenPrintsLottosMessage() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        List<Lotto> lottos = Arrays.asList(
                Lotto.of(Arrays.asList(8, 21, 23, 41, 42, 43)),
                Lotto.of(Arrays.asList(3, 5, 11, 16, 32, 38)),
                Lotto.of(Arrays.asList(7, 11, 16, 35, 36, 44)),
                Lotto.of(Arrays.asList(1, 8, 11, 31, 41, 42))
        );

        //when
        outputView.printLottos(lottos);

        //then
        assertThat(out.toString())
                .isEqualTo(
                        "[8, 21, 23, 41, 42, 43]\n" +
                                "[3, 5, 11, 16, 32, 38]\n" +
                                "[7, 11, 16, 35, 36, 44]\n" +
                                "[1, 8, 11, 31, 41, 42]\n\n"
                );
    }

}