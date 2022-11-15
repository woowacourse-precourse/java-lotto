package lotto.user.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import lotto.user.domain.User;
class UserRepositoryTest {

    User user = new User();
    @Test
    void check_user_buy_lotto_case() {

        User user = new User();

        UserRepository.buyLotteryTickets(user);

        int target = 36;
        assertThat(user.getTicketAmount()).isEqualTo(target);
        target = 36000;
        assertThat(user.getPurchaseAmount()).isEqualTo(target);
    }
    @Test
    void check_user_purchase_amount_of_tickets(){
        int ticketsAmount = 7;
        UserRepository.setUserTicketsToLottery(user,ticketsAmount);

        assertThat(user.getLottos().size()).isEqualTo(ticketsAmount);
    }
}