package lotto.domainTest;

import lotto.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @Test
    @DisplayName("당첨번호와 사용자 로또번호의 같은 숫자갯수 반환")
    void countMatchNumberTest() {
        //given(준비)
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> userLotto = List.of(3,4,5,6,7,8);

        //when(실행)
        int count = lottoService.countMatchNumber(lotto.getNumbers(), userLotto);

        //then(검증)
        Assertions.assertThat(count).isEqualTo(4);
    }

    @Test
    @DisplayName("보너스 번호가 당첨되었고 로또 등수가 2등일때만 true 반환")
    void checkBonusNumberTest() {
        //given(준비)
        List<Integer> userLotto = List.of(1,2,3,4,5,7);
        int matchNumberCount = 5;

        BonusNumber.BONUS_NUMBER.setNumber(7);

        //when(실행)
        boolean bonusFlag = lottoService.checkBonusNumber(matchNumberCount, userLotto);

        //then(검증)
        Assertions.assertThat(bonusFlag).isTrue();
    }

    @Test
    @DisplayName("구입한 로또에 대한 등수 반환")
    void createLottoResultTest() {
        //given(준비)
        List<Integer> lotto = List.of(1,2,3,4,5,6);
        BonusNumber.BONUS_NUMBER.setNumber(7);
        List<List<Integer>> userLotto = List.of(List.of(1,2,3,4,5,6),
                List.of(1,2,3,40,41,42),
                List.of(1,2,3,4,40,41),
                List.of(1,2,3,4,5,40),
                List.of(1,2,3,4,5,7),
                List.of(40,41,42,43,44,45));

        //when(실행)
        List<LottoRank> lottoResult = lottoService.createLottoResult(lotto, userLotto);

        //then(검증)
        Assertions.assertThat(lottoResult).contains(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD,
                LottoRank.FOURTH, LottoRank.FIFTH, LottoRank.BLANK);
    }

    @Test
    @DisplayName("로또 당첨 결과를 통해 수익률 계산")
    void calculatePercent() {
        //given(준비)
        List<LottoRank> lottoResult = List.of(LottoRank.FIFTH, LottoRank.BLANK, LottoRank.BLANK, LottoRank.BLANK);

        //when(실행)
        String percent = lottoService.calculatePercent(lottoResult);

        //then(검증)
        Assertions.assertThat(percent).isEqualTo("125.0");
    }

}
