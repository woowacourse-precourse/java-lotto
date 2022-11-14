package lotto;

import lotto.service.Service;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ServiceTest {

    Service service = new Service();

    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> player;
    static int bonus;
    static Map<String, Integer> map = new HashMap<>();

    @BeforeAll
    static void test () {

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
    }
    static {
        map.put("30000000",1);
        map.put("50000",2);
        map.put("0",1);
    }


    @Test
    void matchLotteryNumberTest() {
        System.out.println(map.toString());

        Map<String, Integer> expected = service.matchLotteryNumber(list,player,bonus);
        System.out.println(expected.toString());

        assertThat(map.get("30000000")).isEqualTo(expected.get("30000000"));
        assertThat(map.get("50000")).isEqualTo(expected.get("50000"));
        assertThat(map.get("0")).isEqualTo(expected.get("0"));

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
