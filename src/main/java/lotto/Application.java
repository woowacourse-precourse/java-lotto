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
        return Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .collect(toList());
    }
}
