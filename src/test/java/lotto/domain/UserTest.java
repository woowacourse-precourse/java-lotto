package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.domain.User.GAMEOVER;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UserTest {

    @Test
    void 금액값이숫자가_아닐때_테스트() {
        User user = new User();
        String money = "천원";

        assertEquals(user.validate(money), GAMEOVER);
    }


}