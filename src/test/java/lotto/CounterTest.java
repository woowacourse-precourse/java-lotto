package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CounterTest {
    Counter counter = new Counter();

    @DisplayName("입력 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {

        assertThatThrownBy(() -> counter.numberCheck("800T"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> counter.unitCheck(8500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액 1000원당 1개의 복권 갯수를 센다.")
    @Test
    void countNumberOfLotto() {
        String input = "18000";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        counter.putMoney();
        assertThat(counter.getNumberOfLotto()).isEqualTo(18);
    }
}
