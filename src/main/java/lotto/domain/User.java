package lotto.domain;

import static lotto.utils.message.DynamicMessagesUtil.*;
import static lotto.utils.message.StaticMessagesUtil.*;
import static lotto.utils.validate.NumberValidator.validateBuyMoney;

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

    public void buyLotto() {
        ConsoleUtil.showMessage(INPUT_BUY_MONEY.getMessage());
        String input = ConsoleUtil.input();
        validateBuyMoney(input);

        money = Integer.parseInt(input);

        for (int i= 0; i < money/1000; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public void validateBuyMoney(String money) {
        NumberValidator.validateBuyMoney(money);
    }

    public void showBuyAmount() {
        String message = BUY_AMOUNT.getMessage();
        String param = String.valueOf(getBuyAmount());
        ConsoleUtil.showParamMessage(message, param);
    }

    public void showNumbers() { // 리팩토링 대상. Lotto 번호를 왜 직접 처리? (getNumbers())
        for (Lotto lotto : lottos) {
            List<Integer> sortNumbers = lotto.getSortNumbers();
            List<String> numbers = convertIntegerToString(sortNumbers);

            String param = String.join(", ", numbers);
            String message = LOTTO_NUMBERS.getMessage();
            ConsoleUtil.showParamMessage(message, param);
        }
    }

    private List<String> convertIntegerToString(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public void showWinningResult(Winning winning) {
        WinningResult result = new WinningResult();

        for (Lotto lotto : lottos) {
            result.addRank(compare(lotto, winning));
        }

        result.show();
        showProfit(result);
    }

    public void showProfit(WinningResult result) {
        long profit = result.getProfit();

        String message = PROFIT.getMessage();
        double profitRate = getProfitRate(profit);

        ConsoleUtil.showParamMessage(message, profitRate);
    }

    private double getProfitRate(long profit) {
        return profit*100 / (double)money;
    }

    public RankUtil compare(Lotto lotto, Winning winning) {
        int count = lotto.correctCount(winning.getWinningNumbers());
        boolean isMatch = lotto.isMatchBonusNumber(winning.getBonusNumber());

        return getRank(count, isMatch);
    }

    private RankUtil getRank(int count, boolean isMatch) {
        if (count == 6) {
            return RankUtil.FIRST;
        } else if (count == 5 && isMatch) {
            return RankUtil.SECOND;
        } else if (count == 5) {
            return RankUtil.THIRD;
        } else if (count == 4) {
            return RankUtil.FOURTH;
        } else if (count == 3) {
            return RankUtil.FIFTH;
        }
        return RankUtil.MISS;
    }

    public int getBuyAmount() {
        return lottos.size();
    }
}
