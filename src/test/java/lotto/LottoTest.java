package lotto;

import constants.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @DisplayName(("금액에 맞는 수 만큼 로또를 생성한다"))
    @Test
    void createLottosSizeCheck() {
        LottoMachine lottoMachine = new LottoMachine();
        assertThat(lottoMachine.buyLotto(3999)).size().isEqualTo(3);
    }


    @DisplayName("당첨번호와 일치하는 로또번호의 일치 여부를 리턴한다")
    @Test
    void matchesTest() {
        LottoRaffler raffler = new LottoRaffler(new Integer[]{1,2,3,4,5,6},7);

        assertThat(raffler.checkMatches(8)).isEqualTo(0);
    }

    @DisplayName("로또의 등수를 리턴한다")
    @Test
    void getRankTest() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,22,33));
        LottoRaffler raffler = new LottoRaffler(new Integer[]{1,2,3,4,5,6},7);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);
        assertThat(raffler.raffle(lottos)).isEqualTo(Rank.FOUR);
    }

}
