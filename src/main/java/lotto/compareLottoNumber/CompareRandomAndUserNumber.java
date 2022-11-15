package lotto.compareLottoNumber;

import java.util.List;
import lotto.buyLotto.Lotto;

public class CompareRandomAndUserNumber {
    private final CompareNumber compareNumber = new CompareNumber();
    private final GetResultNumber getNumber = new GetResultNumber();
    private final PrintResult printResult = new PrintResult();

    public void compareAndReturnResult(int money, int[] prizeNumbers, int[] result, List<Lotto> lottoNumbers) {
        System.out.println("당첨 번호를 입력해 주세요.");
        getNumber.getPrizeNumberFromUser(prizeNumbers);

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = getNumber.getBonusNumberFromUser(prizeNumbers);

        compareNumber.comparePrizeNumber(money, result, lottoNumbers, prizeNumbers);
        compareNumber.comparePrizeNumberWithBonusNumber(money, result, lottoNumbers, prizeNumbers, bonusNumber);

        printResult.printResult(result, money);
    }

}
