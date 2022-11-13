package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class PrizeTest {

    @DisplayName("당첨 번호 일치 개수에 따라 당첨액을 반환한다.")
    @ParameterizedTest(name = "{index}. 일치 : {0}개, 보너스 일치 : {1}, 당첨금액 : {2}")
    @CsvSource({"1,true,0", "2,false,0", "3,true,5_000", "4,true,50_000", "5,false,1_500_000", "5,true,30_000_000",
            "6,true,2_000_000_000"})
    void getPrizeMoneyTest(int lottoMatchCount, boolean bonusMatching, int prizeMoney) {
        Prize prize = Prize.getPrize(lottoMatchCount, bonusMatching);
        assertThat(prize.getPrizeMoney()).isEqualTo(prizeMoney);
    }
}