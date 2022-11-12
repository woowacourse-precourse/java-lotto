package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int money = Integer.parseInt(Console.readLine());
        moneyInputError(money);
        List<Lotto> lotto = new ArrayList<>();
        buyLotto(money, lotto);
        printLotto(lotto);
        List<Integer> winNums = winNumInput();
        int bonusNum = bonusNumInput();
        List<Result> results = new ArrayList<>();

    }

    public static void moneyInputError(int money) {
        if (money % 1000 != 0) {
            System.out.println("금액 입력 오류입니다.");
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> winNumInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winNums = new ArrayList<>();
        String[] tmpNums = Console.readLine().split(",");
        for (String e : tmpNums)
            winNums.add(Integer.parseInt(e));
        return winNums;
    }

    public static Integer bonusNumInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        return bonus;
    }

    public static void buyLotto(int money, List<Lotto> lotto) {
        int lottoQTY = money / 1000;
        for (int i = 0; i < lottoQTY; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto.add(new Lotto(numbers));
        }
    }

    public static void printLotto(List<Lotto> lotto) {
        System.out.println(lotto.size() + "개를 구매했습니다.");
        for (Lotto e : lotto)
            e.printNumbers();
    }

    public static void PrintEnd(Result result){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000)원 - ~개");
        System.out.println("4개 일치 (50,000)원 - ~개");
        System.out.println("5개 일치 (1,500,000)원 - ~개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000)원 - ~개");
        System.out.println("6개 일치 (2,000,000,000원) - ~개");
        System.out.println("총 수익률은 ~~입니다.");
    }

}
