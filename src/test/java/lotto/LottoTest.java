package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 범위(1~45)가 맞지 않으면 예외가 발생한다.")
    @Test
    void createLottoByRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 61)))
            .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 카피 기능이 잘 동작 하는지 확인한다.")
    @Test
    public void checkLottoCopied() {
        List<Integer> expectedLotto = List.of(5, 2, 6, 4, 1, 3);
        Lotto lotto  = new Lotto(List.of(5, 2, 6, 4, 1, 3));
        assertThat(lotto.copyLotto()).containsExactlyElementsOf(expectedLotto);
    }

    @DisplayName("로또가 오름차순으로 정렬되는지 확인한다.")
    @Test
    public void checkLottoSorted() {
        List<Integer> expectedLotto = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto  = new Lotto(List.of(5, 2, 6, 4, 1, 3));
        assertThat(lotto.sortLotto()).containsExactlyElementsOf(expectedLotto);
    }

    @Test
    @DisplayName("로또가 문자열로 올바르게 출력되는지 확인한다.")
    public void checkSortedLottoResult() {
        String expectedLotto = "[1, 2, 3, 4, 5, 6]";
        Lotto lotto  = new Lotto(List.of(5, 2, 6, 4, 1, 3));
        assertThat(lotto.toString()).isEqualTo(expectedLotto);
    }
}
