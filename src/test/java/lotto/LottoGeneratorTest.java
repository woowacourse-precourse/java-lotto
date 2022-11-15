package lotto;

import lotto.lottoGenerator.LottoGenerator;
import lotto.lottoGenerator.LottoGeneratorImpl;
import lotto.lottoGenerator.RandomNumbersGenerator;
import lotto.lottoGenerator.RandomNumbersGeneratorWithMissionUtils;
import lotto.numbers.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class LottoGeneratorTest {
    @Test
    void _1미만의_자연수를_입력한_경우() {
        //given
        RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGeneratorWithMissionUtils();
        LottoGenerator lottoGenerator = new LottoGeneratorImpl(randomNumbersGenerator);
        int numberOfPurchased = -1;
        //when
        Throwable throwable =  catchThrowable(() -> lottoGenerator.issueLottosByInputAmount(numberOfPurchased));

        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void _1이상의_자연수를_입력한_경우() {
        //given
        RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGeneratorWithMissionUtils();
        LottoGenerator lottoGenerator = new LottoGeneratorImpl(randomNumbersGenerator);
        int numberOfPurchased = 10000;
        //when
        List<Lotto> lottos = lottoGenerator.issueLottosByInputAmount(numberOfPurchased);

        //then
        assertThat(lottos.size())
                .isEqualTo(numberOfPurchased);
    }
}
