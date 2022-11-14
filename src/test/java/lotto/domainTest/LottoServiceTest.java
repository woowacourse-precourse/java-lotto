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
    @DisplayName("사용자 로또번호중 보너스번호가 있는지 확인")
    void checkBonusNumberTest() {
        //given(준비)
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> userLotto = List.of(1,2,3,4,5,7);

        int count = lottoService.countMatchNumber(lotto.getNumbers(), userLotto);

        BonusNumber.BONUS_NUMBER.setNumber(7);

        //when(실행)
        boolean bonusFlag = lottoService.checkBonusNumber(count, userLotto);

        //then(검증)
        Assertions.assertThat(bonusFlag).isTrue();
    }

    @Test
    @DisplayName("당첨된 로또 등수 반환")
    void rankLottoTest() {
        //given(준비)
        int matchCount = 5;
        boolean bonusNumber = true;

        //when(실행)
        LottoRank rank = lottoService.rankLotto(matchCount, bonusNumber);

        //then(검증)
        Assertions.assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void createLottoResultTest() {
        //given(준비)
        List<Integer> lotto = List.of(1,2,3,4,5,6);
        BonusNumber.BONUS_NUMBER.setNumber(7);
        List<List<Integer>> userLotto = List.of(List.of(1,2,3,4,5,6),
                List.of(1,2,3,40,41,42),
                List.of(1,2,3,4,40,41),
                List.of(1,2,3,4,5,40),
                List.of(1,2,3,4,5,7));

        //when(실행)
        List<LottoRank> lottoResult = lottoService.createLottoResult(lotto, userLotto);

        //then(검증)
        Assertions.assertThat(lottoResult).contains(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD,
                LottoRank.FOURTH, LottoRank.FIFTH);
    }

    @Test
    void calculatePercent() {
        //given(준비)
        List<LottoRank> lottoResult = List.of(LottoRank.FIFTH, LottoRank.BLANK, LottoRank.BLANK, LottoRank.BLANK);

        //when(실행)
        String percent = lottoService.calculatePercent(lottoResult);

        //then(검증)
        Assertions.assertThat(percent).isEqualTo("125.0");
    }

}
