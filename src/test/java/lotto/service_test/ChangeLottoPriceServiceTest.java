package lotto.service_test;

import lotto.Ranking;
import lotto.service.ChangeLottoPriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class ChangeLottoPriceServiceTest {

    ChangeLottoPriceService changeLottoPriceService;

    @BeforeEach
    void initializeClass(){
        changeLottoPriceService = new ChangeLottoPriceService();
    }

    @DisplayName("3개가 일치했을 때 5000이 반환된다. ")
    @Test
    void changeTHREE_MATCHToPrice(){
        assertThat(changeLottoPriceService.changeRankingToPrice(Ranking.THREE_MATCH)).isEqualTo(5000L);
    }

    @DisplayName("3개가 일치했을 때 5000이 반환된다. ")
    @Test
    void changeFOUR_MATCHToPrice(){
        assertThat(changeLottoPriceService.changeRankingToPrice(Ranking.THREE_MATCH)).isEqualTo(5000L);
    }

    @DisplayName("3개가 일치했을 때 5000이 반환된다. ")
    @Test
    void changeFIVE_MATCHToPrice(){
        assertThat(changeLottoPriceService.changeRankingToPrice(Ranking.THREE_MATCH)).isEqualTo(5000L);
    }

    @DisplayName("3개가 일치했을 때 5000이 반환된다. ")
    @Test
    void changeFIVE_MATCH_WITH_BONUS_NUMBERToPrice(){
        assertThat(changeLottoPriceService.changeRankingToPrice(Ranking.THREE_MATCH)).isEqualTo(5000L);
    }

    @DisplayName("3개가 일치했을 때 5000이 반환된다. ")
    @Test
    void changeSIX_MATCHToPrice(){
        assertThat(changeLottoPriceService.changeRankingToPrice(Ranking.THREE_MATCH)).isEqualTo(5000L);
    }
}
