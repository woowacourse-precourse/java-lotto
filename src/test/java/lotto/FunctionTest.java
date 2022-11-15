package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FunctionTest {

    @DisplayName("몇개의 로또를 구입할 수 있는지 계산하는 메소드 테스트")
    @Test
    void testGetNumberOfTimes() {
        //given
        Function function = new Function();
        int amount = 8000;
        //when
        int result = function.getNumberOfTimes(amount);
        //then
        int expected = 8;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @DisplayName("로또 번호 자동생성 메소드 테스트")
    @Test
    void testMakeLottoNumber() {
        //given
        Function function = new Function();
        List<Integer> lottoNumbersTemp = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        //when
        List<Integer> result = function.makeLottoNumber();
        //then
        int expected = 6;
        Assertions.assertThat(result.size()).isEqualTo(expected);
    }

    @DisplayName("당첨번호를 list<Integer>로 바꾸는 메소드")
    @Test
    void testStringToIntegerList() {
        //given
        Function function = new Function();
        String InputLottoNumber = "1,2,3,4,5,6";
        //when
        List<Integer> result = function.stringToIntegerList(InputLottoNumber);
        //then
        List<Integer> expected = Arrays.asList(1,2,3,4,5,6);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @DisplayName("당첨 번호로 분리된 Map을 반환하는 메소드")
    @Test
    void testAnalyzeLotto(){
        //given
        Function function = new Function();
        List<ArrayList<Integer>> lottos = List.of(new ArrayList<Integer>(List.of(1,2,3,4,5,6)),
                new ArrayList<Integer>(List.of(11,12,13,14,15,16)));
        List<Integer> winningNumbers = List.of(1,2,3,11,12,13);
        int bonusNum = 4;
        //when
        Map<Integer,Integer> result = function.analyzeLotto(lottos,winningNumbers,bonusNum);
        //then
        Map<Integer,Integer> expected = Map.of(3,2);
        Assertions.assertThat(result).isEqualTo(expected);
    }



    @DisplayName("수익률 계산 메소드")
    @Test
    void testCalculateProfitRate() {
        //given
        Function function = new Function();
        Map<Integer, Integer> separatedByRanking = Map.of(
                3,1,
                4,0,
                5,0,
                6,0,
                7,0);
        int initialAmount = 8000;
        //when
        double result = function.calculateProfitRate(separatedByRanking,initialAmount);
        //then
        List<Integer> expected = Arrays.asList(1,2,3,4,5,6);
        Assertions.assertThat(result).isEqualTo(62.5);
    }

}
