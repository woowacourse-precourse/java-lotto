package lotto.domain;

import static lotto.Config.WINNING_RANK_AMOUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.Score;
import lotto.utils.Logger;
import lotto.utils.Logger.LogType;

public class Controller {
    private static final String NUMERIC_STRING_ERROR_MESSAGE = "숫자 형식으로 입력해 주세요.";
    private static final String DIVISIBLE_THOUSAND_ERROR_MESSAGE = "구입 금액은 1,000으로 나누어 떨어져야 합니다.";

    private static Controller instance;

    private final UahanBank uahanBank;

    private Controller() {
        uahanBank = new UahanBank();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void run() {
    }

    private int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String numericString = Console.readLine();
        return formatStringToNumber(numericString);
    }

    private int formatStringToNumber(String numericString) {
        checkNumericString(numericString);
        int number = Integer.parseInt(numericString);
        checkDivisibleThousand(number);

        return number;
    }

    private void checkNumericString(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            Logger.log(NUMERIC_STRING_ERROR_MESSAGE, LogType.ERROR);
            throw new IllegalArgumentException();
        }
    }

    private void checkDivisibleThousand(int number) {
        if (number % 1000 != 0) {
            Logger.log(DIVISIBLE_THOUSAND_ERROR_MESSAGE, LogType.ERROR);
            throw new IllegalArgumentException();
        }
    }

    private void printPublishedLotto(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
    }

    private int calculateWonLotto(List<Lotto> lottos, Lotto wonLotto, List<Integer> bonusLotto) {
        return 0;
    }

    private int changeMoneyToRank(int money){
        int rank = 0;

        for(; rank < WINNING_RANK_AMOUNT.length; rank++){
            if(money == WINNING_RANK_AMOUNT[rank]){
                break;
            }
        }

        return rank;
    }

    private void printWonLotto(List<Integer> rankCounts) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for(int index = WINNING_RANK_AMOUNT.length - 1; index >= 0; index--){
            StringBuilder message = new StringBuilder();
            Score score = uahanBank.rankScores.get(index);

            message.append(score.winningNumberCount + "개 일치");
            if(score.bonusNumberCount == 1){
                message.append(", 보너스 볼 일치");
            }
            if(score.bonusNumberCount > 1){
                message.append(", 보너스 볼" + score.bonusNumberCount + "개 일치");
            }
            message.append(" (" + WINNING_RANK_AMOUNT[index] + "원) - " + rankCounts.get(index) + "개");
        }
    }

    private void printYield(double loss, double profit) {
        double yield = 0.0;
        if(profit > 0){
            yield = profit / loss * 100.0;
        }

        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }
}
