package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;


class LottoMachineTest {

    @DisplayName("구입금액을 잘못 입력하면 오류 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1100", "100", "3500", "12001", "50", "abcd", "12db", " ", "9999", "0"})
    void validateInputMoney(String input) throws Exception {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        LottoMachine lottoMachine = new LottoMachine();

        Assertions.assertThatThrownBy(()->
                        lottoMachine.getInputMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 따른 로또 생성 갯수")
    @ParameterizedTest
    @CsvSource({"1000,1", "2000,2", "3000,3", "5000,5"})
    void createLottoNumber(String input, int output) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        LottoMachine lottoMachine = new LottoMachine();

        lottoMachine.getInputMoney();
        int createdNum = lottoMachine.createLottoNumber().size();

        Assertions.assertThat(createdNum).isEqualTo(Integer.valueOf(output));
    }
    @DisplayName("당첨된 로또 순위 만큼 총 상금 계산")
    @ParameterizedTest
    @CsvSource({"1,1,1,1,2,2031560000","20,0,0,0,0,40000000000","0,0,1,0,3,1515000","0,0,5,0,0,7500000"})
    void calculateRevenue(int rank1, int rank2, int rank3, int rank4, int rank5 , long output) throws Exception{
        LottoMachine lottoMachine = new LottoMachine();
        Field countRanking = lottoMachine.getClass().getDeclaredField("countRanking");
        Field revenue = lottoMachine.getClass().getDeclaredField("revenue");
        countRanking.setAccessible(true);
        revenue.setAccessible(true);

        countRanking.set(lottoMachine,new int[]{0,rank1,rank2,rank3,rank4,rank5});
        lottoMachine.calculateRevenue();
        long allRevenue = (long) revenue.get(lottoMachine);

        Assertions.assertThat(allRevenue).isEqualTo(output);
    }
}