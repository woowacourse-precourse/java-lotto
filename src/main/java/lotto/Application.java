package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Validators.*;

public class Application {
    private enum Messages {
        DELIMITER(","),
        BUDGET("구입금액을 입력해 주세요."),
        BOUGHT("개를 구매했습니다."),
        JACKPOT("당첨 번호를 입력해 주세요."),
        BONUS("보너스 번호를 입력해 주세요."),
        RESULT("당첨 통계%n---%n"),
        FIRST("6개 일치 (2,000,000,000원) - %d개%n"),
        SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n"),
        THIRD("5개 일치 (1,500,000원) - %d개%n"),
        FOURTH("4개 일치 (50,000원) - %d개%n"),
        FIFTH("3개 일치 (5,000원) - %d개%n"),
        RATE("총 수익률은 %.1f%%입니다."),
        EXCEPTION_HEADER("[ERROR] ");

        private final String message;

        Messages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    private final static int PRICE_PER_LOTTERY = 1000;

    public static void main(String[] args) {
        try {
            int budget = budgetUI();


        } catch (IllegalArgumentException e) {
            System.out.println(Messages.EXCEPTION_HEADER.getMessage() + e.getMessage());
        }
    }

    private static int budgetUI() {
        System.out.println(Messages.BUDGET.getMessage());
        String budgetFigure = readLine();

        validateBudget(budgetFigure);

        int budget = Integer.parseInt(budgetFigure);
        return budget;
    }
}
