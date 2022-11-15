package lotto.domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 로또_번호_문자열로_입력() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        assertThat(lotto.getNumbers()).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 로또_번호에_문자_존재() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_중복_문자열로_입력() {
        Lotto lotto = new Lotto("1,2,3,4,5,6,6");
        assertThat(lotto.getNumbers()).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    @Disabled
    void list_of_정렬하기() {
        SortedSet<Integer> treeSet = new TreeSet<>(List.of(3, 2, 1, 5, 4, 5, 5));
        assertThat(treeSet).isEqualTo(List.of(1, 2, 3, 4, 5));

    }
}
