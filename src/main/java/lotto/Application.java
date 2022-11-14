package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    static final int PRICE_PER_LOTTO=1000;


    static List<Lotto> lottos = new ArrayList<>();
    static List<Integer> winningNumber = new ArrayList<>();
    static List<Integer> rankStat = Arrays.asList(0, 0, 0, 0, 0, 0);
    static int bonusNumber;

    public static void main(String[] args) {
        try {
            purchaseLotto(Integer.parseInt(Console.readLine()));
            printLotto();
            inputWinningNumber(Console.readLine());
            inputBonusNumber(Console.readLine());
            drawLots();
            // TODO: 수익률을 소수점 둘째 자리에서 반올림하여 출력
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]invalid input: 천원단위 입력이 아닙니다.");
        }
    }

    private static void drawLots() {
        for (int i = 0; i < lottos.size(); i++) {
            if (isBonusMatches(lottos.get(i).getNumbers())
                    && Rank.getRank(countMatches(lottos.get(i).getNumbers())).ordinal() == 1) {
                rankStat.set(Rank.second.ordinal(), rankStat.get(Rank.second.ordinal()) + 1);
                continue;
            }
            rankStat.set(Rank.getRank(countMatches(lottos.get(i).getNumbers())).ordinal(),
                    rankStat.get(Rank.getRank(countMatches(lottos.get(i).getNumbers())).ordinal()) + 1);
        }
    }

    private static boolean isBonusMatches(List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) return true;
        return false;
    }

    private static int countMatches(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>(numbers);
        list.retainAll(winningNumber);
        return list.size();
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
        for (int i = 0; i < lottos.size(); i++) {
            lottos.get(i).getNumbers().sort(Integer::compareTo);
            System.out.println(lottos.get(i).getNumbers());
        }

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
        return numbers;
    }

    private static void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
