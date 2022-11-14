package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
            int lotteryQuantity = budget / PRICE_PER_LOTTERY;

            List<List<Integer>> lotteries = lotteriesUI(lotteryQuantity);



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

    private static List<List<Integer>> lotteriesUI(int lotteryQuantity) {
        System.out.println(lotteryQuantity + Messages.BOUGHT.getMessage());

        List<List<Integer>> lotteries = Lotto.generateLotteries(lotteryQuantity);

        printLotteries(lotteries);

        return lotteries;
    }

    public static void printLotteries(List<List<Integer>> lotteries) {
        for (List<Integer> lottery : lotteries) {
            String ticket = String.join(
                    Messages.DELIMITER.getMessage() + " ",
                    lottery.stream()
                            .map(number -> number.toString())
                            .collect(Collectors.toList()));

            System.out.println("[" + ticket + "]");
        }
    }

    private static List<Integer> jackpotUI() {
        System.out.println(Messages.JACKPOT.getMessage());
        String jackpotFigure = readLine();

        validateJackpot(jackpotFigure);

        List<Integer> jackpot = convertJackpotStringToList(jackpotFigure);
        Collections.sort(jackpot);

        new Lotto(jackpot);

        return jackpot;
    }

    private static List<Integer> convertJackpotStringToList(String jackpotFigure) {
        List<Integer> result = new ArrayList<>();
        List<String> jackpotNumbers = Arrays.asList(jackpotFigure.split(Messages.DELIMITER.getMessage()));

        for (String jackpotNumber : jackpotNumbers) {
            result.add(Integer.valueOf(jackpotNumber));
        }

        return result;
    }
}
