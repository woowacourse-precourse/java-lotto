package lotto;

import lotto.controller.RankController;
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
    RankService rankService = lottoConfig.rankService();
    RankController rankController = lottoConfig.rankController();

    @Test
    @DisplayName("당첨 번호 입력 테스트")
    void generateWinningLotto(){
        String winningNumbers = "1,2,3,4,5,6";
        String bonus = "7";
        assertThatCode(
                () -> rankService.generateWinningLotto(winningNumbers, bonus)
        ).doesNotThrowAnyException();
        System.out.println(rankService.generateWinningLotto(winningNumbers, bonus));
    }

    @Test
    @DisplayName("\',\'로 구분되지 않는 경우 예외 처리")
    void generateWinningLottoException(){
        String winningNumbers = "1 2 3 4 5 6";
        String bonus = "7";
        assertThatThrownBy(
                () -> rankService.generateWinningLotto(winningNumbers, bonus)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 범위를 넘어가는 경우 예외 처리1")
    void generateWinningLottoException2(){
        String winningNumbers = "1 2 3 4 5 6";
        String bonus = "100";
        assertThatThrownBy(
                () -> rankService.generateWinningLotto(winningNumbers, bonus)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 범위를 넘어가는 경우 예외 처리2")
    void generateWinningLottoException3(){
        String winningNumbers = "1 2 3 4 5 100";
        String bonus = "7";
        assertThatThrownBy(
                () -> rankService.generateWinningLotto(winningNumbers, bonus)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자와 당첨 숫자가 중복되는 경우")
    void generateWinningLottoException4(){
        String winningNumbers = "1 2 3 4 5 7";
        String bonus = "7";
        assertThatThrownBy(
                () -> rankService.generateWinningLotto(winningNumbers, bonus)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("등수 계산 테스트")
    void ranking(){
        String winningNumber = "1,2,3,4,5,6";
        String bonus = "7";
        List<Lotto> lottos = testLottos();

        User user = new User(String.valueOf(lottos.size() * 1000));
        buylotto(lottos, user);

        WinLotto winLotto = rankService.generateWinningLotto(winningNumber, bonus);
        List<Integer> ranking = new ArrayList<>
                (rankService.calculateRanking(user, winLotto).getRank().values());


        List<Integer> result = new ArrayList<>(List.of(2, 1, 1, 1, 1, 0));
        assertThat(ranking).isEqualTo(result);
    }

    @Test
    @DisplayName("등수 계산 테스트")
    void rankingView(){
        String winningNumber = "1,2,3,4,5,6";
        String bonus = "7";
        List<Lotto> lottos = testLottos();

        User user = new User(String.valueOf(lottos.size() * 1000));
        buylotto(lottos, user);

        String rankingView = rankController.statistics(user, winningNumber, bonus);

        String result = "3개 일치 (5,000원) - 2개\n" +
                "4개 일치 (50,000원) - 1개\n" +
                "5개 일치 (1,500,000원) - 1개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                "6개 일치 (2,000,000,000원) - 1개";

        assertThat(rankingView).contains(result);
        System.out.println(rankingView);
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
