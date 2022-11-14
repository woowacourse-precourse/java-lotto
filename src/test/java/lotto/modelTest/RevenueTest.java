package lotto.modelTest;

import lotto.model.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RevenueTest {
    @Test
    @DisplayName("집계정보 초기화시 집계정보의 키 값은 Rank의 Enum 객체 이름과 같은지 확인한다.")
    public void initializeStatics(){

        String raffleNumbers="1,45,5,11,23,20";
        String bonusNumber="15";
        RaffleNumber raffleNumber = new RaffleNumber(raffleNumbers, bonusNumber);

        Discriminator discriminator = new Discriminator(raffleNumber);

        Revenue revenue = new Revenue(discriminator);
        revenue.initializeRevenueStatics();
        HashMap<String, Integer> revenueStatics = revenue.getRevenueStatics();

        assertThat(revenueStatics.keySet().toArray()).containsAll(Rank.getRankNames());
    }
}
