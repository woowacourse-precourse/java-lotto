package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 로또 번호 생성")
    @Test
    public void createLottoByRandomUniqueNumber() {
        assertThat(Lotto.createLottoNumbers()).isInstanceOf(Lotto.class);
    }

    @DisplayName("로또 번호에 주어진 번호가 있는지 확인한다.")
    @Test
    public void checkLottoHasTheNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int includedNumber = 5;
        int excludedNumber = 45;

        assertThat(lotto.contains(includedNumber)).isTrue();
        assertThat(lotto.contains(excludedNumber)).isFalse();
    }
}
