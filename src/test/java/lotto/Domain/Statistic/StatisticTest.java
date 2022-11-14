package lotto.Domain.Statistic;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StatisticTest {
    SoftAssertions softAssertions = new SoftAssertions();
    List<Integer> sixNum = List.of(1, 2, 3, 4, 5, 6);
    int bonus = 7;
    Set<Integer> winThree = new HashSet<>(List.of(1, 2, 3, 11, 12, 13));
    Set<Integer> winfour = new HashSet<>(List.of(1, 2, 3, 4, 12, 13));
    Set<Integer> winfive = new HashSet<>(List.of(1, 2, 3, 4, 5, 13));
    Set<Integer> winsix_NoBonus = new HashSet<>(List.of(1, 2, 3, 4, 5, 6));
    Set<Integer> winsix_YesBonus = new HashSet<>(List.of(1, 2, 3, 4, 5, 7));

    @DisplayName("1개만 당첨")
    @Test
    void winOneLotto() {
        List<Integer> answer = List.of(1,0,0,0,0);
        List<Set<Integer>> winOneLotto = List.of(winThree);
        softAssertions
                .assertThat(new Statistic(sixNum, bonus, winOneLotto).prizeRanks)
                .as("3개 하나 당첨")
                .isEqualTo(answer);

        answer = List.of(0,1,0,0,0);
        winOneLotto = List.of(winfour);
        softAssertions
                .assertThat(new Statistic(sixNum, bonus, winOneLotto).prizeRanks)
                .as("4개 하나 당첨")
                .isEqualTo(answer);

        answer = List.of(0,0,1,0,0);
        winOneLotto = List.of(winfive);
        softAssertions
                .assertThat(new Statistic(sixNum, bonus, winOneLotto).prizeRanks)
                .as("5개 하나 당첨")
                .isEqualTo(answer);

        answer = List.of(0,0,0,1,0);
        winOneLotto = List.of(winsix_YesBonus);
        softAssertions
                .assertThat(new Statistic(sixNum, bonus, winOneLotto).prizeRanks)
                .as("6개(보너스 포함) 하나 당첨")
                .isEqualTo(answer);

        answer = List.of(0,0,0,0,1);
        winOneLotto = List.of(winsix_NoBonus);
        softAssertions
                .assertThat(new Statistic(sixNum, bonus, winOneLotto).prizeRanks)
                .as("6개(보너스 불포함) 하나 당첨")
                .isEqualTo(answer);

        softAssertions.assertAll();
    }
@DisplayName("같은거 중복 당첨")
    @Test
    void winTwoLotto() {
        List<Integer> answer = List.of(2,0,0,0,0);
        List<Set<Integer>> winOneLotto = List.of(winThree,winThree);
        softAssertions
                .assertThat(new Statistic(sixNum, bonus, winOneLotto).prizeRanks)
                .as("3개 두개 당첨")
                .isEqualTo(answer);


        answer = List.of(0,0,2,0,0);
        winOneLotto = List.of(winfive, winfive);
        softAssertions
                .assertThat(new Statistic(sixNum, bonus, winOneLotto).prizeRanks)
                .as("5개 두개 당첨")
                .isEqualTo(answer);

        answer = List.of(0,0,0,2,0);
        winOneLotto = List.of(winsix_YesBonus, winsix_YesBonus);
        softAssertions
                .assertThat(new Statistic(sixNum, bonus, winOneLotto).prizeRanks)
                .as("6개(보너스 포함) 두개 당첨")
                .isEqualTo(answer);

        answer = List.of(0,0,0,0,2);
        winOneLotto = List.of(winsix_NoBonus, winsix_NoBonus);
        softAssertions
                .assertThat(new Statistic(sixNum, bonus, winOneLotto).prizeRanks)
                .as("6개(보너스 불포함) 두개 당첨")
                .isEqualTo(answer);

        softAssertions.assertAll();
    }
}
