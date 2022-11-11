package lotto.domainTest;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoService;
import lotto.domain.UserLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoServiceTest {

    @Test
    @DisplayName("당첨번호와 사용자 로또번호의 같은 숫자갯수 반환")
    void countCorrectTest() {
        //given(준비)
        LottoService lottoService = new LottoService();

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> userLotto = List.of(3,4,5,6,7,8);

        //when(실행)
        int count = lottoService.countCorrect(lotto.getNumbers(), userLotto);

        //then(검증)
        Assertions.assertThat(count).isEqualTo(4);
    }

    @Test
    @DisplayName("사용자 로또번호중 당첨번호가 있는지 확인")
    void countBonusTest() {
        //given(준비)
        LottoService lottoService = new LottoService();

        List<Integer> userLotto = List.of(3,4,5,6,7,8);
        BonusNumber.BONUS_NUMBER.setNumber(7);


        //when(실행)
        boolean bonusFlag = lottoService.countBonus(userLotto);

        //then(검증)
        Assertions.assertThat(bonusFlag).isTrue();
    }


}
