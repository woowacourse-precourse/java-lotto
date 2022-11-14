package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    UserService userService;

    @Test
    void 로또_구입_금액_입력() {
        assertThat(userService.buyLotto("10000") ).isEqualTo(10);
    }

    @Test
    void 로또_구입_금액_예외() {
        assertThatThrownBy(() -> userService.buyLotto("8700"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 쉼표로_구분하여_입력받는_로또_번호_6개와_보너스_번호_1개_검증() {
        userService.createPlayerNumbers("1,2,3,4,5,6", 7);
        userService.createPlayerNumbers("1,2,3,4,5,6,7", 7);
        userService.createPlayerNumbers("1,2,3,4,5,가", 7);
        userService.createPlayerNumbers("1,2,3,456", 7);
    }

}