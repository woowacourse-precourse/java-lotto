package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    @ParameterizedTest
    @ValueSource(strings = {"1100", "100", "3500", "12001", "50"})
    void validateInputMoney(String input) throws Exception {
        String data = input;
        LottoMachine lottoMachine = new LottoMachine();
        Method validateMoney = lottoMachine.getClass().getDeclaredMethod("validateMoney", String.class);
        validateMoney.setAccessible(true);

        Assertions.assertThatThrownBy(()->
                        validateMoney.invoke(lottoMachine,data)).getRootCause()
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLottoNumber() {
    }

    @Test
    void printLottos() {
    }

    @Test
    void getResult() {
    }

    @Test
    void calculateRevenue() {
    }

    @Test
    void printResult() {
    }
}