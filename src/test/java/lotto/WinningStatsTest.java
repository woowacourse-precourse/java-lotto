package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatsTest {
    private static final List<Lotto> purchase = new ArrayList<>(Arrays.asList(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(7, 8, 9, 10, 11, 12)),
            new Lotto(List.of(1, 2, 3, 7, 8, 9)),
            new Lotto(List.of(15, 17, 20, 25, 27, 29)),
            new Lotto(List.of(4, 7, 15, 22, 35, 42)),
            new Lotto(List.of(1, 7, 17, 22, 33, 39))
    ));

    @DisplayName("알맞은 당첨이 추가되는지 확인")
    @ParameterizedTest
    @MethodSource("WinningData")
    public void RightWinningStat(List<Integer> winningNumber, int bonus, int first, int second, int third, int forth, int fifth) {
        Lotto winning = new Lotto(winningNumber);

        // <Rank, Number>
        HashMap<Integer , Integer> map = new HashMap<>(){{
            put(1,first);
            put(2,second);
            put(3,third);
            put(4,forth);
            put(5,fifth);
        }};

        WinningStats winningStats = new WinningStats(purchase, winning, bonus);

        for(WinningStats.Winning c : winningStats.collection){
            assertThat(c.number).isEqualTo(map.get(c.rank));
        }
    }

    static Stream<Arguments> WinningData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,7,15,21,25,40),6,0,0,0,0,0),
                Arguments.of(Arrays.asList(1,2,3,4,5,6),7,1,0,0,0,1),
                Arguments.of(Arrays.asList(1,2,3,4,5,7),6,0,1,0,1,0),
                Arguments.of(Arrays.asList(7,8,9,10,22,41),1,0,0,0,1,1),
                Arguments.of(Arrays.asList(7,17,20,25,27,29),45,0,0,1,0,0)
        );
    }


    @DisplayName("수익률 계산이 알맞게 작동하는지 확인")
    @ParameterizedTest
    @MethodSource("EarningRateData")
    void RightEarningRate(List<Integer> winningNumber, int bonus, double earningRate) {
        Lotto winning = new Lotto(winningNumber);
        WinningStats winningStats = new WinningStats(purchase, winning, bonus);
        winningStats.CalculateEarningRate(purchase.size() * 1000);
        assertThat(WinningStats.earningRate).isEqualTo(earningRate);
    }

    static Stream<Arguments> EarningRateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,7,15,21,25,40),6,0),
                Arguments.of(Arrays.asList(1,2,3,4,5,6),7,33333416.7),
                Arguments.of(Arrays.asList(1,2,3,4,5,7),6,500833.3),
                Arguments.of(Arrays.asList(7,8,9,10,22,41),1,916.7),
                Arguments.of(Arrays.asList(7,17,20,25,27,29),45,25000.0)
        );
    }

}