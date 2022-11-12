package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.game.Lotto;
import lotto.game.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("로또 번호가 당첨 번호와 6개가 일치하면 1등이다.")
    @Test
    void FirstIfMatchesSixLottoNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoResult lottoResult = lotto.getLottoResult(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(lottoResult).isEqualTo(LottoResult.FIRST);
    }

    @DisplayName("로또 번호가 당첨 번호 5개와 보너스 번호가 일치하면 2등이다.")
    @Test
    void SecondIfMatchesFiveLottoNumbersAndBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoResult lottoResult = lotto.getLottoResult(List.of(1, 2, 3, 4, 5, 7), 6);

        assertThat(lottoResult).isEqualTo(LottoResult.SECOND);
    }

    @DisplayName("로또 번호가 당첨 번호와 5개가 일치하면 3등이다.")
    @Test
    void ThirdIfMatchesFiveLottoNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoResult lottoResult = lotto.getLottoResult(List.of(1, 2, 3, 4, 5, 7), 8);

        assertThat(lottoResult).isEqualTo(LottoResult.THIRD);
    }

    @DisplayName("로또 번호가 당첨 번호와 4개가 일치하면 4등이다.")
    @Test
    void FourthIfMatchesFourLottoNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoResult lottoResult = lotto.getLottoResult(List.of(1, 2, 3, 4, 7, 8), 9);

        assertThat(lottoResult).isEqualTo(LottoResult.FOURTH);
    }

    @DisplayName("로또 번호가 당첨 번호와 3개가 일치하면 5등이다.")
    @Test
    void FifthIfMatchesThreeLottoNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoResult lottoResult = lotto.getLottoResult(List.of(1, 2, 3, 7, 8, 9), 10);

        assertThat(lottoResult).isEqualTo(LottoResult.FIFTH);
    }
}
