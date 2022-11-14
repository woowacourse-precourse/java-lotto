package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int UNIT = 1000;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int BALL_COUNT = 6;
    List<Integer> lottoNumbers = new ArrayList<>();
    List<List<Integer>> buyNumbers = new ArrayList<>();
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

    public int compareNumbers(List<Integer> numbers, List<Integer> predictedNumbers) {
        return 0;
    }

    public List<Integer> generateNumbers(int count) {
        return lottoNumbers;
    }
}
