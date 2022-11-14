package lotto;

import lotto.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @DisplayName("사용자가 입력한 돈만큼 로또 생성 기능 테스트")
    @Test
    void userLottoNumbers(){
        User user = new User(5000);

        int size = user.getMyLottoNumbers().size();

        assertThat(size).isEqualTo(5);
    }
}