package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private static final List<Integer> FIVE_NUMBER_LOTTO = List.of(2, 3, 4, 5, 6);
    private static final List<Integer> SEVEN_NUMBER_LOTTO = List.of(1, 2, 3, 4, 5, 6, 7);
    private static final List<Integer> WRONG_NUMBER_LOTTO = List.of(3, 4, 5, 6, 7, 46);
    private static final List<Integer> DUPLICATED_NUMBER_LOTTO = List.of(3, 4, 3, 6, 7, 9);

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(FIVE_NUMBER_LOTTO))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(SEVEN_NUMBER_LOTTO))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(DUPLICATED_NUMBER_LOTTO))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 ~ 45 외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(WRONG_NUMBER_LOTTO))
                .isInstanceOf(IllegalArgumentException.class);
    }


    // 아래에 추가 테스트 작성 가능
}
