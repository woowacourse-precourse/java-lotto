package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;



public class Application {
    public static Winning getWinning(Lotto userLotto, WinningLotto winningLotto) {
        List<Integer> userNumbers = userLotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();

        int hitCount = ((int) userNumbers.stream()
                .filter(userNumber -> winningNumbers.contains(userNumber))
                .count());

        boolean bonusHit = false;
        if (userNumbers.contains(bonusNumber)) {
            bonusHit = true;
        }

        return Winning.getWinning(hitCount, bonusHit);
    }

    public static void addWinnings(User user, WinningLotto winningLotto) {
        for (Lotto userLotto : user.getLottos()) {
            Winning winning = getWinning(userLotto, winningLotto);

            user.addWinning(winning);
        }
    }

    public static void main(String[] args) {
        int money = Converter.convertMoneyInput(readLine());

        User user = new User(money);
        user.showLottos();

        List<Integer> winningNumbers = Converter.convertNumbersInput(readLine());;
        int bonusNumber = Converter.convertBonusNumberInput(readLine());

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        addWinnings(user, winningLotto);
        user.showWinnings();

        System.out.println("총 수익률은 " + user.getYield() + "%입니다.");
    }
}
