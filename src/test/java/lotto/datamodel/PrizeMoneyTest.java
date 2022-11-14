package lotto.datamodel;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class PrizeMoneyTest {
    PrizeMoney test = new PrizeMoney(List.of(50000,50000,5000));

    @DisplayName("얻은 모든 로또의 상금 총합을 전달한다")
    @Test
    void creatTotalPrize() {
        float result = test.reward();

        assertThat(result).isEqualTo(105);
    }

    @DisplayName("상금에 대한 정보를 전달한다")
    @Test
    void savePrizeInformation() {
        List<String> result = test.moneyInformation();

        assertThat(result).contains("3개 일치 (5,000원)");
    }

    @DisplayName("각 상금별로 몇개가 당첨되었는지 알려준다.")
    @Test
    void creatPrizeCount() {
        List<Integer> result = test.getFrequency();

        assertThat(result).isEqualTo(List.of(1,2,0,0,0));
    }
}
