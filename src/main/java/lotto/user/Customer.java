package lotto.user;

import lotto.store.Lotto;
import lotto.store.LottoMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    public List<Integer> matchWinNumbers(List<Integer> winNumbers) {
        return lotteries.stream()
                .map(lottoNumbers -> lottoNumbers.compareWinNumbers(winNumbers))
                .collect(Collectors.toList());
    }

    public List<Integer> matchBonusNumber(int bonusNumber) {
        return lotteries.stream()
                .map(matchNumber -> matchNumber.compareBonusNumber(bonusNumber))
                .collect(Collectors.toList());
    }

}
