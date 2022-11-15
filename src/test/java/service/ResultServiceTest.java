package service;

import domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultServiceTest {
    ResultServiceImpl resultService;

    @BeforeEach
    void beforeEach() {
        resultService = new ResultServiceImpl();
    }

    @DisplayName("등수가 맞게 나오는지 확인")
    @Test
    void compareTest() {
        List<Integer> listOfUserNum = List.of(1,2,3,4,5,6);
        List<List<Integer>> lottoList =
                List.of(
                        List.of(1,2,3,4,5,6), // 1등
                        List.of(6,5,4,3,2,1),  // 1등
                        List.of(12, 13, 14, 15, 16, 17), // 없음
                        List.of(1, 3, 4, 5, 6, 17), // 3등
                        List.of(1, 3, 4, 5, 16, 17), // 4등
                        List.of(1,4,7,9,3,11),  // 5등
                        List.of(1,2,3,4,5,7) // 2등
                );
        int bonus = 7;

        Map<Rank, Integer> testOfCompare = resultService.compare(listOfUserNum, lottoList, bonus);
        Map<Rank, Integer> resultOfCompare = new EnumMap<Rank, Integer>(Rank.class);
        resultOfCompare.put(Rank.FIRST, 2);
        resultOfCompare.put(Rank.SECOND, 1);
        resultOfCompare.put(Rank.THIRD, 1);
        resultOfCompare.put(Rank.FOURTH, 1);
        resultOfCompare.put(Rank.FIFTH, 1);
        assertThat(testOfCompare).isEqualTo(resultOfCompare);
    }


}
