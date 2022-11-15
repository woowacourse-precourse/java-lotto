package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Computer {

    private static final int PERCENT = 100;

    private static final List<List<Integer>> AUTO_LOTTOS = new ArrayList<>();
    private static final List<Integer> WINNING_NUMBERS = new ArrayList<>();
    private static String YIELD;

    public Computer(long lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(Resource.MIN_LOTTO_NUMBER, Resource.MAX_LOTTO_NUMBER, Resource.LOTTO_SIZE);
            List<Integer> copyOfLotto = new ArrayList<>();

            for (Integer lottoNumber : lotto) {
                copyOfLotto.add(lottoNumber);
            }

            Collections.sort(copyOfLotto);
            AUTO_LOTTOS.add(copyOfLotto);
        }
    }

    public static List<List<Integer>> getAutoLottos() {
        return AUTO_LOTTOS;
    }

    public static List<Integer> getWinningNumbers() {
        return WINNING_NUMBERS;
    }

    public static String getYIELD() {
        return YIELD;
    }

    public void makeWinningNumbers(String userInput) {
        List<String> userInputs = Arrays.asList(userInput.split(Resource.SEPARATOR));
        for (String userNumber : userInputs) {
            WINNING_NUMBERS.add(Integer.parseInt(userNumber));
        }
    }

    public void checkWining(int bonusNumber) {
        for (List<Integer> autoLotto : AUTO_LOTTOS) {
            int win = countWin(autoLotto);
            int bonusWin = 0;

            if (autoLotto.contains(bonusNumber)) {
                bonusWin++;
            }
            countWinningResult(win, bonusWin);
        }
    }

    private int countWin(List<Integer> autoLotto) {
        int win = 0;
        for (int winningNumber : WINNING_NUMBERS) {
            if (autoLotto.contains(winningNumber)) {
                win++;
            }
        }
        return win;
    }

    private void countWinningResult(int win, int bonusWin) {
        if (win == Rank.FIRST.getWin()) Rank.FIRST.plusCount();
        if (win == Rank.SECOND.getWin() && bonusWin == Rank.SECOND.getBonusWin()) Rank.SECOND.plusCount();
        if (win == Rank.THIRD.getWin() && bonusWin == Rank.THIRD.getBonusWin()) Rank.THIRD.plusCount();
        if (win == Rank.FOURTH.getWin()) Rank.FOURTH.plusCount();
        if (win == Rank.FIFTH.getWin()) Rank.FIFTH.plusCount();
    }

    public void yieldCalculation(long inputMoney) {
        long yield = Rank.FIRST.getCount() * Rank.FIRST.getMoney() + Rank.SECOND.getCount() * Rank.SECOND.getMoney() + Rank.THIRD.getCount() * Rank.THIRD.getMoney()
                + Rank.FOURTH.getCount() * Rank.FOURTH.getMoney() + Rank.FIFTH.getCount() * Rank.FIFTH.getMoney();
        YIELD = String.format("%.1f", yield / (double) inputMoney * PERCENT);
    }
}
