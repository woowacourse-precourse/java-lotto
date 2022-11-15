package lotto;

import lotto.io.StaffListener;
import lotto.io.StaffListenerImpl;
import lotto.io.StaffTeller;
import lotto.io.StaffTellerImpl;
import lotto.lottoCashier.LottoCashier;
import lotto.lottoCashier.LottoCashierImpl;
import lotto.lottoChecker.LottoChecker;
import lotto.lottoChecker.LottoCheckerImpl;
import lotto.lottoGenerator.LottoGenerator;
import lotto.lottoGenerator.LottoGeneratorImpl;
import lotto.lottoGenerator.RandomNumbersGenerator;
import lotto.lottoGenerator.RandomNumbersGeneratorWithMissionUtils;
import lotto.numbers.Lotto;
import lotto.numbers.WinningNumbers;
import lotto.winningNumbersGenerator.WinningNumbersGenerator;
import lotto.winningNumbersGenerator.WinningNumbersGeneratorImpl;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StaffTeller staffTeller = new StaffTellerImpl();
        StaffListener staffListener = new StaffListenerImpl();
        LottoCashier lottoCashier = new LottoCashierImpl();
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGeneratorImpl();
        RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGeneratorWithMissionUtils();
        LottoGenerator lottoGenerator = new LottoGeneratorImpl(randomNumbersGenerator);

        String money = staffListener.receiveMoney();
        lottoCashier.validateReceivedMoney(money);
        int num = lottoCashier.calculateNumberOfLottos(Integer.parseInt(money));
        staffTeller.tellPurchasedNumberOfLotto(num);
        List<Lotto> lottoList = lottoGenerator.issueLottosByInputAmount(num);
        staffTeller.tellLottos(lottoList);

        String str1 = staffListener.listenMainWinningNumbers();
        String str2 = staffListener.listenBonusWinningNumber();

        WinningNumbers winningNumbers = winningNumbersGenerator.generateWinningNumbers(str1, str2);
        LottoChecker lottoChecker = new LottoCheckerImpl(winningNumbers);
        lottoChecker.checkLottos(lottoList);
        staffTeller.tellLottoResult(lottoChecker.getRankResult());
        staffTeller.tellROI(lottoChecker.calculateROI());
    }
}
