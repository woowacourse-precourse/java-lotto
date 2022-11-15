package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private int purchaseAmount;
    private int lotteryCount;
    private List<Lotto> lotteryNumbers;


    public void inputPurchaseAmount(String input) {
        validate(input);
        this.purchaseAmount = Integer.parseInt(input);
    }

    public void setLotteryCount(){
        this.lotteryCount = purchaseAmount/1000;
    }

    public void lotteryNumberGenerator(){
        List<Lotto> lotteryNumbers = new ArrayList<>();

        for(int i=0; i<lotteryCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lotteryNumbers.add(new Lotto(numbers));
        }

        this.lotteryNumbers = lotteryNumbers;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Lotto> getLotteryNumbers() {
        return lotteryNumbers;
    }

    public int getLotteryCount(){
        return lotteryCount;
    }

    private void validate(String input) throws RuntimeException {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c))
                throw new IllegalArgumentException(LottoException.NOT_DISIT.getErrorMessage());
        }

        int intInput = Integer.parseInt(input);

        if (intInput % 1000 != 0)
            throw new IllegalArgumentException(LottoException.NOT_EFFECTIVE_UNIT.getErrorMessage());
    }
}
