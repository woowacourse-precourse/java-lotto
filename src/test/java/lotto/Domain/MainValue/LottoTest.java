package lotto.Domain.MainValue;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    SoftAssertions softAssertions = new SoftAssertions();
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6 ,7);
        assertThatThrownBy(() -> new Lotto(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> new Lotto(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 이외의 번호 입력시 예외가 발생한다")
    @Test
    void createLottoOutOfRange() {
        List<Integer> lottoMax = List.of(1, 2, 3, 4, 5, 56);
        List<Integer> lottoMin = List.of(1, 2, 3, 4, 5, 0);

        softAssertions
                .assertThatThrownBy(() -> new Lotto(lottoMax))
                .isInstanceOf(IllegalArgumentException.class);

        softAssertions
                .assertThatThrownBy(() -> new Lotto(lottoMin))
                .isInstanceOf(IllegalArgumentException.class);

        softAssertions.assertAll();
    }

}