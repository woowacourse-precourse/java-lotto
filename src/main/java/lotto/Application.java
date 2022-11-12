package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import static lotto.Converter.convertToInteger;
import static lotto.Converter.convertToIntegerList;

import java.util.List;



public class Application {
    public static Rank getWinning(Lotto userLotto, WinningLotto winningLotto) {
        // 메소드 호출로 필드의 객체를 반환 -> 필드 값이 변경되어서는 안됨
        final List<Integer> userNumbers = userLotto.getNumbers();
        final List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();

        int hitCount = ((int) userNumbers.stream()
                .filter(userNumber -> winningNumbers.contains(userNumber))
                .count());

        boolean bonusHit = false;
        if (userNumbers.contains(bonusNumber)) {
            bonusHit = true;
        }

        return Rank.getWinning(hitCount, bonusHit);
    }

    public static void addWinnings(Buyer buyer, WinningLotto winningLotto) {
        for (Lotto userLotto : buyer.getLottos()) {
            Rank rank = getWinning(userLotto, winningLotto);

            buyer.addWinning(rank);
        }
    }

    public static void main(String[] args) {
        try {
            int money = convertToInteger(readLine());

            Buyer buyer = new Buyer(money);
            buyer.showLottos();

            List<Integer> winningNumbers = convertToIntegerList(readLine());
            int bonusNumber = convertToInteger(readLine());

            WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

            addWinnings(buyer, winningLotto);
            buyer.showWinnings();

            System.out.println("총 수익률은 " + buyer.getYield() + "%입니다.");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
