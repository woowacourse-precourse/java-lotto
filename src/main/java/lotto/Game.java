package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Game {
    public static final int UNIT = 1000;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int BALL_COUNT = 6;
    List<Integer> lottoNumbers = new ArrayList<>();
    List<List<Integer>> buyingNumbers = new ArrayList<>();
    private int bonus;

    public void setWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] numbers = Console.readLine().split(",");
        for (String number : numbers) {
            if (!isNumeric(number)) {
                throw new IllegalArgumentException("[ERROR] 정수만 입력해주세요.");
            }
            lottoNumbers.add(Integer.parseInt(number));
        }
    }

    private boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public void setBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String number = Console.readLine();
        if (!isNumeric(number)) {
            throw new IllegalArgumentException("[ERROR] 정수 1개만 입력해주세요.");
        }
        bonus = Integer.parseInt(number);
    }

    public List<Integer> getWinningNumbers() {
        return lottoNumbers;
    }

    public int getBonus() {
        return bonus;
    }

    public int buy() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        if (money % UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] " + UNIT + "원 단위 금액을 입력해주세요.");
        }
        return money / UNIT;
    }

    public List<List<Integer>> generateNumbers(int count) {
        for (int index=0; index < count; index++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, BALL_COUNT);
            Collections.sort(numbers);
            buyingNumbers.add(numbers);
        }
        return buyingNumbers;
    }

    public List<Integer> compareNumbers(List<Integer> predictedNumbers) {
        List<Integer> sameNumbers = new ArrayList<>();
        List<Integer> winGames = new ArrayList<>();
        for (List<Integer> numbers : buyingNumbers) {
            sameNumbers = numbers.stream().filter(number -> predictedNumbers.stream()
                    .anyMatch(Predicate.isEqual(number)))
                    .collect(Collectors.toList());
            int size = sameNumbers.size();
            winGames.add(size);
        }
        return sameNumbers;
    }
}
