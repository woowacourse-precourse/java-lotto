package lotto;

import lotto.service.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ServiceTest {

    Service service = new Service();

    static List<List<Integer>> list;
    List<Integer> player;
    int bonus;
    Map<String, Integer> map;

    @BeforeEach
    void test () {
        list = new ArrayList<>();
        List<Integer> list1 = List.of(1,2,3,4,5,6);
        List<Integer> list2 = List.of(1,2,3,8,9,55);
        List<Integer> list3 = List.of(1,2,3,8,6,55);
        List<Integer> list4 = List.of(11, 12, 13, 14, 15, 16);

        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        player = List.of(1,2,3,4,5,8);
        bonus = 6;


        map = service.matchLotteryNumber(list, player, bonus);

    }


    @Test
    void matchLotteryNumberTest() {
        System.out.println(map.toString());

        assertThat(map.get("30000000")).isEqualTo(1);
        assertThat(map.get("50000")).isEqualTo(2);
        assertThat(map.get("0")).isEqualTo(1);

    }

    @Test
    void sumTotalRewardTest() {
        String reward  = service.sumTotalReward(map);
        String expected = "30100000";

        assertThat(expected).isEqualTo(reward);
    }

    @Test
    void profitRateResultTest() {
        String result = service.profitRate(list.size());

        System.out.println(result);
    }
}
