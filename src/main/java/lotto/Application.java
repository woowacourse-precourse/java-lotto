package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static Winning getWinning(Lotto userLotto, Lotto winningLotto) {
        List<Integer> userNumbers = userLotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        boolean bonusHit = false;
        int hitCount = 0;

        winningNumbers.retainAll(userNumbers);
        hitCount = winningNumbers.size();

        if (hitCount < 3) {
            return null;
        }

        if (userNumbers.contains(Lotto.getBonusNumber())) {
            bonusHit = true;
        }

        return Winning.getWinning(hitCount, bonusHit);
    }



    public static void main(String[] args) {
        int money;
        List<Integer> winningNumbers;
        int bonusNumber;
        Lotto winningLotto;
        User user;

        money = Converter.convertMoneyInput(readLine());
        user = new User(money);
        user.printLottos();

        winningNumbers = Converter.convertNumbersInput(readLine());
        winningLotto = new Lotto(winningNumbers);

        bonusNumber = Converter.convertBonusNumberInput(readLine());
        Lotto.setBonusNumber(bonusNumber);

    }
}
