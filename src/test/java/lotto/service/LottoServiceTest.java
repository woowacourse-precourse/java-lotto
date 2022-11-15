package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Money;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private final LottoService lottoService = LottoService.getLottoService();


    @Test
    void generateLottosTest() {
        int lottoCnt = 8;
        List<Lotto> lottos = lottoService.generateLottos(lottoCnt);
        assertThat(lottos.size()).isEqualTo(lottoCnt);
    }

    @Test
    void generateWinningLottoTest() {
        String input = "1,2,3,4,5,6";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Lotto lotto = lottoService.generateWinningLotto();

        assertThat(Lotto.class).isEqualTo(lotto.getClass());
        assertThat(lotto.getLottoNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @Test
    void generateBonusNumberTest() {
        String input = "7";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int bonusNumber = lottoService.generateBonusNumber();
        assertThat(bonusNumber).isEqualTo(7);
    }

    @Test
    void getLottoCntByMoneyTest() {
        int input = 8000;
        Money money = new Money(input);

        assertThat(lottoService.getLottoCntByMoney(money)).isEqualTo(8);
    }
}