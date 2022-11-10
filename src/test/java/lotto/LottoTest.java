package lotto;

import lotto.model.Lotto;
import lotto.model.LottoNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static final LottoNumbersGenerator lottoNumbersGenerator = LottoNumbersGenerator.getInstance();

    private
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45 사이의 숫자가 아닌 다른 숫자가 들어가면 예외가 발생한다.")
    @Test
    void createLottoByNotInEffectiveRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 47)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 생성기가 올바른 번호를 생성한다.")
    @Test
    void createLottoWithLottoNumbersGenerator() {
        List<Integer> lottoNumbers = lottoNumbersGenerator.create();

        assertThatCode(() -> new Lotto(lottoNumbers))
                .doesNotThrowAnyException();
    }
}
