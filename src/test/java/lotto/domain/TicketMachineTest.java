package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class TicketMachineTest {

    TicketMachine ticketMachine = new TicketMachine();

    @ParameterizedTest
    @CsvSource({"1000,1", "2000,2", "3000,3", "15000,15"})
    @DisplayName("1000으로 나누어 떨어지는 가격을 입력하면 1000으로 나눈 몫을 반환한다")
    void 정상_반환_테스트(int payment, int expected) {

        assertThat(ticketMachine.getTicket(payment)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1500, 2500, 3500, 47750})
    @DisplayName("1000의 배수가 아닌 양의 정수로 입력하면 예외가 발생한다")
    void Ticket_가격의_배수가_아닐_경우_예외가_발생한다(int payment) {

        assertThatThrownBy(() -> ticketMachine.getTicket(payment))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 금액입니다. ");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, -2000, -3000, -47000})
    @DisplayName("음수를 입력하면 예외를 발생시킨다.")
    void 음수를_입력하면_예외가_발생한다(int payment) {

        assertThatThrownBy(() -> ticketMachine.getTicket(payment))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 금액입니다. ");
    }
}
