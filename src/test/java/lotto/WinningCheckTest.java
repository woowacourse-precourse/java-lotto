package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningCheckTest {

    WinningCheck winningCheck;
    int bonusNumber = 7;
    List<Lotto> lottoList = new ArrayList<>();

    @BeforeEach
    void setup() {
        Arrays.stream(Rank.values())
                .forEach(rank -> rank.initCount());
        winningCheck = new WinningCheck(lottoList, Arrays.asList(1, 2, 3, 4, 5, 6), bonusNumber);
    }

    @Test
    void get_winningStatistics() {
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))); // 1등
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))); // 2등
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))); // 3등
        winningCheck.winningCheck();

        assertThat(Rank.FIRST.getCount()).isEqualTo(1);
        assertThat(Rank.SECOND.getCount()).isEqualTo(1);
        assertThat(Rank.THRID.getCount()).isEqualTo(1);
        assertThat(Rank.FOURTH.getCount()).isEqualTo(0);
        assertThat(Rank.FIFTH.getCount()).isEqualTo(0);
    }

    @Test
    void get_matchCount() {
        int matchNumber = winningCheck.getMacthCount(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(matchNumber).isEqualTo(6);
    }

    @Test
    void check_second_winning() {
        boolean rankSecond = winningCheck.isRankTwo(5, Arrays.asList(1, 2, 3, 4, 5, bonusNumber));
        assertThat(rankSecond).isEqualTo(true);
    }

}
