package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    static int three = 0;
    static int four = 0;
    static int five = 0;
    static int fiveBonus = 0;
    static int six = 0;
    static int buyMoney = 0;
    static int GAME_MONEY = 1000;

    public static void main(String[] args) {

        ArrayList<Lotto> lottos = new ArrayList<>();

        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        buyMoney = Integer.parseInt(Console.readLine());
        if (buyMoney % GAME_MONEY != 0) {
            throw new IllegalArgumentException("[ERROR]");
        }

        for (int i = 0; i < buyMoney / GAME_MONEY; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(i, lotto);
        }
        System.out.println();
        System.out.println(buyMoney / GAME_MONEY + "개를 구매했습니다.");
        for (int i = 0; i < lottos.toArray().length; i++) {
            System.out.println(lottos.get(i).getNumbers());
        }
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String pickNumber = Console.readLine();
        String[] b = pickNumber.split(",");

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int BonusNumber = Integer.parseInt(Console.readLine());

        for (int i = 0; i < lottos.size(); i++) {
            lotterySame(lottos.get(i).getNumbers(), b, BonusNumber);
        }
        winningScore();
// TODO : 중복, 1~45 이외 숫자 나올시 예외처리

// TODO: 1~45 이외 숫자 나올시 예외처리
    }

    private static void lotterySame(List<Integer> numbers, String[] b, int bonusNumber) {

        numbers.add(bonusNumber); // [1,2,3,4,5,6,7]
        Arrays.sort(b);
        List<String> list = Arrays.asList(b);
        List<Integer> newList = list.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        newList.add(bonusNumber);
        //TODO : 결과값 도출하기

        lotteryWinning(numbers, newList);

    }

    private static void lotteryWinning(List<Integer> numbers, List<Integer> newList) {
        int count = 0;
        boolean bonuscount = ((numbers.get(6) == newList.get(6)));

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
        if (count == 5) {
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
        float total = ((three * 5000) + (four * 50000) + (five * 1500000) + (fiveBonus * 30000000) + (six * 2000000000)) / (buyMoney * GAME_MONEY);

        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + three + "개");
        System.out.println("4개 일치 (50,000원) - " + four + "개");
        System.out.println("5개 일치 (1,500,000원) - " + five + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + six + "개");

        System.out.println("총 수익률은 " + String.format("%.2f", total) + "%입니다.");

    }
}
