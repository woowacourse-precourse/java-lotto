package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class UserTest {
    @ParameterizedTest
    @CsvSource({"abc", "1000a", "2b000", "c3000", "1000O"})
    void validate_notNum(String wrongInput) {
        User user = new User();
        assertThatThrownBy(() -> user.validateAmount(wrongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력하세요");
    }

    @ParameterizedTest
    @CsvSource({"999", "1234", "7750", "10500", "100001"})
    void validate_notThousand(String wrongInput) {
        User user = new User();
        assertThatThrownBy(() -> user.validateAmount(wrongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 금액이 1000으로 나누어 떨어지지 않습니다");
    }

    @ParameterizedTest
    @CsvSource({"5000,5", "12000,12", "1000,1", "30000,30", "100000,100"})
    void countTickets(int inputAmount, int ticketCount) {
        User user = new User(inputAmount);
        user.countTickets();
        assertThat(user.lottoTicketCount).isEqualTo(ticketCount);
    }

    @ParameterizedTest
    @CsvSource({"5000", "12000", "1000", "30000", "100000"})
    void buyTickets(int inputAmount) {
        User user = new User(inputAmount);
        user.countTickets();
        user.buyTickets();
        assertThat(user.lottoTickets.size()).isEqualTo(user.lottoTicketCount);
    }
}