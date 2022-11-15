package lotto;

import lotto.domain.Lotto;
import lotto.domain.StartLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.buyLotto;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 랜덤 생성하는 기능 테스트.")
    @Test
    void buyLotto_테스트() {
        StartLotto.payment = 6000;
        StartLotto.lotto = new ArrayList<>();
        buyLotto();
        assertEquals(StartLotto.lotto.size(), 6);
    }

    @DisplayName("로또 번호를 반환하는 기능 테스트")
    @Test
    void getNums_테스트() {
        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(testLotto.getNums().toString(), "[1, 2, 3, 4, 5, 6]");
    }
}
