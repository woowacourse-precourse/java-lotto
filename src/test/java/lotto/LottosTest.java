package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void lottosInit() {
        lottos = new Lottos(3, Application.userIputStringToLotto("1,2,3,4,5,6"), 7);
    }

    @Test
    @DisplayName("발행된 로또들이 로또 중복 없는 1~45 사이의 6개의 숫자인지 테스트")
    public void createdLottosValidTest() {
        for(Lotto lotto : lottos.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(Lotto.isValidSize(numbers)).isTrue();
            assertThat(Lotto.isDuplicated(numbers)).isFalse();
            assertThat(Lotto.isNotValidRange(numbers)).isFalse();
        }
    }

    @Test
    @DisplayName("사용자 입력이 잘못된 형태일 때 예외 발생하는지 테스트")
    public void createdWinningLottoTest() {
        assertThatThrownBy(() -> Application.userIputStringToLotto("1, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(lottos.getBonusNum()).isEqualTo(7);
    }

}
