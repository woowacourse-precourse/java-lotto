package lotto;

import lotto.lottonumber.Lotto;
import lotto.lottonumber.LottoNumber;
import java.util.List;
import java.util.Scanner;

import static lotto.lottocomparator.LottoComparator.judgeAllLotto;
import static lotto.mainio.MainApplicationIo.*;

public class Application {
    /**
     * 프로그램 메인 함수입니다.
     * 전체 입출력을 담당합니다.
     * @param args
     */
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        try {
            List<LottoNumber> userLottoNumbers = buyLotto(inputPurchaseAmount() / 1000);
            Lotto winningLotto = inputWinningLotto();
            int bonusNumber = inputBonusNumber();
            printStat(judgeAllLotto(new LottoNumber(winningLotto, bonusNumber), userLottoNumbers));
        } catch (IllegalArgumentException ignored) { }
        scanner.close();
    }
}
