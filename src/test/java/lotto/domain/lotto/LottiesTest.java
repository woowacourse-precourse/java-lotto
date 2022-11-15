package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.rank.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;

public class LottiesTest {

    private MockedStatic.Verification verification;
    private Lotties lotties;
    private List<Integer> expected;
    private List<Integer> userLotto;
    private Object[] objects;

    @BeforeEach
    void init() {
        verification = () -> Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt());
        expected = List.of(6, 1, 2, 3, 32, 8);
        objects = mapToArr(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(9, 1, 2, 3, 4, 8),
                List.of(1, 2, 3, 4, 5, 32)
        );
        userLotto = List.of(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또를 주어진 개수만큼 발행한다.")
    @Test
    void createLotties() {
        int publishCount = 4;
        lotties = Lotties.create(publishCount);

        int lottoSize = lotties.count();

        assertThat(lottoSize).isEqualTo(4);
    }

    @DisplayName("당첨 맵의 크기는 발행한 로또의 개수와 같아야 한다.")
    @Test
    void getLottoWinMapSize() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            int publishCount = 4;
            int bonusNum = 32;

            randoms.when(verification).thenReturn(expected, objects);
            lotties = Lotties.create(publishCount);

            Map<LottoRank, Long> lottoWinMap = lotties.generateLottoRankMap(userLotto, bonusNum);

            assertThat(lottoWinMap.size()).isEqualTo(publishCount-1);
        }
    }

    @DisplayName("로또와 당첨 번호를 비교해서 일치하는 개수를 반환한다.")
    @ParameterizedTest
    @CsvSource({"FIRST, 1", "SECOND, 1", "FOURTH, 2"})
    void getMatchCountByLottoAndUserLotto(LottoRank rank, int count) {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            int publishCount = 4;
            int bonusNum = 32;

            randoms.when(verification).thenReturn(expected, objects);
            lotties = Lotties.create(publishCount);

            Map<LottoRank, Long> lottoWinCount = lotties.generateLottoRankMap(userLotto, bonusNum);

            assertThat(lottoWinCount.get(rank)).isEqualTo(count);
        }
    }

    @SafeVarargs
    private Object[] mapToArr(List<Integer>... values) {
        return Arrays.stream(values).toArray();
    }
}
