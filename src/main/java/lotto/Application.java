package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Buy.isRightNumber(Console.readLine());
        int count = Buy.buyLotto(money);

        System.out.println(count+"개를 구매했습니다.");
        List<Lotto> purchases = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            purchases.add(Buy.issueLotto());
        }

        Lotto winLotto = askWinLotto();
        int winBonus = askWinBonus(winLotto);

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < purchases.size(); i++) {
            results.add(Analyse.containNumber(winLotto, purchases.get(i), winBonus));
        }
        System.out.println("results:" + results);

        List<Integer> forPrint = Analyse.analyseResult(results);
        System.out.println("forPrint : " + forPrint);
        printResults(forPrint, money);

    }

    public static Lotto askWinLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String[] answer = Console.readLine().split(",");
        String winNum = String.join("", answer);
        try {
            Double.parseDouble(winNum);
        } catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자만 입력해주세요.");
            e.getMessage();
        }

        List<Integer> winNumber = new ArrayList<>();
        for (int i = 0; i < answer.length; i++) {
            winNumber.add(Integer.parseInt(answer[i]));
        }

        Lotto winLotto = new Lotto(winNumber);

        return winLotto;

    }

    public static int askWinBonus(Lotto winLotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Buy.isRightNumber(Console.readLine());

        List<Integer> winNum = winLotto.getLotto();

        if (winNum.contains(bonus)) {
            System.out.println("[ERROR] 로또 숫자가 중복됩니다.");
            throw new IllegalArgumentException("[ERROR] 로또 숫자가 중복됩니다.");
        }

        if (bonus < 1 || bonus > 45) {
            System.out.println("[ERROR] 로또 숫자의 범위가 적절하지 않습니다.");
            throw new IllegalArgumentException();
        }
        System.out.println("winBonus:" + bonus);
        return bonus;
    }

    public static void printResults(List<Integer> results, int money) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + results.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + results.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + results.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + results.get(4) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + results.get(3) + "개");

        double gain = ((results.get(0) * Prize.THREE.getPrize() +
                results.get(1) * Prize.FORU.getPrize() +
                results.get(2) * Prize.FIVE.getPrize() +
                results.get(3) * Prize.SEVEN.getPrize() +
                results.get(4) * Prize.SIX.getPrize()) / (double)money) * 100;
        System.out.println("총 수익률은 " + gain + "%입니다.");
    }


}
