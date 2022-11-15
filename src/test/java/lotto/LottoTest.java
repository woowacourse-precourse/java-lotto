package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private final List<Integer> dummyLotto = new ArrayList<>(List.of(1, 3, 4, 6, 12, 15));
    final List<List<Integer>> bouguhtLotto = new ArrayList<>();
    final List<Integer> dummyLotto1 = new ArrayList<>(List.of(3, 4, 6, 12, 15, 34));
    final List<Integer> dummyLotto2 = new ArrayList<>(List.of(1, 6, 15, 24, 45));
    final List<Integer> dummyLotto3 = new ArrayList<>(List.of(15, 22, 26, 33, 37, 42));


    private final Lotto lotto = new Lotto(dummyLotto);


    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    public void 보너스숫자_선택한로또_중복여부() {
        assertThatThrownBy(() -> lotto.addBonus(4))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lotto.addBonus(3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lotto.addBonus(15))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
