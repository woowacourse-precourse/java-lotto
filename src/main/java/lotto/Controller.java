package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.User;
import lotto.service.GameService;

import java.util.List;

import static lotto.domain.Lottos.getMoney;
import static lotto.domain.Lottos.money;
import static lotto.domain.User.*;

import static lotto.service.GameService.*;
import static lotto.view.GameOutput.getDetailResults;

public class Controller {
    public static int money;
    public static int bonus;
    public static List<Integer> RewardList;
    public void playGame(){
        money = getMoney();

        Lottos Lottos = new Lottos(money);
        User User = new User(getUserInput(), getBonusNum());
        GameService gameService = new GameService();
        gameService.init();

        getBonus();
        for (int i=0; i<money/1000; i++){
            getResult(winLotto(Lottos.get_lotto(i),User),bonusBall(Lottos.get_lotto(i),bonus));
        }

        RewardList = getFinalResult();

        getReward();
    }
    public void getBonus(){
        bonus = bonusBall;
    }

    public void getReward(){
        getDetailResults(money, RewardList);
    }

}
