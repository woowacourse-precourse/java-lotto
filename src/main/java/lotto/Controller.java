package lotto;


import lotto.domain.Lottos;
import lotto.domain.User;
import lotto.service.GameService;

import java.util.List;

import static lotto.domain.Lottos.getMoney;
import static lotto.domain.User.getBonusBall;
import static lotto.domain.User.getBonusNum;
import static lotto.domain.User.getUserInput;

import static lotto.service.GameService.getResult;
import static lotto.service.GameService.getFinalResult;
import static lotto.service.GameService.matchbonusBall;
import static lotto.service.GameService.winLotto;

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
            getResult(winLotto(Lottos.getLotto(i),User),matchbonusBall(Lottos.getLotto(i),bonus));
        }
        RewardList = getFinalResult();
        getReward();
    }

    public void getBonus(){
        bonus = getBonusBall();
    }

    public void getReward(){
        getDetailResults(money, RewardList);
    }
}
