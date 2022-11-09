package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void userLottoNumbers(){
        User user = new User(5000);
        assertThat(user.getMyLottoNumbers().size()).isEqualTo(5);
    }
    @Test
    void userMoney(){
        User user = new User(1000);
        assertThat(user.getMoney()).isEqualTo(1000);
    }
}