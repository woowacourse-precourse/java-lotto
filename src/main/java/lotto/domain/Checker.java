package lotto.domain;

import java.util.ArrayList;
import java.util.List;

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
    private List<Integer> winningStats = new ArrayList<>();
    private int bonusNumber;
    private int count;
    private float returnRate;

    public void insertWinningNumbers() {

    }

    public void insertBonusNumber() {

    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void checkMyLotto(List<List<Integer>> lottos) {

    }

    public void showWinningStats() {

    }

    public float calculateRateOfReturn() {
        return returnRate;
    }



}
