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

    @DisplayName("두 로또의 일치하는 숫자를 반환한다.")
    @Test
    void LottoMatch() {
        Lotto lotto1 = new Lotto(List.of(1, 7, 11, 10, 8, 9));
        Lotto lotto2 = new Lotto(List.of(1, 2, 8, 9, 15, 7));
        List<Lotto> boughtLottos = List.of(lotto1, lotto2);

        assertThat(lotto1.match(lotto2)).isEqualTo(4);
    }

    @DisplayName("보너스 번호가 맞았는지 확인한다.")
    @Test
    void LottoBonusMatch() {
        Lotto lotto1 = new Lotto(List.of(1, 7, 11, 10, 8, 9));
        lotto1.setBonusNumber(15);
        Lotto lotto2 = new Lotto(List.of(1, 2, 8, 9, 15, 7));

        assertThat(lotto1.bonusMatch(lotto2)).isTrue();
    }

    @DisplayName("보너스 번호가 기존의 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void ValidateLottoSize() {
        Lotto lotto = new Lotto(List.of(1, 7, 11, 10, 8, 9));

        assertThatThrownBy(() -> lotto.setBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 세팅되어 있지 않은 상태로 bonusMatch를 확인하면 예외가 발생한다.")
    @Test
    void ValidateLottoBonusExist() {
        Lotto lotto1 = new Lotto(List.of(1, 7, 11, 10, 8, 2));
        Lotto lotto2 = new Lotto(List.of(1, 2, 8, 9, 15, 7));

        assertThatThrownBy(() -> lotto1.bonusMatch(lotto2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
