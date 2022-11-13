package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserMoneyTest {

    @Test
    void getLottoNumber() {
        UserMoney userMoney =new UserMoney("1000");
        assertThat(userMoney.getLottoNumber()).isEqualTo(1);
    }

    @Test
    void getUserInputMoney() {
        UserMoney userMoney=new UserMoney("10000");
        assertThat(userMoney.getUserInputMoney()).isEqualTo(10000);
    }
    @Test
    void testCheckError(){
        assertThatThrownBy(() -> new UserMoney("10000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}