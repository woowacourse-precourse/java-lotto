package lotto;

import lotto.controller.Compare;
import lotto.controller.Issue;
import lotto.controller.Yield;
import lotto.model.Lotto;
import lotto.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Issue user = new Issue();
        List<Integer> numbers = InputView.InputWinNumber();
        Lotto winLotto = new Lotto(numbers);
        int bonusLotto = InputView.InputBonusNumber();
        Compare userCompare = new Compare(user.userLotto, winLotto,bonusLotto);
        new Yield(user.userPrice,userCompare);
    }
}
