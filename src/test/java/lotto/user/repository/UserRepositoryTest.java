package lotto.user.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.lottery.repository.LottoRepository;
import lotto.user.domain.User;
import org.junit.jupiter.api.Test;

class UserRepositoryTest {
    @Test
    void user_lotto_create() {
        // when
        User user = new User(1);
        UserRepository.createUserLottos(user,8);
        System.out.println(user.getLottos());
    }
//    @Test
//    void study_list() {
//        User user = new User(1);
//        System.out.println(user.getLottos());
//        user.setLottos(LottoRepository.generateLotto());
//        user.getLottos();
//        List<Integer> LOTTO_NUMBER = List.of(1, 2, 3, 4, 5, 6);
//
//    }

}