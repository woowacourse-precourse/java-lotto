package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoResultMakerTest {
    LottoResultMaker maker = new LottoResultMaker();

    @DisplayName("당첨 번호와 사용자 로또 번호가 똑같은 경우")
    @Test
    public void compareWithWinningLotto_메서드로_모든_번호가_같은_경우() throws Exception {
        //given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        int matchNumberCount = maker.countLottoNumberMatch(winningLotto, userLotto);

        //then
        Assertions.assertThat(matchNumberCount).isEqualTo(6);
    }

    @DisplayName("당첨 번호와 사용자 로또 번호가 모두 다른 경우")
    @Test
    public void compareWithWinningLotto_메서드로_모든_번호가_다른_경우() throws Exception {
        //given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto userLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        //when
        int matchNumberCount = maker.countLottoNumberMatch(winningLotto, userLotto);

        //then
        Assertions.assertThat(matchNumberCount).isEqualTo(0);
    }

}