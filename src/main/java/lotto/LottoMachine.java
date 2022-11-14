package lotto;

import java.util.List;

public class LottoMachine {
    public int getLottoBuyCount(int paidMoney) {
        return paidMoney / LottoInfo.PRICE.getValue();
    }

    public List<Integer> getWinningNumbers(List<Integer> numbers) {
        Utils.validateLottoNumbers(numbers);
        return numbers;
    }
}
