package lotto;

import lotto.controller.RankController;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinLotto;
import lotto.domain.rank.Rank;
import lotto.domain.rank.RankInfo;
import lotto.domain.user.User;
import lotto.service.RankService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitTest {

    LottoConfig lottoConfig = new LottoConfig();
    RankService rankService = lottoConfig.rankService();
    RankController rankController = lottoConfig.rankController();

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateProfit(){
        String winningNumber = "1,2,3,4,5,6";
        String bonus = "7";
        List<Lotto> lottos = testLottos();

        User user = new User(String.valueOf(lottos.size() * 1000));
        buylotto(lottos, user);
        WinLotto winLotto = rankService.generateWinningLotto(winningNumber, bonus);
        Rank rank = rankService.calculateRanking(user, winLotto);
        Double profit = rankService.calculateProfit(user, rank);

        double result = (RankInfo.FIFTH.getMoney() * 2
                + RankInfo.FOURTH.getMoney()
                + RankInfo.THIRD.getMoney()
                + RankInfo.SECOND.getMoney()
                + RankInfo.FIRST.getMoney()) / (double)(user.getMoney());
        result *= 100;
        assertThat(profit).isEqualTo(result);
    }

    @Test
    @DisplayName("수익률 View 테스트")
    void ProfitView(){
        String winningNumber = "1,2,3,4,5,6";
        String bonus = "7";
        List<Lotto> lottos = testLottos();

        User user = new User(String.valueOf(lottos.size() * 1000));
        buylotto(lottos, user);
        String profitView = rankController.statistics(user, winningNumber, bonus);

        double profit = (RankInfo.FIFTH.getMoney() * 2
                + RankInfo.FOURTH.getMoney()
                + RankInfo.THIRD.getMoney()
                + RankInfo.SECOND.getMoney()
                + RankInfo.FIRST.getMoney()) / (double)(user.getMoney());
        profit *= 100;
        assertThat(profitView).contains(String.format("%.1f", profit));
        System.out.println(profitView);
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
