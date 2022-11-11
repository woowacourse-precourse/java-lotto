package lotto.domain;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    @DisplayName("1,000원 단위의 구입 금액이 주어졌을 경우 로또의 개수를 구한다.")
    void getLottoCount(){
        User user = new User(10000);
        assertThat(user.getLottoCount()).isEqualTo(10);
    }
}