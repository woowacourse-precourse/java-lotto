package lotto.user.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.lottery.repository.LottoRepository;
import lotto.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserRepositoryTest {

    User user = new User(1);
    @Test
    void user_lotto_create() {
        // when
        UserRepository.createUserLottos(user,8);
        System.out.println(user.getLottos());
    }
    @Test
    void study_list() {
        System.out.println(user.getLottos());
        user.setLottos(LottoRepository.generateLotto());
        user.getLottos();
        List<Integer> LOTTO_NUMBER = List.of(1, 2, 3, 4, 5, 6);

    }

    @Test
    void check_divide_for_drop_under_point() {
        int UNIT = 100 ;
        int target = 36;

        int result = 3601/UNIT;
        assertThat(target).isEqualTo(result);
    }
    @Test
    void check_user_buy_lotto_case() {

        User user = new User(36127);

        UserRepository.buylottos(user);

        int target = 36;
        assertThat(user.getTicketAmount()).isEqualTo(target);
        target = 36000;
        assertThat(user.getPurchaseAmount()).isEqualTo(target);
    }

}