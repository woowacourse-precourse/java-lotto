package lotto.user.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import lotto.user.domain.User;
class UserRepositoryTest {

    User user = new User();

    @Test
    void check_user_purchase_amount_of_tickets(){
        int ticketsAmount = 7;
        UserRepository.setUserTicketsToLottery(user,ticketsAmount);

        assertThat(user.getLottos().size()).isEqualTo(ticketsAmount);
    }
}