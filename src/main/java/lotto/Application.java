package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        processLottoProgram();
    }

    private static void processLottoProgram() {
        try {
            int price = handlePriceTasks();
            List<Lotto> lottos = handleLottosTasks(price);

            List<Integer> winningNums = handleWinningNumsTasks();
            int bonusNum = handleBonusNumTasks(winningNums);

            Map<Result, Integer> winningData = Utils.getAllResults(lottos, winningNums, bonusNum);
            String profitRate = Utils.getRatioOfProfit(price);
            Ui.printStatistics(profitRate, winningData);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e);
        }
    }

    private static int handlePriceTasks() throws IllegalArgumentException {
        Ui.printMsgToGetPrice();
        int price = Utils.stringToInt(Console.readLine());
        Validation.validatePrice(price);
        return price;
    }

    private static List<Lotto> handleLottosTasks(int price) {
        int numberOfIssues = Utils.getNumberOfIssues(price);
        List<Lotto> lottos = Utils.issueLotto(numberOfIssues);
        Ui.printLottoNumbers(numberOfIssues, lottos);
        return lottos;
    }

    private static List<Integer> handleWinningNumsTasks() throws IllegalArgumentException {
        Ui.printMsgToGetWinningNums();
        String[] splinted = Utils.splitInput(Console.readLine());
        List<Integer> winningNums = Utils.stringArrToIntegerList(splinted);
        Validation.validateWinningNums(winningNums);
        return winningNums;
    }

    private static int handleBonusNumTasks(List<Integer> winningNums) throws IllegalArgumentException {
        Ui.printMsgToGetBonusNum();
        int bonus = Utils.stringToInt(Console.readLine());
        Validation.validateBonusNumber(bonus, winningNums);
        return bonus;
    }

}
