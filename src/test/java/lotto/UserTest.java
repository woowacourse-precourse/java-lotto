package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class UserTest {

    private final User user = new User();
    private final String wrongLottoInput = "12.4.2.16.32.6";
    private final String wrongLottoInput2 = "124216326";
    private final String wrongLottoInput3 = "124,2,16,32,6,16";
    private final String wrongLottoInput4 = "사십사,이십이,이,12";
    private final String wrongLottoInput5 = "1, 13, 14, 23, 16, 35";

    @Test
    public void 로또구매시_개수_오류여부(){
        assertThatThrownBy(() ->user.buyingLotto("234"))
                .isInstanceOf(IllegalArgumentException.class);
        assertEquals(14, user.buyingLotto("14000"));
    }

    @Test
    public void 유저_로또번호_선택(){
        assertThatThrownBy(() -> user.choosingLottoNumber(wrongLottoInput))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.choosingLottoNumber(wrongLottoInput2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.choosingLottoNumber(wrongLottoInput3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.choosingLottoNumber(wrongLottoInput4))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.choosingLottoNumber(wrongLottoInput5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}