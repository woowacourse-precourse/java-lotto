package lotto.service;

import lotto.exception.AmountException;
import lotto.exception.LottoException;
import lotto.status.lotto.LottoStatus;
import java.util.List;

public class Convertor {

    public static int getQuantity(String input) {
        AmountException.validateAmount(input);
        return Integer.parseInt(input) / LottoStatus.eachPrice.getValue();
    }

    public static int getAmount(int quantity) {
        return (quantity * LottoStatus.eachPrice.getValue());
    }

    public static List<Integer> getNumbers(String input) {
        return LottoException.validateWinningNumbers(input);
    }

    public static int getNumber(String input) {
        return LottoException.validateNumber(input);
    }
}
