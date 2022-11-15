package lotto;

import lotto.domain.User;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserNumberInputTest {

    @DisplayName("사용자가 1000원 단위로 로또 구입 금액을 입력하지 않으면 오류가 발생한다")
    @Test
    void userInputTest() {
       User user = new User();
       String input = "1500";

       InputStream in = new ByteArrayInputStream(input.getBytes());
       System.setIn(in);

       assertThatThrownBy(() -> user.pickLottoNumbers())
               .isInstanceOf(IllegalArgumentException.class)
               .hasMessageContaining("1000원 단위로 입력하셔야 합니다.");
    }
}
