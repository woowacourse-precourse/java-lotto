package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Lotto> Lottos = new ArrayList<>();

    public static void main(String[] args) {
        try {
            purchaseLotto(Integer.parseInt(Console.readLine()));
            printLotto();

            // TODO: 당첨 번호 입력
            // TODO: 보너스 번호 입력
            // TODO: 1등부터 5등까지 몇개나 당첨되었는지 출력
            // TODO: 수익률을 소수점 둘째 자리에서 반올림하여 출력
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]invalid input: 천원단위 입력이 아닙니다.");
        }
    }

    private static void printLotto() {
        System.out.println(Lottos.size()+"개를 구매했습니다.");
        for (int i = 0; i < Lottos.size(); i++)
            System.out.println(Lottos.get(i).getNumbers());
    }

    private static void purchaseLotto(int money) {
        int lottoCount = money / 1000;
        for (int i = 0; i < lottoCount; i++)
            Lottos.add(quickPicks());
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
