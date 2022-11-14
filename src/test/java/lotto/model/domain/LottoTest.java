package lotto.model.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("정상적인 로또 번호를 생성하는 경우")
    @Test
    void Lotto() {
        List<Integer> validLottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        Assertions.assertThatCode(() -> new Lotto(validLottoNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("비정상적인 로또 번호를 생성하는 경우 예외처리")
    @Test
    void LottoException() {
        List<Integer> invalidSizeLottoNumbers = List.of(1, 2, 3, 4, 5);
        List<Integer> invalidSizeLottoNumbers2 = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> duplicatedLottoNumbers = List.of(1, 2, 3, 4, 5, 5);
        List<Integer> invalidRangeLottoNumbers = List.of(1, 2, 3, 4, 5, 0);
        List<Integer> invalidRangeLottoNumbers2 = List.of(1, 2, 3, 4, 5, 46);

        Assertions.assertThatThrownBy(() -> new Lotto(invalidSizeLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new Lotto(invalidSizeLottoNumbers2))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new Lotto(duplicatedLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new Lotto(invalidRangeLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new Lotto(invalidRangeLottoNumbers2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}