package lotto.controller;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.view.InputView;

import java.util.List;

public class Game {

    public Game() {
        try{
            Issue user = new Issue();
            List<Integer> numbers = InputView.InputWinNumber();
            Lotto winLotto = new Lotto(numbers);
            int bonusNumber = InputView.InputBonusNumber();
            Bonus bonusLotto = new Bonus(bonusNumber);
            Compare userCompare = new Compare(user.userLotto, winLotto,bonusLotto.bonusNumber);
            new Yield(user.userPrice,userCompare);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] "+e.getMessage());
        }

    }

}
