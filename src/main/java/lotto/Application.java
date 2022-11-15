package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        try {
            processLottoProgram();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e);
        }
    }

    private static void processLottoProgram() {
        int price = handlePriceTasks();
        List<Lotto> lottos = handleLottosTasks(price);

        List<Integer> winningNums = handleWinningNumsTasks();
        int bonusNum = handleBonusNumTasks(winningNums);

        Map<Result, Integer> winningData = Utils.getAllResults(lottos, winningNums, bonusNum);
        String profitRate = Utils.getRatioOfProfit(price);

        Ui.printStatistics(profitRate, winningData);
    }

    private static int handlePriceTasks() throws IllegalArgumentException {
        Ui.printMsgToGetInput("구입 금액을");

        int price = Utils.stringToInt(Console.readLine());
        Validation.validatePrice(price);
        return price;
    }

    public static List<Lotto> handleLottosTasks(int price) {
        int numberOfIssues = Utils.getNumberOfIssues(price);
        List<Lotto> lottos = Utils.issueLotto(numberOfIssues);

        Ui.printLottoNumbers(numberOfIssues, lottos);
        return lottos;
    }

    private static List<Integer> handleWinningNumsTasks() throws IllegalArgumentException {
        Ui.printMsgToGetInput("당첨 번호를");

        String[] splinted = Utils.splitInput(Console.readLine());
        List<Integer> winningNums = Utils.stringArrToIntegerList(splinted);
        Validation.validateWinningNums(winningNums);
        return winningNums;
    }

    private static int handleBonusNumTasks(List<Integer> winningNums) throws IllegalArgumentException {
        Ui.printMsgToGetInput("보너스 번호를");

        int bonus = Utils.stringToInt(Console.readLine());
        Validation.validateBonusNumber(bonus, winningNums);
        return bonus;
    }

}
