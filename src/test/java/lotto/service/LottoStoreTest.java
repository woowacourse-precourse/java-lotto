package lotto.service;

import lotto.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoStoreTest {

    private LottoStore lottoStore;

    @BeforeEach
    void setUp() {
        lottoStore = new LottoStore();
    }

    @Test
    @DisplayName("8000원을 입력하면 8개의 리스트가 나와야 한다.")
    void createLottos() {
        assertThat(lottoStore.buyLottos(new Money("8000")).size()).isEqualTo(8);
    }

    @Test
    @DisplayName("8080원을 입력하면 예외처리 되어야 한다.")
    void createLottosNotDivide() {
        assertThatThrownBy(() -> lottoStore.buyLottos(new Money("8080")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("올바른 당첨 번호를 입력하면 리스트와 일치해야 한다.")
    void inputWinningNumberSuccess() {
        assertThat(lottoStore.confirmWinningNumbers("1,2,3,4,5,6").toString()).isEqualTo(Arrays.asList(1,2,3,4,5,6).toString());
    }

    @Test
    @DisplayName("정수가 아니거나 1~45의 범위에 없으면 예외처리 해야한다.")
    void inputWinningNumberNotInRange() {
        assertThatThrownBy(() -> lottoStore.confirmWinningNumbers("a,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6개가 아니면 예외처리 해야한다.")
    void inputWinningNumberCountNotSix() {
        assertThatThrownBy(() -> lottoStore.confirmWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
