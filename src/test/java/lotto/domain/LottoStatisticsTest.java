package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @DisplayName("복권 번호가 당첨 번호에 포함되는지 확인하는 테스트")
    @Test
    void countContainTest() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        int number = 6;
        List<Integer> winningSixNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        int winningBonusNumber = 7;
        List<Integer> count = new ArrayList<>(List.of(0,0));
        List<Integer> testCount = new ArrayList<>(List.of(1,0));
        assertThat(lottoStatistics.countContain(number,winningSixNumbers,winningBonusNumber,count)).isEqualTo(testCount);
    }

    @DisplayName("복권 번호가 보너스 번호에 포함되는지 확인하는 테스트")
    @Test
    void countBonusContainTest() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        int number = 7;
        List<Integer> winningSixNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        int winningBonusNumber = 7;
        List<Integer> count = new ArrayList<>(List.of(0,0));
        List<Integer> testCount = new ArrayList<>(List.of(0,1));
        assertThat(lottoStatistics.countContain(number,winningSixNumbers,winningBonusNumber,count)).isEqualTo(testCount);
    }

}