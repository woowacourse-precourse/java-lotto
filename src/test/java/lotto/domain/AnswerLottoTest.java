package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class AnswerLottoTest {

    @Test
    void 로또_개수가_6개가_아닌경우_예외발생() throws Exception {
        assertThatThrownBy(() -> {
            new AnswerLotto(List.of(1, 2, 3, 4, 5, 6, 7), 8);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 결과_로또_번호가_1과45사이가_아닌경우_예외발생() throws Exception {
        assertThatThrownBy(() -> {
            new AnswerLotto(List.of(0, 1, 2, 3, 4, 46), 7);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 결과_로또의_보너스번호가_로또번호와_중첩될경우_예외발생() throws Exception {
        assertThatThrownBy(() -> {
            new AnswerLotto(List.of(1, 2, 3, 4, 5, 45), 45);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 결과_로또의_보너스번호가_null인경우_예외발생() throws Exception {
        assertThatThrownBy(() -> {
            new AnswerLotto(List.of(1, 2, 3, 4, 5, 45), null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 결과_로또의_보너스번호가_1과45사이가_아닌경우_예외발생() throws Exception {
        assertThatThrownBy(() -> {
            new AnswerLotto(List.of(1, 2, 3, 4, 5, 45), 46);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}