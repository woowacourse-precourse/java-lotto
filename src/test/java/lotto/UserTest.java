package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;

class UserTest {
    @DisplayName("사용자가 구매한 금액이 1000원 단위가 아닌 경우 에러 발생")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new User(4200))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("사용자가 구매한 로또 개수 테스트")
    @Test
    void getLottoRankingEnum(){
        User user = new User(4000);

        //1등 테스트
        assertThat(user.getUserLottos().size())
                .isEqualTo(4);
    }
}
