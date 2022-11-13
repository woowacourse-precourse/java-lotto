package lotto.domainTest;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoService;
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
    @DisplayName("사용자 로또번호중 당첨번호가 있는지 확인")
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
    void rankLottoTest() {
        //given(준비)
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> userLotto = List.of(1,2,3,4,5,6);

        int count = lottoService.countMatchNumber(lotto.getNumbers(), userLotto);
        boolean bonusNumber = false;

        //when(실행)
        LottoRank rank = lottoService.rankLotto(count, bonusNumber);

        //then(검증)
        Assertions.assertThat(rank).isEqualTo(LottoRank.FIRST);
    }



}
