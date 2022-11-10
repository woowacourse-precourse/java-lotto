package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class TicketMachineTest {

    TicketMachine ticketMachine = new TicketMachine();

    @ParameterizedTest
    @CsvSource({"1000,1", "2000,2", "3000,3", "15000,15"})
    @DisplayName("1000으로 나누어 떨어지는 가격을 입력하면 1000으로 나눈 몫을 반환한다")
    void getTicket(int payment, int expected) {

        assertThat(ticketMachine.getTicket(payment)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1500,2500,3500,47750})
    @DisplayName("1000으로 나누어 떨어지는 가격을 입력하면 1000으로 나눈 몫을 반환한다")
    void getTicket(int payment) {

        assertThatThrownBy(()-> ticketMachine.getTicket(payment))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 금액입니다. ");
    }
}