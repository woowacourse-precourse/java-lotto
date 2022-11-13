package lotto;

import lotto.domain.IssuedLotto;
import lotto.domain.LottoWinningNumber;
import lotto.domain.WinningResult;
import lotto.domain.Seller;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static lotto.view.ProjectView.*;

public class Application {
    public static void main(String[] args) {
        String money = askPurchaseMoney();

        Seller seller = Seller.getInstance();
        try {
            IssuedLotto issuedLotto = seller.sellLotto(money);
            sell(issuedLotto);

            String winningNumber = getWinningNumber();
            List<Integer> winningNumbers = convertStringToList(winningNumber);
            String bonusNumber = getBonusNumber();

            LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(winningNumbers, bonusNumber);

            WinningResult result = lottoWinningNumber.getResult(issuedLotto);
            printResult(result, Integer.parseInt(money));
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }

    private static List<Integer> convertStringToList(String winningNumber) {
        String[] winningNumbers = validateSeparator(winningNumber);
        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .collect(toList());
    }

    private static String[] validateSeparator(String winningNumber) {
        String[] winningNumbers = winningNumber.split(",");
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 쉼표(,)를 이용하여 구분하여 입력해 주시기 바랍니다");
        }
        return winningNumbers;
    }
}
