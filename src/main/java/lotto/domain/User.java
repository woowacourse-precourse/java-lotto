package lotto.domain;

import static lotto.utils.message.DynamicMessagesUtil.*;
import static lotto.utils.message.NumberMessageUtil.LOTTO_COUNT;
import static lotto.utils.message.NumberMessageUtil.LOTTO_MAX;
import static lotto.utils.message.NumberMessageUtil.LOTTO_MIN;
import static lotto.utils.message.NumberMessageUtil.LOTTO_PRICE;
import static lotto.utils.message.StaticMessagesUtil.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.ConsoleUtil;
import lotto.utils.validate.NumberValidator;
import lotto.utils.winning.RankUtil;

public class User {
    private int money;
    private List<Lotto> lottos = new ArrayList<>();
    private WinningResult result = new WinningResult();

    public void buyLotto() {
        ConsoleUtil.showMessage(INPUT_BUY_MONEY.getMessage());
        String input = ConsoleUtil.input();
        validateBuyMoney(input);

        money = Integer.parseInt(input);
        int buyAmount = money / LOTTO_PRICE.getNumber();

        while(buyAmount-- > 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LOTTO_MIN.getNumber(), LOTTO_MAX.getNumber(), LOTTO_COUNT.getNumber());
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    private void validateBuyMoney(String money) {
        NumberValidator.validateBuyMoney(money);
    }

    public void showBuyResult() {
        showBuyAmount();
        showNumbers();
    }

    private void showBuyAmount() {
        String message = BUY_AMOUNT.getMessage();
        String param = String.valueOf(getBuyAmount());
        ConsoleUtil.showParamMessage(message, param);
    }

    public int getBuyAmount() {
        return lottos.size();
    }

    private void showNumbers() {
        for (Lotto lotto : lottos) {
            List<Integer> sortNumbers = lotto.getSortNumbers();
            List<String> numbers = convertIntegerToString(sortNumbers);

            String param = String.join(JOIN_NUMBERS_DELIMITER.getMessage(), numbers);
            String message = LOTTO_NUMBERS.getMessage();
            ConsoleUtil.showParamMessage(message, param);
        }
    }

    private List<String> convertIntegerToString(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public void showLottoResult(Winning winning) {
        showWinningResult(winning);
        showProfit();
    }

    private void showWinningResult(Winning winning) {
        for (Lotto lotto : lottos) {
            RankUtil rank = lotto.compare(winning);
            result.addRank(rank);
        }

        result.show();
    }

    private void showProfit() {
        long profit = result.getProfit();

        String message = PROFIT.getMessage();
        double profitRate = getProfitRate(profit);

        ConsoleUtil.showParamMessage(message, profitRate);
    }

    private double getProfitRate(long profit) {
        return profit * 100 / (double) money;
    }
}
