package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class UserTest {

    private final User user = new User();

    @Test
    public void 로또구매시_개수_오류여부(){
        assertThatThrownBy(() ->user.buyingLotto("234"))
                .isInstanceOf(IllegalArgumentException.class);
        assertEquals(14, user.buyingLotto("14000"));
    }
}