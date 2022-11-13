package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("복수의 로또의 당첨 개수를 확인한다.")
    @Test
    void LottoMatchList() {
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winLotto = new Lotto(winNumbers);
        winLotto.setBonusNumber(45);

        Lotto lotto1 = new Lotto(List.of(1, 7, 8, 9, 10, 11));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 14, 15, 16));
        List<Lotto> boughtLottos = List.of(lotto1, lotto2);

        assertThat(winLotto.matchWithList(boughtLottos, 1)).isEqualTo(1);
        assertThat(winLotto.matchWithList(boughtLottos, 3)).isEqualTo(1);
    }

    @DisplayName("보너스 번호 포함하는 복수의 로또 당첨 개수를 확인한다.")
    @Test
    void LottoMatchWihListIncludeBonus() {
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winLotto = new Lotto(winNumbers);
        winLotto.setBonusNumber(7);

        Lotto lotto1 = new Lotto(List.of(1, 7, 11, 10, 8, 9));
        Lotto lotto2 = new Lotto(List.of(1, 2, 8, 16, 15, 7));
        List<Lotto> boughtLottos = List.of(lotto1, lotto2);

        assertThat(winLotto.matchWihListIncludeBonus(boughtLottos, 1)).isEqualTo(1);
        assertThat(winLotto.matchWihListIncludeBonus(boughtLottos, 2)).isEqualTo(1);
    }
}
