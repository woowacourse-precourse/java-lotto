package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static Winning getWinning(Lotto userLotto, WinningLotto winningLotto) {
        List<Integer> userNumbers = userLotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();

        
        winningNumbers.retainAll(userNumbers);

        int hitCount = winningNumbers.size();
        if (hitCount < 3) {
            return null;
        }

        boolean bonusHit = false;
        if(userNumbers.contains(bonusNumber)) {
            bonusHit = true;
        }

        return Winning.getWinning(hitCount, bonusHit);
    }

    public static void addWinnings(User user, WinningLotto winningLotto) {
        for(Lotto userLotto : user.getLottos()) {
            Winning winning = getWinning(userLotto, winningLotto);

            if(winning == null) {
                continue;
            }

            user.addWinning((winning));
        }
    }

    public static void main(String[] args) {
        int money;
        List<Integer> winningNumbers;
        int bonusNumber;
        WinningLotto winningLotto;
        User user;

        money = Converter.convertMoneyInput(readLine());
        user = new User(money);
        user.printLottos();

        winningNumbers = Converter.convertNumbersInput(readLine());
        bonusNumber = Converter.convertBonusNumberInput(readLine());
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        addWinnings(user, winningLotto);

        user.printWinnings();
    }
}
