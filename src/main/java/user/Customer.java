package user;

import store.Lotto;
import store.LottoMachine;

import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class Customer {
    private static final String NUMERIC_ERROR = "[ERROR] 숫자를 입력해 주시기 바랍니다.";
    private static final String NUMBER_OF_PURCHASES_PHRASE = "개를 구매했습니다.";

    private final List<Lotto> lotteries;
    private final int pay;

    public Customer(String readline) {
        validateNumeric(readline);
        this.pay = Integer.parseInt(readline);
        lotteries = buyLotteries(pay);
    }

    private List<Lotto> buyLotteries(int pay) {
        return LottoMachine.getInstance().pickLotteries(pay);
    }

    private void validateNumeric(String readline) {
        if (Pattern.matches("^\\d", readline)) {
            throw new IllegalArgumentException(NUMERIC_ERROR);
        }
    }

    public String toLottoString() {
        StringJoiner currentLotteries = new StringJoiner("\n");

        currentLotteries.add(lotteries.size() + NUMBER_OF_PURCHASES_PHRASE);
        lotteries.forEach(lotto -> currentLotteries.add(lotto.toString()));
        return currentLotteries.toString();
    }
}
