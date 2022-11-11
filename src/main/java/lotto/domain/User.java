package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.utils.ConsoleUtils;
import lotto.utils.MessageConstant;
import lotto.validate.NumberValidator;

public class User {
    private int money;
    private List<Lotto> lottos = new ArrayList<>();
    private NumberValidator validator = new NumberValidator();

    public void buyLotto() {
        ConsoleUtils.showMessage(MessageConstant.INPUT_BUY_AMOUNT);
        String input = ConsoleUtils.input();
        validator.validateBuyMoney(input);

        money = Integer.parseInt(input);

        for (int i= 0; i < money/1000; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

}
