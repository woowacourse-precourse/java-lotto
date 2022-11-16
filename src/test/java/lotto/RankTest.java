package lotto;

import lotto.controller.Dispatch;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinLotto;
import lotto.domain.user.User;
import lotto.service.RankService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RankTest {
    LottoConfig lottoConfig = new LottoConfig();
    Dispatch dispatch = new Dispatch(lottoConfig);

    @Test
    @DisplayName("당첨 번호 입력 테스트")
    void generateWinningLotto(){
        List<Integer> winningNumbers = dispatch.convertWinningNumbers("1,2,3,4,5,6");
        Integer bonus = dispatch.convertBonus("7");
        assertThatCode(
                () -> new WinLotto(winningNumbers, bonus)
        ).doesNotThrowAnyException();
        System.out.println(new WinLotto(winningNumbers, bonus));
    }

    @Test
    @DisplayName(",로 구분되지 않는 경우 예외 처리")
    void generateWinningLottoException(){
        assertThatThrownBy(
                () -> dispatch.convertWinningNumbers("1 2 3 4 5 6")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 범위를 넘어가는 경우 예외 처리1")
    void generateWinningLottoException2(){
        String bonus = "100";
        assertThatThrownBy(
                () -> dispatch.convertBonus(bonus)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 범위를 넘어가는 경우 예외 처리2")
    void generateWinningLottoException3(){
        assertThatThrownBy(
                () -> dispatch.convertWinningNumbers("1 2 3 4 5 100")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자와 당첨 숫자가 중복되는 경우")
    void generateWinningLottoException4(){
        List<Integer> winningNumbers = dispatch.convertWinningNumbers("1,2,3,4,5,7");
        WinLotto winLotto = new WinLotto(winningNumbers);
        Integer bonus = dispatch.convertBonus("7");
        assertThatThrownBy(
                () -> winLotto.setBonusNumber(bonus)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("등수 계산 테스트")
    void ranking(){
        List<Integer> winningNumbers = dispatch.convertWinningNumbers("1,2,3,4,5,6");
        Integer bonus = dispatch.convertBonus("7");
        List<Lotto> lottos = testLottos();

        User user = new User(1000);
        buylotto(lottos, user);

        WinLotto winLotto = new WinLotto(winningNumbers, bonus);
        List<Integer> ranking = new ArrayList<>
                (lottoConfig.rankService().calculateRanking(user, winLotto).getRank().values());

        List<Integer> result = new ArrayList<>(List.of(2, 1, 1, 1, 1, 0));
        assertThat(ranking).isEqualTo(result);
    }

    private void buylotto(List<Lotto> lottos, User user){
        for (Lotto lotto : lottos){
            user.buyLotto(lotto);
        }
    }

    private List<Lotto> testLottos(){

        List<Integer> first = new ArrayList<>(List.of(1,2,3,4,5,6));
        List<Integer> second = new ArrayList<>(List.of(1,2,3,4,5,7));
        List<Integer> third = new ArrayList<>(List.of(1,2,3,4,5,8));
        List<Integer> fourth = new ArrayList<>(List.of(1,2,3,4,8,9));
        List<Integer> fifth = new ArrayList<>(List.of(1,2,3,7,8,9));
        List<Integer> fifth2 = new ArrayList<>(List.of(1,2,3,7,8,9));

        return new ArrayList<>(
                List.of(new Lotto(first), new Lotto(second),
                        new Lotto(third), new Lotto(fourth),
                        new Lotto(fifth), new Lotto(fifth2)));
    }
}
