package lotto;

import lotto.Entity.Lotto;
import lotto.Entity.ResultLotto;
import lotto.Entity.User;
import lotto.util.MatchMoney;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();

    private User user;
    private List<Integer> winnigNumbers;
    private ResultLotto resultLotto;
    private int bonusNumber;

    public void run(){
        user = new User();
        winnigNumbers = new ArrayList<>();

        UserBuyLotto();
        outputView.showUserLotto(user.getLottos());
        winningNumbersPublish();
        bonusNumberCreate();

        calResult();
        outputView.showTotalResult(resultLotto, user.getMoney());
    }

    public void UserBuyLotto(){
        int money = inputView.inputMoney();
        user.setMoney(money);
        user.buyLotto();
    }

    public void winningNumbersPublish(){
        String input = inputView.createWinningNumbers();
        winnigNumbers = new Lotto(input).getNumbers();
    }

    public void bonusNumberCreate(){
        String input = inputView.createBonusNumber(winnigNumbers);
        bonusNumber = Integer.parseInt(input);
    }

    public void calResult(){
        resultLotto = new ResultLotto();
        for(Lotto lotto : user.getLottos()){
            MatchMoney matchMoney = getMatchMoney(lotto.getNumbers());
            resultLotto.addMatchMoney(matchMoney);
        }
    }

    public MatchMoney getMatchMoney(List<Integer> lottoNumber){
        boolean bonus = false;
        int match =  (int)lottoNumber.stream().
                filter(x -> winnigNumbers.contains(x)).count();
        if(winnigNumbers.contains(bonusNumber))
            bonus = true;
        return MatchMoney.of(match,bonus);
    }
}
