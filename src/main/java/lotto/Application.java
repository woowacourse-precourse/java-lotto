package lotto;

import lotto.message.Message;
import lotto.money.Money;
import lotto.numbers.BonusNumber;
import lotto.numbers.MatchNumbers;
import lotto.numbers.RandomNumberCreater;
import lotto.numbers.WinningNumber;

import java.util.List;

public class Application { // 패키지 분리
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Message.requestInputMoneyMessage();
        int count = Money.countLotto(UserNumberScan.requestValue());
        Message.lottoBuyMessage(count);
        List<Lotto> countLotto = RandomNumberCreater.generateLottoNumber(count);
        for (int j = 0; j < count; j++) {
            Lotto lotto = countLotto.get(j);
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers);
        }

        Message.requestWinningNumberMessage();
        WinningNumber winningNumber = new WinningNumber(UserNumberScan.requestValue());
        List<Integer> numbers = winningNumber.getNumber();
        Message.requestBonusNumberMessage();
        int validBonusNumber = BonusNumber.validBonusNumber(UserNumberScan.requestValue(), numbers);
        MatchNumbers matchNumbers = new MatchNumbers();

        for (int j = 0; j < count; j++) {
            Lotto lotto = countLotto.get(j);
            List<Integer> numbers1 = lotto.getNumbers();
            matchNumbers.matchCount(numbers1, numbers, validBonusNumber);
        }

        Message.matchMessage(matchNumbers.getMaps());
        Message.ratio(Money.percentage(matchNumbers.getMaps()));
    }
}
