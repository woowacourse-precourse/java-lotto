package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoAccountantTest {
    LottoResultMaker maker = new LottoResultMaker();
    LottoAccountant accountant = new LottoAccountant(maker);

    @DisplayName("getLottoResults 메서드로 나온 결과 갯수가 로또 갯수와 일치하는지 테스트")
    @Test
    public void checkListSizeBy_getLottoResults() throws Exception {
        //given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        List<Lotto> userLottos = new ArrayList<>(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(2, 3, 4, 5, 6, 7))));

        //when
        List<LottoResult> lottoResults = accountant.getLottoResults(winningLotto, userLottos);

        //then
        assertThat(lottoResults.size()).isEqualTo(userLottos.size());
    }

    @DisplayName("로또 번호 같을 때, 당첨금이 제대로 저장됐는지 테스트")
    @Test
    public void checkWinningsBy_getLottoResults() throws Exception {
        //given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        List<Lotto> userLottos = new ArrayList<>(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));

        //when
        List<LottoResult> lottoResults = accountant.getLottoResults(winningLotto, userLottos);

        //then
        assertThat(lottoResults.get(0).getWinnings()).isEqualTo(LottoWinnings.LOTTO_6_NUMBERS_MATCH.getWinnings());
    }
}