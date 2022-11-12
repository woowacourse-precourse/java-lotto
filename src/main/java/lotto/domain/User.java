package lotto.domain;

import static lotto.utils.DynamicMessagesUtil.*;
import static lotto.utils.MessagesUtil.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.ConsoleUtil;
import lotto.utils.MessagesUtil;
import lotto.validate.NumberValidator;

public class User {
    private int money;
    private double benefit;
    private List<Lotto> lottos = new ArrayList<>();
    private NumberValidator validator = new NumberValidator();

    public void buyLotto() {
        ConsoleUtil.showMessage(INPUT_BUY_MONEY.getMessage());
        String input = ConsoleUtil.input();
        validator.validateBuyMoney(input);

        money = Integer.parseInt(input);

        for (int i= 0; i < money/1000; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public void validateBuyMoney(String money) {
        validator.validateBuyMoney(money);
    }

    public void compare(List<Integer> winningLottoNumbers) {
        for (Lotto lotto : lottos) {
            int count = lotto.correctCount(winningLottoNumbers);
            boolean isMatch = lotto.isMatchBonusNumber(winningLottoNumbers);
        }
    }

    public void showBuyAmount() {
        String message = BUY_AMOUNT.getMessage();
        String param = String.valueOf(getBuyAmount());
        ConsoleUtil.showParamMessage(message, param);
    }

    public int getBuyAmount() {
        return lottos.size();
    }

    public void showNumbers() {
        for (Lotto lotto : lottos) {
            List<String> numbers = convertIntegerToString(lotto);

            String param = String.join(", ", numbers);
            String message = LOTTO_NUMBERS.getMessage();
            ConsoleUtil.showParamMessage(message, param);
        }
    }

    private List<String> convertIntegerToString(Lotto lotto) {
        return lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}
