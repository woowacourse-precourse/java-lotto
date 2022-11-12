package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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

        // 당첨 번호를 입력받는 메서드 호출

        // 보너스 번호를 입력받는 메서드 호출

        // 당첨 통계를 구하는 메서드 호출
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

        if(!winningNumberInput.contains(","))
            throw new IllegalArgumentException("[ERROR]Winning number error");

        String[] winningNumberSplit = ",".split(winningNumberInput);
        if(winningNumberSplit.length != 6)
            throw new IllegalArgumentException("[ERROR]Winning number error");

        List<Integer> winningNunmbers = new ArrayList<>();
        for(String num : winningNumberSplit) {
            try {
                winningNunmbers.add(Integer.parseInt(num));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR]Winning number error");
            }
        }

        return new Lotto(winningNunmbers);
    }

    public static int getBonusInput() {
        int bonus;
        try {
            bonus = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]Bonus input error");
        }

        if (bonus < 1 || bonus > 45) throw new IllegalArgumentException("[ERROR]Bonus input error");

        return bonus;
    }

    public static List<Lotto> purchaseLotto(int purchaseNum) {

        List<Lotto> lottos = new ArrayList<>();

        for(int i=0; i<purchaseNum; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto l = new Lotto(numbers);
            lottos.add(l);
        }

        return lottos;
    }
}
