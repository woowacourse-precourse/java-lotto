package lotto.domain;

import lotto.Lotto;
import lotto.utils.Validate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    @ParameterizedTest
    @ValueSource(strings = {"1100", "100", "3500", "12001", "50", "abcd", "12cd", " ", "9900", "0"})
    @DisplayName("구입 금액을 잘못 입력하면 오류 발생")
    void validateInputMoney(String input) throws Exception {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        LottoMachine lottoMachine = new LottoMachine();

        Assertions.assertThatThrownBy(() ->
                lottoMachine.getInputMoney())
                        .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @CsvSource({"1000,1", "2000,2", "3000,3", "5000,5"})
    void createLottoNumber(String input, String size) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        LottoMachine lottoMachine = new LottoMachine();

        lottoMachine.getInputMoney();
        Assertions.assertThat(lottoMachine.createLottoNumber().size()).isEqualTo(Integer.valueOf(size));


    }

    @Test
    void getResult() {
    }

    @Test
    void calculateRevenue() {
    }

}