package lotto;

import lotto.lottonumber.Lotto;
import lotto.lottonumber.LottoNumber;
import lotto.mainio.MainApplicationIo;
import java.util.List;
import java.util.Scanner;

import static lotto.lottocomparator.LottoComparator.judgeAllLotto;
import static lotto.mainio.MainApplicationIo.*;

public class Application {
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        try {
            List<LottoNumber> userLottoNumbers = MainApplicationIo.buyLotto(inputPurchaseAmount() / 1000);
            Lotto winningLotto = MainApplicationIo.inputWinningLotto();
            int bonusNumber = MainApplicationIo.inputBonusNumber();
            printStat(judgeAllLotto(new LottoNumber(winningLotto, bonusNumber), userLottoNumbers));
        } catch (IllegalArgumentException ignored) { }
        scanner.close();
    }
}
