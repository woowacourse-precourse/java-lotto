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

    public int getBonusNumber(int number) {
        if (number < LottoInfo.START_NUMBER.getValue() || number > LottoInfo.END_NUMBER.getValue()) {
            throw new IllegalArgumentException();
        }
        return number;
    }
}
