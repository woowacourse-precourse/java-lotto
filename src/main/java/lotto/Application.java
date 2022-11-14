package lotto;

import lotto.controller.Compare;
import lotto.controller.Issue;
import lotto.controller.Yield;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Issue user = new Issue();
        List<Integer> numbers = InputView.InputWinNumber();
        Lotto winLotto = new Lotto(numbers);
        int bonusNumber = InputView.InputBonusNumber();
        Bonus bonusLotto = new Bonus(bonusNumber);
        Compare userCompare = new Compare(user.userLotto, winLotto,bonusLotto.bonusNumber);
        new Yield(user.userPrice,userCompare);
    }
}
