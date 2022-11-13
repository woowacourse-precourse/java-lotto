package lotto.model;

import lotto.model.converter.Converter;
import lotto.model.converter.ConverterImpl;
import lotto.view.input.Input;
import lotto.view.input.InputImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

    @Test
    @DisplayName("투입금액 문자열을 BigDecimal타입으로 변환")
    void case1(){

        //given
        Converter converter = new ConverterImpl();
        Input input = new InputImpl();

        //when
        String userInput = "10000";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        String stringMoney = input.moneyInput();
        BigDecimal result = converter.convertStringToMoney(stringMoney);

        //then
        assertThat(result).isEqualTo(new BigDecimal(10000));
    }

    @Test
    @DisplayName("투입 금액을 로또 발행 권수로 변환")
    void case2(){
        //given
        Converter converter = new ConverterImpl();
        Input input = new InputImpl();

        //when
        String userInput = "10000";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        String stringMoney = input.moneyInput();
        BigDecimal money = converter.convertStringToMoney(stringMoney);
        BigDecimal result = converter.convertMoneyToCount(money);

        //then
        assertThat(result).isEqualTo(new BigDecimal(10));
    }

    @Test
    @DisplayName("당첨번호 문자열을 당첨번호 리스트로 변환")
    void case3(){
        //given
        Converter converter = new ConverterImpl();
        Input input = new InputImpl();

        //when
        String systemInput = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(systemInput.getBytes());
        System.setIn(in);
        String stringWinningNumbers = input.winningNumbersInput();
        List<Integer> result = converter.convertStringToNumbers(stringWinningNumbers);
        //then
        for (Integer number : result) {
            assertThat(List.of(1,2,3,4,5,6)).contains(number);
        }
    }
}
