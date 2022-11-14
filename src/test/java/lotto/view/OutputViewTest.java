package lotto.view;

import lotto.Lottos;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void printLottoCountAsFormattedMessage() {
        int lottoAmount = 4;
        Lottos lottos = new Lottos(lottoAmount);
        OutputView.printLottoCount(lottos);

        String expectedCountFormat = String.format("%d개를 구매했습니다.\n", lottoAmount);

        assertThat(output.toString()).isEqualTo(expectedCountFormat);
    }

    @Test
    void printLottoNumberAsFormattedMessage() {
        int lottoAmount = 1;
        Lottos lottos = new Lottos(lottoAmount);
        OutputView.printLottos(lottos);
        List<Integer> lotto = lottos.getLottos().get(0).getNumbers();

        String expectedLottoFormat = String.format("[%d, %d, %d, %d, %d, %d]\n", lotto.get(0), lotto.get(1), lotto.get(2), lotto.get(3), lotto.get(4), lotto.get(5));

        assertThat(output.toString()).isEqualTo(expectedLottoFormat);
    }
}