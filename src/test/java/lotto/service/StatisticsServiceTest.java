package lotto.service;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static constants.Constants.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

class StatisticsServiceTest {
    private final StatisticsService statisticsService = new StatisticsService();
    WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

    @DisplayName("통계 계산을 확인한다., 각 로또의 등수를 계산한다.")
    @ParameterizedTest
    @MethodSource("generatedData")
    void calculateRating(List<Integer> userNums, List<Integer> expect) {
        User user = setUpUser(List.of(userNums));
        Statistics result = statisticsService.calculateRating(user, winningLotto);
        Statistics expected = setUpStatistics(expect);
        assertThat(result).usingRecursiveComparison().isEqualTo(expected);
    }

    static Stream<Arguments> generatedData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 0, 0, 0, 0, 0)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), Arrays.asList(0, 1, 0, 0, 0, 0)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 8), Arrays.asList(0, 0, 1, 0, 0, 0)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 9, 10), Arrays.asList(0, 0, 0, 1, 0, 0)),
                Arguments.of(Arrays.asList(1, 2, 3, 10, 11, 12), Arrays.asList(0, 0, 0, 0, 1, 0)),
                Arguments.of(Arrays.asList(1, 2, 24, 34, 44, 45), Arrays.asList(0, 0, 0, 0, 0, 1))
        );
    }

    private Statistics setUpStatistics(List<Integer> expect) {
        Map<Prize, Integer> prizeCntMap = new EnumMap<>(Prize.class);
        List<Prize> prizeList = List.of(Prize.first, Prize.second, Prize.third, Prize.fourth, Prize.fifth, Prize.none);
        for (int rank = 0; rank < prizeList.size(); rank++) {
            Prize nowPrize = prizeList.get(rank);
            int nowPoint = expect.get(rank);
            if (0 < nowPoint) {
                prizeCntMap.put(nowPrize, nowPoint);
            }
        }
        return new Statistics(prizeCntMap);
    }

    private User setUpUser(List<List<Integer>> nums) {
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> nowNums : nums) {
            lottos.add(new Lotto(nowNums));
        }
        int piece = nums.size();
        return new User(piece * LOTTO_PRICE, piece, lottos);
    }

}