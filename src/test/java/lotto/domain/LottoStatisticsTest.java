package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    LottoStatistics lottoStatistics;
    int number;
    List<Integer> winningSixNumbers;
    int winningBonusNumber;
    List<Integer> count;
    Map<LottoResult,Integer> lottoResultMap;

    @BeforeEach()
    void setLottoStatistics(){
        lottoStatistics = new LottoStatistics();
        winningSixNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        winningBonusNumber = 7;
        count = new ArrayList<>(List.of(0,0));
        lottoResultMap = new LinkedHashMap<>();
        lottoStatistics.initLottoResultMap();
    }

    @DisplayName("복권 번호가 당첨 번호에 포함되는지 확인하는 테스트")
    @Test
    void countContainTest() {
        number = 1;
        List<Integer> testCount = new ArrayList<>(List.of(1,0));
        assertThat(lottoStatistics.countContain(number,winningSixNumbers,winningBonusNumber,count)).isEqualTo(testCount);
    }

    @DisplayName("복권 번호가 보너스 번호에 포함되는지 확인하는 테스트")
    @Test
    void countBonusContainTest() {
        number = 7;
        List<Integer> testCount = new ArrayList<>(List.of(0, 1));
        assertThat(lottoStatistics.countContain(number, winningSixNumbers, winningBonusNumber, count)).isEqualTo(testCount);
    }

}