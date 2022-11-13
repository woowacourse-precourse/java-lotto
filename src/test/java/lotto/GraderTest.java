package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GraderTest {
    Grader grader;
    int bonusNumber = 7;
    List<Lotto> lottoList = new ArrayList<>();

    @BeforeEach
    void setup() {
        Arrays.stream(Rank.values())
                .forEach(rank -> rank.initCount());
        grader = new Grader(lottoList, Arrays.asList(1, 2, 3, 4, 5, 6), bonusNumber);
    }

    @Test
    void 당첨_통계_구하기() {
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))); // 1등
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))); // 2등
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))); // 3등
        grader.grade();

        assertThat(Rank.ONE.getCount()).isEqualTo(1);
        assertThat(Rank.TWO.getCount()).isEqualTo(1);
        assertThat(Rank.THREE.getCount()).isEqualTo(1);
        assertThat(Rank.FOUR.getCount()).isEqualTo(0);
        assertThat(Rank.FIVE.getCount()).isEqualTo(0);
    }

    @Test
    void 일치하는_번호_개수_구하기() {
        int matchNumber = grader.getMatchNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(matchNumber).isEqualTo(6);
    }

    @Test
    void 이등_당첨_확인() {
        boolean rankTwo = grader.isRankTwo(5, Arrays.asList(1, 2, 3, 4, 5, bonusNumber));
        assertThat(rankTwo).isEqualTo(true);
    }
}