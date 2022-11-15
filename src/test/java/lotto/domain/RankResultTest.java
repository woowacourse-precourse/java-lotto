package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RankResultTest {

    private List<Integer> winLotto;
    private List<List<Integer>> randomLottos;
    private Map<Rank, Integer> rankMap;

    @BeforeEach
    void init() {
        winLotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 생성자_5등_검사() {
        randomLottos = new ArrayList<>();
        List<Integer> winLotto1 = new ArrayList<>(List.of(1, 2, 3, 8, 9, 10));
        randomLottos.add(winLotto1);
        RankResult result = new RankResult();

        result.addRankMapCount(winLotto, randomLottos, 43);

        assertThat(result.getResult().get(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    void 생성자_4등_검사() {
        randomLottos = new ArrayList<>();
        List<Integer> winLotto1 = new ArrayList<>(List.of(1, 2, 3, 4, 8, 9));
        randomLottos.add(winLotto1);
        RankResult result = new RankResult();

        result.addRankMapCount(winLotto, randomLottos, 11);

        assertThat(result.getResult().get(Rank.FOURTH)).isEqualTo(1);
    }

    @Test
    void 생성자_3등_검사() {
        randomLottos = new ArrayList<>();
        List<Integer> winLotto1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 7));
        randomLottos.add(winLotto1);
        RankResult result = new RankResult();

        result.addRankMapCount(winLotto, randomLottos, 8);

        assertThat(result.getResult().get(Rank.THIRD)).isEqualTo(1);
    }

    @Test
    void 생성자_2등_검사() {
        randomLottos = new ArrayList<>();
        List<Integer> winLotto1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 7));
        randomLottos.add(winLotto1);
        RankResult result = new RankResult();

        result.addRankMapCount(winLotto, randomLottos, 6);

        assertThat(result.getResult().get(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    void 생성자_1등_검사() {
        randomLottos = new ArrayList<>();
        List<Integer> winLotto1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        randomLottos.add(winLotto1);
        RankResult result = new RankResult();

        result.addRankMapCount(winLotto, randomLottos, 7);

        assertThat(result.getResult().get(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    void 수익률_계산_검사() {
        randomLottos = new ArrayList<>(List.of(List.of(1, 3, 5, 14, 22, 45),List.of(3, 5, 11, 16, 32, 38),List.of(7, 11, 16, 35, 36, 44)));
        rankMap = new EnumMap<>(Rank.class);
        RankResult result = new RankResult();

        result.addRankMapCount(winLotto,randomLottos,43);

        assertThat(result.getProfit(8000)).isEqualTo(62.5f);
    }
}