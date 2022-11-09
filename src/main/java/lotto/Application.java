package lotto;

import lotto.domain.IssuedLotto;
import lotto.domain.LottoWinningNumber;
import lotto.domain.Seller;
import lotto.view.ProjectView;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Application {
    public static void main(String[] args) {
        String money = ProjectView.askPurchaseMoney();

        Seller seller = Seller.getInstance();
        IssuedLotto issuedLotto = seller.sellLotto(money);
        ProjectView.sell(issuedLotto);

        String winningNumber = ProjectView.getWinningNumber();
        List<Integer> winningNumbers = convertStringToList(winningNumber);
        String bonusNumber = ProjectView.getBonusNumber();

        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(winningNumbers, bonusNumber);
        System.out.println(lottoWinningNumber);
    }

    private static List<Integer> convertStringToList(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .collect(toList());
    }
}
