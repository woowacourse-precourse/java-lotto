package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 로또 구입 금액을 입력받는 메서드 호출
        System.out.println("구입금액을 입력해 주세요.");
        int inputMoney = getInputMoney();

        // 금액에 따른 구매 개수를 구하는 메서드 호출
        int purchaseNum = getPurchaseNum(inputMoney);
        System.out.println(purchaseNum + "개를 구매했습니다.");

        // 구매 개수에 맞게 로또를 발행하는 메서드 호출
        List<Lotto> lottos = purchaseLotto(purchaseNum);
        for (Lotto l : lottos)
            l.printElements();

        // 당첨 번호를 입력받는 메서드 호출
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winningLotto = getWinningNumber();

        System.out.println("보너스 번호를 입력해 주세요.");
        // 보너스 번호를 입력받는 메서드 호출
        int bonusNumber = getBonusInput(winningLotto);

        // 당첨 통계를 구하는 메서드 호출
        printResult(winningLotto, lottos, bonusNumber);
    }

    public static int getInputMoney() {
        int money;
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]Input error");
        }

        if (money < 1000) throw new IllegalArgumentException("[ERROR]Input error");
        if (money % 1000 != 0) throw new IllegalArgumentException("[ERROR]Input error");

        return money;
    }


    public static int getPurchaseNum(int inputMoney) {
        return inputMoney / 1000;
    }

    public static Lotto getWinningNumber() {
        String winningNumberInput = Console.readLine();

        if (!winningNumberInput.contains(","))
            throw new IllegalArgumentException("[ERROR]Winning number error");

        String[] winningNumberSplit = winningNumberInput.split(",");

        if (winningNumberSplit.length != 6)
            throw new IllegalArgumentException("[ERROR]Winning number error");

        List<Integer> winningNumbers = new ArrayList<>();
        for (String num : winningNumberSplit) {
            try {
                winningNumbers.add(Integer.parseInt(num));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR]Winning number error");
            }
        }

        return new Lotto(winningNumbers);
    }

    public static int getBonusInput(Lotto winningLotto) {
        int bonus;
        try {
            bonus = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]Bonus input error");
        }

        if (bonus < 1 || bonus > 45) throw new IllegalArgumentException("[ERROR]Bonus input error");
        isBonusNotDuplicated(winningLotto, bonus);

        return bonus;
    }

    public static void isBonusNotDuplicated(Lotto winningLotto, int bonus) {
        if (winningLotto.getElements().contains(bonus))
            throw new IllegalArgumentException("[ERROR]Bonus input error");
    }

    public static List<Lotto> purchaseLotto(int purchaseNum) {

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseNum; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto l = new Lotto(numbers);
            l.sortElements();
            lottos.add(l);
        }

        return lottos;
    }


    public static void printResult(Lotto winningLotto, List<Lotto> lottos, int bonusNumber) {
        System.out.println("당첨 통계\n" + "---");

        Result history = getEqualNumber(winningLotto, lottos, bonusNumber);
        history.printResultElements();

        calculateEarning(history, lottos.size() * 1000);
    }

    public static Result getEqualNumber(Lotto winningLotto, List<Lotto> lottos, int bonusNumber) {

        Result history = new Result();

        for(Lotto lotto : lottos) {
            int equalCount = equalNumberCounter(winningLotto, lotto, bonusNumber);

            if(equalCount == 3)
                history.setEqualThree();
            if(equalCount == 4)
                history.setEqualFour();
            if(equalCount == 5)
                history.setEqualFive();
            if(equalCount == 6)
                history.setEqualSix();
            if(equalCount == 7)
                history.setEqualFiveWithBonus();
        }

        return history;
    }

    public static int equalNumberCounter(Lotto winningLotto, Lotto userLotto, int bonusNumber) {

        int count = 0;
        for(Integer num : winningLotto.getElements())
            if (userLotto.getElements().contains(num))
                count += 1;

        if(count == 5)
            if(userLotto.getElements().contains(bonusNumber)) count = 7;

        return count;
    }

    public static void calculateEarning(Result history, int money) {
        double earning = (double)history.calculateElements() / (double)money;

        System.out.println("총 수익률은 " + earning * 100 + "%입니다.");
    }
}
