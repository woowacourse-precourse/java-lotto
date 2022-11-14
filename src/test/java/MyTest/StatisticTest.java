package MyTest;

import lotto.domain.Lotto;
import lotto.domain.Purchase;
import lotto.domain.Statistic;
import lotto.domain.Winning;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StatisticTest {

    @DisplayName("등수 검사 테스트")
    @Test
    void statisticalTest() {
        //given
        String purchaseAmount = "8000";
        String winningNumber = "1,2,3,4,5,6";
        String bonusNumber = "13";
        Purchase purchase = new Purchase(purchaseAmount);
        Winning winning = new Winning(winningNumber, bonusNumber);
        Statistic statistic = new Statistic(purchase, winning);

        //Test 1 : 1등(6개 번호 맞춤)
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int winningGrade = statistic.winningGrade(lotto1);
        int winningCounts = statistic.calculateCorrespondNumberCount(lotto1);
        long winningReward = statistic.mapperOfGradeToReward(winningGrade);

        Assertions.assertThat(1).isEqualTo(winningGrade);
        Assertions.assertThat(6).isEqualTo(winningCounts);
        Assertions.assertThat(2_000_000_000).isEqualTo(winningReward);


        //Test 2 : 2등(5개 번호 맞춤 + 보너스 번호 맞춤)
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 13));
        winningGrade = statistic.winningGrade(lotto2);
        winningCounts = statistic.calculateCorrespondNumberCount(lotto2);
        winningReward = statistic.mapperOfGradeToReward(winningGrade);

        Assertions.assertThat(2).isEqualTo(winningGrade);
        Assertions.assertThat(5).isEqualTo(winningCounts);
        Assertions.assertThat(30_000_000).isEqualTo(winningReward);


        //Test 3 : 3등(5개 번호 맞춤 + 보너스 번호 못 맞춤)
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 15));
        winningGrade = statistic.winningGrade(lotto3);
        winningCounts = statistic.calculateCorrespondNumberCount(lotto3);
        winningReward = statistic.mapperOfGradeToReward(winningGrade);

        Assertions.assertThat(3).isEqualTo(winningGrade);
        Assertions.assertThat(5).isEqualTo(winningCounts);
        Assertions.assertThat(1_500_000).isEqualTo(winningReward);


        //Test 4 : 4등(4개 번호 맞춤)
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 12, 15));
        winningGrade = statistic.winningGrade(lotto4);
        winningCounts = statistic.calculateCorrespondNumberCount(lotto4);
        winningReward = statistic.mapperOfGradeToReward(winningGrade);

        Assertions.assertThat(4).isEqualTo(winningGrade);
        Assertions.assertThat(4).isEqualTo(winningCounts);
        Assertions.assertThat(50_000).isEqualTo(winningReward);


        //Test 5 : 5등(3개 번호 맞춤)
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 7, 12, 15));
        winningGrade = statistic.winningGrade(lotto5);
        winningCounts = statistic.calculateCorrespondNumberCount(lotto5);
        winningReward = statistic.mapperOfGradeToReward(winningGrade);

        Assertions.assertThat(5).isEqualTo(winningGrade);
        Assertions.assertThat(3).isEqualTo(winningCounts);
        Assertions.assertThat(5_000).isEqualTo(winningReward);


        //Test 6 : 0등(3개 미만 번호 맞춤)
        Lotto lotto6 = new Lotto(List.of(1, 3, 7, 8, 12, 15));
        winningGrade = statistic.winningGrade(lotto6);
        winningCounts = statistic.calculateCorrespondNumberCount(lotto6);
        winningReward = statistic.mapperOfGradeToReward(winningGrade);

        Assertions.assertThat(0).isEqualTo(winningGrade);
        Assertions.assertThat(2).isEqualTo(winningCounts);
        Assertions.assertThat(0).isEqualTo(winningReward);

    }
}
