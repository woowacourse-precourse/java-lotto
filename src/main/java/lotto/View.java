package lotto;

import java.text.DecimalFormat;
import java.util.EnumMap;

public class View {
    final String Cost = "구입금액을 입력해 주세요.";
    final String Winning = "당첨 번호를 입력해 주세요.";
    final String Bonus = "보너스 번호를 입력해 주세요.";
    String[] Ranking = {"first", "second", "third", "fourth", "fifth"};

    void startMention() {
        System.out.println(Cost);
    }

    void purchaseNumber(int number, Computer[] computers) {
        System.out.println(number + "개를 구매했습니다.");
        for (Computer cp : computers) System.out.println(cp);
    }

    void inputNumber() {
        System.out.println(Winning);
    }

    void inputBonus() {
        System.out.println(Bonus);
    }

    void printResult(EnumMap<Money, Integer> map) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (String mon : Ranking) {
            Money money = Money.valueOf(mon);
            System.out.println(money.getMoneyString() + map.getOrDefault(money, 0) + "개");
        }
    }

    void printBenfit(long input, long result) {
        double db = (double) result / input * 100;
        DecimalFormat df = new DecimalFormat("#,##0.0");
        String answer = df.format(db);
        System.out.println("총 수익률은 " + answer + "%입니다.");
    }
}
