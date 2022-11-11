package lotto.domain.lottomachine.lottoticket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketMachineTest {
    private LottoTicketMachine lottoTicketMachine;

    @BeforeEach
    void setUp() {
        lottoTicketMachine = new LottoTicketMachine();
    }

    @DisplayName("convertMoneyIntoTickets 메소드에 금액을 입력하였을 때 티켓 장수를 반환하는지 확인")
    @ParameterizedTest(name = "{index} : {0}원 -> {1}장")
    @CsvSource({"15000, 15", "1000, 1","5000, 5"})
    void convertMoneyIntoTickets_test(int money, int numberOfTickets) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = lottoTicketMachine.getClass().getDeclaredMethod("convertMoneyIntoTickets", int.class);
        method.setAccessible(true);

        int tickets = (int) method.invoke(lottoTicketMachine, money);

        assertThat(tickets).isEqualTo(numberOfTickets);
    }
}