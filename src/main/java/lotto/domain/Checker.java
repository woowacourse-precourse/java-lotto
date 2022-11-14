package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Checker {

    private static final String INSERT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INSERT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATS = "당첨 통계";
    private static final String THREE_WINNING = "3개 일치 (5,000원) - ";
    private static final String FOUR_WINNING = "4개 일치 (50,000원) - ";
    private static final String FIVE_WINNING = "5개 일치 (1,500,000원)";
    private static final String FIVE_WINNING_ONE_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    private static final String SIX_WINNING = "6개 일치 (2,000,000,000원)";
    private static final String SHOW_RETURN_RATE_FRONT = "총 수익률은 ";
    private static final String SHOW_RETURN_RATE_BACK = "입니다.";

    private List<Integer> winningNumbers = new ArrayList<>();
    private HashMap<Integer, Integer> winningStats = new HashMap<>() {{
        put(3, 0);
        put(4, 0);
        put(5, 0);
        put(6, 0);
    }};
    private int bonusNumber;
    private int key;
    private float returnRate;

    public Checker() {
        winningNumbers = new ArrayList<>();

    }

    public void insertWinningNumbers() {
        System.out.println(INSERT_WINNING_NUMBER);

        String winningNumber = Console.readLine();
        int[] numbers = Arrays.stream(winningNumber.split(",")).mapToInt(Integer::parseInt).toArray();
        for (int number : numbers) {
            winningNumbers.add(number);
        }
    }

    public void insertBonusNumber() {
        System.out.println(INSERT_BONUS_NUMBER);
        bonusNumber = Integer.parseInt(Console.readLine());
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void checkMyLotto(List<Integer> lotto) {

        int oldCount;

        key = 0;

        checkWinningNumber(lotto);

        if (key == 5) { // 당첨 번호가 5개 동일하면 보너스 번호 당첨 여부 확인
            checkBonusNumber(lotto);
        }

        if (winningStats.containsKey(key)) {
            oldCount = winningStats.get(key);
            winningStats.replace(key, oldCount, oldCount + 1);
        }

    }

    private void checkWinningNumber(List<Integer> lotto) {
        for (int number : winningNumbers) {
            if (lotto.contains(number)) {
                key++;
            }
        }
    }

    private void checkBonusNumber(List<Integer> lotto) {
        if (lotto.contains(bonusNumber)) {
            key++;
        }
    }

    public HashMap<Integer, Integer> getWinningStats() {
        return winningStats;
    }

    public void showWinningStats() {

    }

    public float calculateRateOfReturn() {
        return returnRate;
    }


}
