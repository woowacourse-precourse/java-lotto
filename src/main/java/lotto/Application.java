package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    static List<Lotto> lottos = new ArrayList<>();
    static List<Integer> winningNumber = new ArrayList<>();
    static int bonusNumber;

    public static void main(String[] args) {
        try {
            purchaseLotto(Integer.parseInt(Console.readLine()));
            printLotto();
            inputWinningNumber(Console.readLine());
            inputBonusNumber(Console.readLine());
            // TODO: 1등부터 5등까지 몇개나 당첨되었는지 출력
            // TODO: 수익률을 소수점 둘째 자리에서 반올림하여 출력
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]invalid input: 천원단위 입력이 아닙니다.");
        }
    }

    private static void inputBonusNumber(String input) {
        bonusNumber = Integer.parseInt(input);
        checkInputRange(input);
    }

    private static void inputWinningNumber(String input) {
        String str[] = input.split(",");
        checkInputCount(str);
        for (int i = 0; i < str.length; i++) {
            checkInputRange(str[i]);
            winningNumber.add(i, Integer.parseInt(str[i]));
        }
    }

    private static void checkInputCount(String[] str) {
        if (str.length != 6)
            throw new IllegalArgumentException("[ERROR]invalid input: 6개의 값을 입력해주세요.");
    }

    private static void checkInputRange(String str) {
        if ((Integer.parseInt(str) < 1 || Integer.parseInt(str) > 45))
            throw new IllegalArgumentException("[ERROR]invalid input: 1과 45 사이의 값을 입력해주세요.");
    }

    private static void printLotto() {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (int i = 0; i < lottos.size(); i++)
            System.out.println(lottos.get(i).getNumbers());
    }

    private static void purchaseLotto(int money) {
        int lottoCount = money / 1000;
        for (int i = 0; i < lottoCount; i++)
            lottos.add(quickPicks());
    }

    private static Lotto quickPicks() {
        Lotto lotto = new Lotto(generateNumbers());
        return lotto;
    }

    private static List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortNumbers(numbers);
        return numbers;
    }

    private static void sortNumbers(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
    }
}
