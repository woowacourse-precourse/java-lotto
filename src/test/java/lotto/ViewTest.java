package lotto;

import lotto.domain.Lotto;
import lotto.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {

    View view;
    @BeforeEach
    void setUp() {
        view = new View();
    }

    @Test
    void printUserLottos() {
        List<Integer> lotto = List.of(1, 7, 4, 5, 8, 9);
        User user = new User();
        user.setMyLottoNumbers(List.of(new Lotto(lotto)));
        view.printUserLottos(user);
    }
}