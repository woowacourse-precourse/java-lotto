package lotto.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {

    @Test
    public void 당첨개수_테스트(){
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(4,0));
        input.add(Arrays.asList(4,0));
        input.add(Arrays.asList(4,0));
        input.add(Arrays.asList(5,1));
        Statistics statistics = new Statistics();
        statistics.setPrizeTable(input);
        assertThat(statistics.getPrizeTable().get(Prize.FOURTH)).isEqualTo(3);
    }

    @Test
    public void 수익률_테스트(){
        Statistics statistics = new Statistics();
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(4,0));
        input.add(Arrays.asList(4,0));
        input.add(Arrays.asList(4,0));
        statistics.setPrizeTable(input);
        statistics.setEarnedMoney();
        assertThat(statistics.calculateRate(7000)).isEqualTo(2142.9);
    }
}