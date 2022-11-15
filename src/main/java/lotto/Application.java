package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    static int three;
    static int four;
    static int five;
    static int fiveBonus;
    static int six;
    static int buyMoney;
    static int GAME_MONEY = 1000;

    public static void main(String[] args) {

        ArrayList<Lotto> lottos = new ArrayList<>();
        UI ui = new UI();

        ui.lottoPrice();
        buyMoney = Integer.parseInt(Console.readLine());
        if (buyMoney % GAME_MONEY != 0) {
            throw new IllegalArgumentException("[ERROR]");
        }

        for (int i = 0; i < buyMoney / GAME_MONEY; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(i, lotto);
        }

        System.out.println(buyMoney / GAME_MONEY + "개를 구매했습니다.");
        for (int i = 0; i < lottos.toArray().length; i++) {
            System.out.println(lottos.get(i).getNumbers());
        }
        ui.winningNumber();
        String pickNumber = Console.readLine();
        String[] b = pickNumber.split(",");


        ui.bonusNumber();
        int BonusNumber = Integer.parseInt(Console.readLine());

        for (int i = 0; i < lottos.size(); i++) {
            lotterySame(lottos.get(i).getNumbers(), b, BonusNumber);
        }
        winningScore();
    }

    private static void lotterySame(List<Integer> numbers, String[] b, int bonusNumber) {

        List<String> list = Arrays.asList(b);
        List<Integer> newList = list.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        Collections.sort(newList);

        newList.add(bonusNumber);
        numbers.add(bonusNumber);

        lotteryWinning(numbers, newList);
    }

    private static void lotteryWinning(List<Integer> numbers, List<Integer> newList) {
        int count = 0;
        boolean bonuscount = false;
        if ((numbers.get(6) == newList.get(6))) {
            bonuscount = true;
        }
        for (int i = 0; i < 6; i++) {
            if (numbers.get(i) == newList.get(i)) {
                count++;
            }
        }
        if (count == 3) {
            three++;
        }
        if (count == 4) {
            four++;
        }
        if (count == 5 && !bonuscount) {
            five++;
        }
        if (count == 5 && bonuscount) {
            fiveBonus++;
        }
        if (count == 6) {
            six++;
        }
    }

    public static void winningScore() {
        float bMoney = buyMoney;
        float total = (((three * 5000) + (four * 50000) + (five * 1500000) + (fiveBonus * 3000000) + (six * 2000000000)) / bMoney) * 100;

        UI ui = new UI();
        ui.winningMessage();
        System.out.println("3개 일치 (5,000원) - " + three + "개");
        System.out.println("4개 일치 (50,000원) - " + four + "개");
        System.out.println("5개 일치 (1,500,000원) - " + five + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + six + "개");

        System.out.println("총 수익률은 " + String.format("%.1f", total) + "%입니다.");
    }
}
