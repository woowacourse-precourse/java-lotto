package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.money.Money.createPurchaseMoney;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;
import lotto.money.Money;

public class InputView {

    public static Money inputPurchaseMoney() {
        String purchaseMoney = readLine();
        return createPurchaseMoney(purchaseMoney);
    }

    public static Lotto inputWinningNumber() {
        List<LottoNumber> winningNumbers = Arrays.stream(readLine().trim().split(","))
                .map(LottoNumber::new).collect(Collectors.toList());
        return new Lotto(winningNumbers);
    }

    public static LottoNumber inputBonusNumber() {
        return new LottoNumber(readLine().trim());
    }
}
