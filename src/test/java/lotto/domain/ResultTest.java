package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {
    @Test
    @DisplayName("Result의 초기 상태는 0,0,0,0,0,0 이다")
    void test1() {
        Result result = new Result();
        Map<Rank, Integer> rankIntegerMap = result.returnInfo();
        List<Integer> rankList = rankIntegerMap.keySet().stream().map(rank -> rankIntegerMap.get(rank))
                .collect(Collectors.toList());

        Assertions.assertThat(rankList).isEqualTo(List.of(0, 0, 0, 0, 0, 0));
    }

    @Test
    @DisplayName("1등이 당첨됐을 때 상태는 0,0,0,0,0,1 이다")
    void test2() {
        Result result = new Result();
        result.record(6, false);
        Map<Rank, Integer> rankIntegerMap = result.returnInfo();
        List<Integer> rankList = rankIntegerMap.keySet().stream().map(rank -> rankIntegerMap.get(rank))
                .collect(Collectors.toList());

        Assertions.assertThat(rankList).isEqualTo(List.of(0, 0, 0, 0, 0, 1));
    }

    @Test
    @DisplayName("1등 2개, 2등 1개, 3등 2개, 4등 0개, 5등 3개, 상금없음 100개일 때 상태는 100,1,0,2,1,2 이다")
    void test3() {
        Result result = new Result();
        //1
        result.record(6, false);
        result.record(6, false);
        //2
        result.record(5, true);
        //3
        result.record(5, false);
        result.record(5, false);
        //5
        result.record(3, true);
        result.record(3, false);
        result.record(3, false);
        //상금없음
        for (int i = 0; i < 100; i++) {
            result.record(2, true);
        }

        Map<Rank, Integer> rankIntegerMap = result.returnInfo();
        List<Integer> rankList = rankIntegerMap.keySet().stream().map(rank -> rankIntegerMap.get(rank))
                .collect(Collectors.toList());

        Assertions.assertThat(rankList).isEqualTo(List.of(100, 3, 0, 2, 1, 2));
    }
}