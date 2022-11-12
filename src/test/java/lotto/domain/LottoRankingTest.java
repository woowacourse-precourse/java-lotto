package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoResult.*;
import static lotto.domain.LottoResult.LOSING;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankingTest {

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

    @DisplayName("순위를 알맞게 return 하는지 테스트(THREE)")
    @Test
    void findRanking5Test() {
        LottoResult answer = THREE;
        List<Integer> testCount = new ArrayList<>(List.of(3,0));
        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        testLotto.setLottoResult(LOSING);
        lottoStatistics.findRanking(testCount,testLotto);
        assertThat(lottoStatistics.findRanking(testCount,testLotto)).isEqualTo(answer);
    }

    @DisplayName("순위를 알맞게 return 하는지 테스트(FOUR)")
    @Test
    void findRanking4Test() {
        LottoResult answer = FOUR;
        List<Integer> testCount = new ArrayList<>(List.of(3,1));
        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        testLotto.setLottoResult(LOSING);
        lottoStatistics.findRanking(testCount,testLotto);
        assertThat(lottoStatistics.findRanking(testCount,testLotto)).isEqualTo(answer);
    }

    @DisplayName("순위를 알맞게 return 하는지 테스트(FIVE)")
    @Test
    void findRanking3Test() {
        LottoResult answer = FIVE;
        List<Integer> testCount = new ArrayList<>(List.of(5,0));
        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        testLotto.setLottoResult(LOSING);
        lottoStatistics.findRanking(testCount,testLotto);
        assertThat(lottoStatistics.findRanking(testCount,testLotto)).isEqualTo(answer);
    }

    @DisplayName("순위를 알맞게 return 하는지 테스트(FIVE_BONUS)")
    @Test
    void findRanking2Test() {
        LottoResult answer = FIVE_BONUS;
        List<Integer> testCount = new ArrayList<>(List.of(5,1));
        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        testLotto.setLottoResult(LOSING);
        lottoStatistics.findRanking(testCount,testLotto);
        assertThat(lottoStatistics.findRanking(testCount,testLotto)).isEqualTo(answer);
    }

    @DisplayName("순위를 알맞게 return 하는지 테스트(SIX)")
    @Test
    void findRanking1Test() {
        LottoResult answer = SIX;
        List<Integer> testCount = new ArrayList<>(List.of(6,0));
        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        testLotto.setLottoResult(LOSING);
        lottoStatistics.findRanking(testCount,testLotto);
        assertThat(lottoStatistics.findRanking(testCount,testLotto)).isEqualTo(answer);
    }
}
