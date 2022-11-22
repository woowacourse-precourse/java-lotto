package lotto.domain;

import static lotto.utils.ConsoleUtil.*;
import static lotto.utils.message.DynamicMessagesUtil.*;
import static lotto.utils.message.NumberMessagesUtil.LOTTO_COUNT;
import static lotto.utils.message.NumberMessagesUtil.LOTTO_MAX;
import static lotto.utils.message.NumberMessagesUtil.LOTTO_MIN;
import static lotto.utils.message.NumberMessagesUtil.LOTTO_PRICE;
import static lotto.utils.message.StaticMessagesUtil.*;
import static lotto.utils.validate.NumberValidator.validateBuyMoney;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.winning.RankUtil;

public class User {
    private int money;
    private List<Lotto> lottos = new ArrayList<>();
    private WinningResult result = new WinningResult();

    public void buyLotto() {
        showMessage(INPUT_BUY_MONEY.getMessage());
        String input = input();
        validateBuyMoney(input);

        int buyAmount = getBuyAmount(input);
        createLotto(buyAmount);
    }

    private int getBuyAmount(String input) {
        money = Integer.parseInt(input);
        int buyAmount = money / LOTTO_PRICE.getNumber();
        return buyAmount;
    }

    private void createLotto(int buyAmount) {
        while(buyAmount-- > 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LOTTO_MIN.getNumber(), LOTTO_MAX.getNumber(), LOTTO_COUNT.getNumber());
            lottos.add(new Lotto(numbers));
        }
    }

    public void showBuyResult() {
        showBuyAmount();
        showNumbers();
    }

    private void showBuyAmount() {
        String message = BUY_AMOUNT.getMessage();
        String param = String.valueOf(getBuyAmount());
        showParamMessage(message, param);
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
            showParamMessage(message, param);
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
        List<Integer> winningNumbers = winning.getWinningNumbers();
        int bonusNumber = winning.getBonusNumber();

        for (Lotto lotto : lottos) {
            RankUtil rank = lotto.compare(winningNumbers, bonusNumber);
            result.addRank(rank);
        }

        result.show();
    }

    private void showProfit() {
        long profit = result.getProfit();

        String message = PROFIT.getMessage();
        double profitRate = getProfitRate(profit);

        showParamMessage(message, profitRate);
    }

    private double getProfitRate(long profit) {
        if (profit == 0L) {
            return 0;
        }
        return profit * 100 / (double) money;
    }
}
