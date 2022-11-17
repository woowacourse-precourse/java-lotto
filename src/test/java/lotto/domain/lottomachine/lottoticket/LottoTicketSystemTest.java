package lotto.domain.lottomachine.lottoticket;

import lotto.domain.lottomachine.payment.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketSystemTest {
    private LottoTicketSystem lottoTicketSystem;

    @BeforeEach
    void setUp() {
        lottoTicketSystem = LottoTicketSystem.getInstance();
    }

    @DisplayName("issueLotto 메소드가 Lotto 객체를 반환하는지 확인")
    @Test
    void issueLotto_test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = lottoTicketSystem.getClass().getDeclaredMethod("issueLotto");
        method.setAccessible(true);

        Lotto lottoTicket = (Lotto) method.invoke(lottoTicketSystem);

        assertThat(lottoTicket).isInstanceOf(Lotto.class);
    }

    @DisplayName("issueLottoTickets 메소드에 금액을 입력하면 금액에 맞는 장수의 LottoTickets 객체를 반환하는지 확인")
    @ParameterizedTest(name = "{index} : {0}원 -> {1}장")
    @CsvSource({"15000, 15", "2000, 2", "6000, 6"})
    void issueLottoTickets_test(int amount, int numberOfTickets) {
        Payment money = Payment.from(amount);
        LottoTickets tickets = lottoTicketSystem.issueLottoTickets(money);

        assertThat(tickets.size()).isEqualTo(numberOfTickets);
    }

    @DisplayName("generateSixRandomNumbers 메소드가 여섯 개의 숫자를 담은 리스트를 반환하는지 확인")
    @Test
    void generateSixRandomNumbers_test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = lottoTicketSystem.getClass().getDeclaredMethod("generateSixRandomNumbers");
        method.setAccessible(true);

        List<?> numbers = (List<?>) method.invoke(lottoTicketSystem);

        assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("sortInAscendingOrder 메소드에 리스트를 입력하면 리스트가 정렬되는지 확인")
    @Test
    void sortInAscendingOrder_test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = lottoTicketSystem.getClass().getDeclaredMethod("sortInAscendingOrder", List.class);
        method.setAccessible(true);
        List<Integer> unsortedNumbers = new ArrayList<>(List.of(3, 4, 2, 1, 5));

        List<?> sortedNumbers = (List<?>) method.invoke(lottoTicketSystem, unsortedNumbers);

        assertThat(sortedNumbers).isSorted();
    }
}