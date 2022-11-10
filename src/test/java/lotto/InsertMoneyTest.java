package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InsertMoneyTest {

    @ParameterizedTest
    @CsvSource({"1000,true", "12000,true", "100,false", "12001,false"})
    void 입력_금액_예외_테스트(int money, boolean expectedException) {
        if (expectedException) {
            InsertMoney insertMoney = new InsertMoney(money);
            assertThat(insertMoney).isInstanceOf(InsertMoney.class);
        }
        if (!expectedException) {
            assertThatThrownBy(() -> new InsertMoney(money))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}