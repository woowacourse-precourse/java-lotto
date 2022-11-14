package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.User;

import java.util.List;

import static lotto.domain.User.*;

import static lotto.service.GameService.*;
import static lotto.view.GameOutput.getDetailResults;

public class Controller {
    public static int win;
    public static boolean bonus;
    public static List<Integer> RewardList;
    public void playGame(){
        Lotto Lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        User User = new User(getMoney(), getUserInput(), getBonusNum());

        win = winLotto(Lotto, User);
        bonus = bonusLotto(Lotto, User.bonusBall);
        RewardList = getResult(win,bonus);
        getReward();
    }

    public void getReward(){
        getDetailResults(money, RewardList);
    }

}
