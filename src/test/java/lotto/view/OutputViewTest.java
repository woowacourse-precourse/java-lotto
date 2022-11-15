package lotto.view;

import lotto.Lotto;
import lotto.LottoGame;
import lotto.Lottos;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
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
    void printLottoCountAsFormattedMessage() throws NoSuchFieldException, IllegalAccessException {
        int money = 1000;

        LottoGame lottoGame = new LottoGame(money);

        lottoGame.start();

        Field field = lottoGame.getClass().getDeclaredField("lottos");
        field.setAccessible(true);

        Lottos lottos = (Lottos) field.get(lottoGame);

        List<Lotto> lotto = lottos.getLottos();
        Lotto lottoNumbers = lotto.get(0);
        List<Integer> lottoNumberss = lottoNumbers.getNumbers();

        String expectedCountFormat = String.format("%d개를 구매했습니다.\n[%d, %d, %d, %d, %d, %d]\n", money / 1000, lottoNumberss.get(0), lottoNumberss.get(1), lottoNumberss.get(2), lottoNumberss.get(3), lottoNumberss.get(4), lottoNumberss.get(5));

        assertThat(output.toString()).isEqualTo(expectedCountFormat);
    }
}