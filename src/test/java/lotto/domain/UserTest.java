package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class UserTest {
    @DisplayName("입력한 금액이 1000원 단위가 아닐 때 User 생성자 함수에서 에러 발생")
    @Test
    void createUserWithInvalidAmountOfMoney() {
        assertThatThrownBy(() -> new User(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위로")
                .hasMessageNotContaining("[ERROR]");
    }

    @DisplayName("buyLotteryTicket 이후 User의 money가 1000원 감소한다.")
    @Test
    void decreaseMoneyAfterPurchase() {
        User user = new User(2000);
        LotteryTicket lotteryTicket = new LotteryTicket(List.of(1, 2, 3, 4, 5, 6));

        List<LotteryTicket> lotteryTickets = new ArrayList<>();
        lotteryTickets.add(lotteryTicket);

        user.buyLotteryTicket(lotteryTicket);
        assertThat(user.getMoney()).isEqualTo(1000);
    }

    @DisplayName("buyLotteryTicket 이후 lotteryTickets 리스트에 lotteryTicket이 추가된다.")
    @Test
    void addLotteryTicketAfterPurchase() {
        User user = new User(2000);
        LotteryTicket lotteryTicket = new LotteryTicket(List.of(1, 2, 3, 4, 5, 6));

        List<LotteryTicket> lotteryTickets = new ArrayList<>();
        lotteryTickets.add(lotteryTicket);

        user.buyLotteryTicket(lotteryTicket);
        assertThat(user.getLotteryTickets()).isEqualTo(lotteryTickets);
    }
}
