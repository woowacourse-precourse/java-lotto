package lotto.modelTest;

import lotto.model.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RevenueTest {
    @Test
    @DisplayName("집계정보 초기화시 집계정보의 키 값은 Rank의 Enum 객체 이름과 같은지 확인한다.")
    public void initializeStatics(){
        Revenue revenue = new Revenue();
        revenue.initializeRevenueStatics();
        HashMap<String, Integer> revenueStatics = revenue.getRevenueStatics();

        assertThat(revenueStatics.keySet().toArray()).containsAll(Rank.getRankNames());
    }
    @Test
    @DisplayName("집계정보 업데이트 시 해당하는 등수의 카운트가 증가하는지 확인한다.")
    public void updateStatics(){
        int firstOfRankingCount=1;

        Revenue revenue = new Revenue();
        revenue.initializeRevenueStatics();
        revenue.updateRevenueStatics("FIRST");
        HashMap<String, Integer> revenueStatics = revenue.getRevenueStatics();

        assertThat(revenueStatics.get("FIRST")).isEqualTo(firstOfRankingCount);
    }
    @Test
    @DisplayName("로또 당첨 통계를 집계하여 당첨 정보가 올바른지 확인한다.")
    public void checkCountStatics(){
        List<List<Integer>> matches;

        String raffleNumbers="1,45,5,11,23,20";
        String bonusNumber="15";

        // 순서대로 5개+보너스, 6개 맞춘 로또들이다.
        List<Lotto> lotteries=List.of(
                new Lotto(List.of(1,45,5,11,23,15)), // 5개 + 보너스 맞춘 로또
                new Lotto(List.of(1,45,5,11,23,20))); // 6개 맞춘 로또

        RaffleNumber raffleNumber = new RaffleNumber(raffleNumbers, bonusNumber);

        Discriminator discriminator = new Discriminator(raffleNumber);
        discriminator.discriminate(lotteries);
        matches = discriminator.getMatches();
        Revenue revenue = new Revenue();
        revenue.initializeRevenueStatics();
        revenue.makeStatics(matches);
        HashMap<String, Integer> revenueStatics = new HashMap<>();
        revenueStatics.put("FIRST", 1);
        revenueStatics.put("SECOND", 1);
        revenueStatics.put("THIRD", 0);
        revenueStatics.put("FOURTH", 0);
        revenueStatics.put("FIFTH", 0);
        revenueStatics.put("NOTHING", 0);

        assertThat(revenue.getRevenueStatics()).containsExactlyEntriesOf(revenueStatics);
    }
    @Test
    @DisplayName("로또 당첨 통계를 집계하여 수익금이 올바르게 합산되었는지 확인한다.")
    public void checkRevenueStatics(){
        List<List<Integer>> matches=new ArrayList<>();

        String raffleNumbers="1,45,5,11,23,20";
        String bonusNumber="15";

        // 순서대로 5개+보너스, 6개 맞춘 로또들이다.
        List<Lotto> lotteries=List.of(
                new Lotto(List.of(1,45,5,11,23,15)), // 5개 + 보너스 맞춘 로또
                new Lotto(List.of(1,45,5,11,23,20))); // 6개 맞춘 로또

        RaffleNumber raffleNumber = new RaffleNumber(raffleNumbers, bonusNumber);

        Discriminator discriminator = new Discriminator(raffleNumber);
        discriminator.discriminate(lotteries);
        matches = discriminator.getMatches();
        Revenue revenue = new Revenue();
        revenue.makeStatics(matches);
        int revenueResult=revenue.getRevenue();
        assertThat(revenueResult).isEqualTo(2030000000);
    }
}
