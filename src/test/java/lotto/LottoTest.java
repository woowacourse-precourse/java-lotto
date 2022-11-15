package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    LottoVandingMachine lottoVM = new LottoVandingMachine();
    LottoCalculator lottoCal = new LottoCalculator();
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매시 문자가 들어올 경우 예외가 발생한다.")
    @Test
    void createInputMoneyByString(){

        assertThatThrownBy(() -> {
            String input = "1000won";

            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            lottoVM.inputMoney();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매시 1000단위로 나누어 떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void createInputMoneyDiv1000(){

        assertThatThrownBy(() -> {
            String input = "15687";

            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            lottoVM.inputMoney();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 추첨시 반환 값이 7자리가 맞는지")
    @Test
    void createDrawLottoSize(){
        String lotto = "1,2,3,4,5,6" + "\n" + "7";
        InputStream in = new ByteArrayInputStream(lotto.getBytes());
        System.setIn(in);

        List<Integer> drawLottoery = lottoVM.drawLotto();
        assertThat(drawLottoery.size()).isEqualTo(7);
    }

    @DisplayName("로또 번호가 1~45사이의 숫자가 아닌 경우")
    @Test
    void createLottoNumFrom1To45(){

        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(45,46,47,48,49,50));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static final Lotto LOTTO_ANSWER = new Lotto(Arrays.asList(1,2,3,4,5,6,7), true);

    @DisplayName("로또 일치 테스트")
    @ParameterizedTest
    @CsvSource({"1,2,3,8,9,10,3", "1,2,3,4,9,10,4", "1,2,3,4,5,9,5", "1,2,3,4,5,7,7", "1,2,3,4,5,6,6"})
    void createCorrectLotto(int num1, int num2, int num3, int num4, int num5, int num6, int expected){
        int actual = lottoCal.compareLotto(Arrays.asList(num1, num2, num3, num4, num5, num6), LOTTO_ANSWER.getNumbers());
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("로또 일치가 3개일때, 그 개수가 2개인 경우 결과가 10000이 맞는지")
    @Test
    void createCorrect3Result10000()
    {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1,3,5,7,9,10)));
        lottoList.add(new Lotto(Arrays.asList(2,4,6,8,9,10)));

        int[] resultArr = new int[5];
        for(Lotto lotto : lottoList)
        {
            int matchCount = lottoCal.compareLotto(lotto.getNumbers(), LOTTO_ANSWER.getNumbers());
            resultArr = lottoCal.getResult(resultArr, matchCount);
        }

        int result = 0;
        for(int i = 0; i < resultArr.length; i++)
        {
            result += lottoCal.getOneYield(i, resultArr[i]);
        }

        assertThat(result).isEqualTo(10000);
    }

    @DisplayName("로또 발행 개수가 4개인 경우, 3개 일치 값이 2개일 때 수익률이 250이 맞는지")
    @Test
    void createCorrect4Result250()
    {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1,3,5,7,9,10)));
        lottoList.add(new Lotto(Arrays.asList(2,4,6,8,9,10)));
        lottoList.add(new Lotto(Arrays.asList(11,12,13,14,15,16)));
        lottoList.add(new Lotto(Arrays.asList(21,22,23,24,25,26)));

        int[] resultArr = new int[5];
        for(Lotto lotto : lottoList)
        {
            int matchCount = lottoCal.compareLotto(lotto.getNumbers(), LOTTO_ANSWER.getNumbers());
            resultArr = lottoCal.getResult(resultArr, matchCount);
        }

        String result = lottoCal.getYield(lottoList.size(), resultArr);

        assertThat(result).isEqualTo("250");
    }

}
