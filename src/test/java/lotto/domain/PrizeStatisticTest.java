package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class PrizeStatisticTest {
    @DisplayName("일치하는 숫자 개수와 보너스 숫자 일치 여부가 주어지면 그에 맞는 상금을 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "0,false,0",
            "1,false,0",
            "2,false,0",
            "3,false,5000",
            "4,false,50000",
            "5,false,1_500_000",
            "5,true,30_000_000",
            "6,false,2_000_000_000"
    })
    void returnMatchingPrize(int matchingNumber, boolean bonus, long prizeAmount){
        assertThat(PrizeStatistic.getPrizeAmount(matchingNumber, bonus)).isEqualTo(prizeAmount);
    }
}
