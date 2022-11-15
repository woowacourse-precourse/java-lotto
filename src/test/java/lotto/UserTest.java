package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.UI;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


class UserTest {
    Application app = new Application();
    Buyer user = new Buyer();
    Lotto lotto = new Lotto(user.getLottoNumbers());

    @DisplayName("유저가 발행한 로또가 중복되지 않는지 확인")
    @Test
    void userLotto() {
        List<Buyer> userLotto = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            userLotto.add(i, new Buyer());
        }

        for (Buyer u : userLotto) {
            System.out.println(u.userNumber.size());
            System.out.println(u.userNumber);
            assertEquals(6, u.userNumber.size());
            assertThatCode(() -> lotto.validateOverlap(u.userNumber))
                    .doesNotThrowAnyException();
        }
    }

    @DisplayName("금액이 1,000원 단위로 떨어지지 않을 때 예외 확인")
    @Test
    void moneyException() {
        UI ui = new UI();

        assertThatCode(() -> ui.lottoCount(13000))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> ui.lottoCount(13200))
                .isInstanceOf(IllegalArgumentException.class);
    }
}