package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 아니면 에러를 발생한다.")
    @Test
    void LottoIsOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void LottoIsLessSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 에러를 발생한다")
    @Test
    void LottoHasDuplicateNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 오름차순으로 정렬된다.")
    @Test
    void createLottoBySort() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        assertEquals(lotto.getLottoNumbers(), List.of(1, 2, 3, 4, 5, 6));
    }
}
