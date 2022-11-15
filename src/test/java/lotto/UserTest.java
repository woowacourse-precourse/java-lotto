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

    @Test
    public void 로또_개수_확인(){
        user.generatingLotto(5);
        assertEquals(5, user.getBoughtLotto().size());
        assertEquals(6, user.getBoughtLotto().get(0).size());
        assertEquals(6, user.getBoughtLotto().get(1).size());
        assertEquals(6, user.getBoughtLotto().get(2).size());
        assertEquals(6, user.getBoughtLotto().get(3).size());
        assertEquals(6, user.getBoughtLotto().get(4).size());
    }
}