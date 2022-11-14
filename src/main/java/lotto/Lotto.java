package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        isCorrectSize(numbers);
        isDuplicated(numbers);
        this.numbers = numbers;
    }

    private void isCorrectSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리의 숫자를 입력해야 합니다.");
        }
    }

    private void isDuplicated(List<Integer> numbers) {
        Set<Integer> duplicated = new HashSet<>(numbers);

        if (duplicated.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public static Lotto generateLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedLotto = lotto.stream().sorted().collect(Collectors.toList());

        return new Lotto(sortedLotto);
    }

    public static List<Lotto> buyMyLottos(int count) {
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> buyLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            buyLottos.add(Lotto.generateLotto());
        }

        for (Lotto buyLotto : buyLottos) {
            buyLotto.printLotto();
        }
        return buyLottos;
    }

    public void printLotto() {
        System.out.println(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Winning checkLotto(Lotto lotto, int bonus) {
        int count = 0;
        List<Integer> lottoNumber = lotto.getNumbers();
        boolean isBonus = lottoNumber.contains(bonus);

        for (Integer number : lottoNumber) {
            if (numbers.contains(number)) {
                count++;
            }
        }

        return calculatePrize(count, isBonus);
    }

    public static Winning calculatePrize(int count, boolean isBonus) {
        if (count == 6) {
            return Winning.SIX;
        } else if (count == 5) {
            if (isBonus) {
                return Winning.FIVE_WITH_BONUS;
            }
            return Winning.FIVE;
        } else if (count == 4) {
            return Winning.FOUR;
        } else if (count == 3) {
            return Winning.THREE;
        }
        return Winning.NONE;
    }

    public static long totalPrize(List<Integer> win) {
        long total = 0;
        List<Integer> prize = Arrays.asList(0, 2_000_000_000, 30_000_000, 1_500_000, 50000, 5000);
        for (int i = 1; i < 6; i++) {
            total += ((long) win.get(i) * prize.get(i));
        }

        return total;
    }

    public static void printWin(List<Integer> win) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Winning winning : Winning.values()) {
            if (winning != Winning.NONE) {
                System.out.println(
                        winning.getMatch() + " " + winning.getValue() + " - " + win.get(winning.getRank()) + "개");
            }
        }
    }

    public static String caculateProfit(List<Integer> win, int cost) {
        long total = totalPrize(win);
        double profit = total / (double) cost * 100;

        DecimalFormat format = new DecimalFormat("0.##");
        String result = format.format(profit);
        System.out.print("총 수익률은 " + result + "%입니다.");

        return result;
    }
}
