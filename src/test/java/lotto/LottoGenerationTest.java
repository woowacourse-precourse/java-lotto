package lotto;

import lotto.Lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoGenerationTest {

    public static LottoGenerator lottoGenerator;

    @BeforeAll
    static void init()
    {
        lottoGenerator = LottoGenerator.getInstance();
    }

    @DisplayName("로또 생성의 기본 예제")
    @Test
    void lottoGenerationExample()
    {
        int price = 8000;
        List<Lotto> lotties = lottoGenerator.generateLotties(price);

        Assertions.assertThat(lotties.size()).isEqualTo(8);
        for (Lotto lotto : lotties)
        {
            System.out.println(lotto);
            for(int i = 0 ; i < 5;i++)
            {
                Assertions.assertThat(lotto.get(i+1) - lotto.get(i)).isGreaterThan(0);
            }
        }
    }

    @DisplayName("구매 금액의 단위가 1,000으로 나누어 떨어지지 않을 경우")
    @Test
    void invalidPrice()
    {
        int price = 8001;
        Assertions.assertThatThrownBy(() ->
                lottoGenerator.generateLotties(price)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0원을 제시한 경우")
    @Test
    void zeroPrice()
    {
        int price = 0;
        List<Lotto> lottos = lottoGenerator.generateLotties(price);
        Assertions.assertThat(lottos.isEmpty()).isTrue();
    }

    @DisplayName("-1000원을 제시한 경우")
    @Test
    void negativePrice()
    {
        int price = -1000;
        Assertions.assertThatThrownBy(() ->
                lottoGenerator.generateLotties(price)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("나머지가 0이 아닌 경우")
    @Test
    void remainedPrice()
    {
        int price = Integer.MAX_VALUE;
        Assertions.assertThatThrownBy(() ->
                lottoGenerator.generateLotties(price)).isInstanceOf(IllegalArgumentException.class);
    }
}
