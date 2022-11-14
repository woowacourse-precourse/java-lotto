package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void 로또_번호의_개수가_6개_아니라면_예외_발생() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 로또_번호에_중복이_있다면_예외_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_1부터_45_사이가_아니라면_에외_발생() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 5)))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
