package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class View {
    private UserInputValidator validator = new UserInputValidator();

    public void printAmountInput() {
        System.out.println(GameConstant.START.getValue());
    }

    public int getAmount() {
        String input;

        input = Console.readLine();

        try {
            validator.validateAmountInput(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }

        return Integer.parseInt(input);
    }

    public int getBonusNumber() {
        String number;

        number = Console.readLine();
        validator.validateBonusNumber(number);

        return Integer.parseInt(number);
    }

    public List<Integer> getWinningNumber() {
        List<Integer> winningNumber;
        String[] commaSeparate;
        String input;

        input = Console.readLine();
        commaSeparate = input.split(",");
        validator.validateWinningNumber(Arrays.asList(commaSeparate));

        winningNumber = Arrays.stream(commaSeparate)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningNumber;
    }

    public void printNumberOfLotto(int number) {
        System.out.println(number + GameConstant.NUMBER_OF_GAME.getValue());
    }

    public void printEachLotto(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        System.out.println(sortedNumbers);
    }

    public void printGetWinningNumber() {
        System.out.println(GameConstant.GET_WINNING_NUMBER.getValue());
    }

    public void printGetBonusNumber() {
        System.out.println(GameConstant.GET_BONUS_NUMBER.getValue());
    }

    public void printPrize(HashMap<String, Integer> prize) {
        System.out.println(GameConstant.WIN_STATISTIC.getValue());
        System.out.println("---");
        System.out.println(GameConstant.HIT_THREE.getValue() + prize.get("fifth") + "개");
        System.out.println(GameConstant.HIT_FOUR.getValue() + prize.get("fourth") + "개");
        System.out.println(GameConstant.HIT_FIVE_NO_BONUS.getValue() + prize.get("third") + "개");
        System.out.println(GameConstant.HIT_FIVE_WITH_BONUS.getValue() + prize.get("second") + "개");
        System.out.println(GameConstant.HIT_SIX.getValue() + prize.get("first") + "개");
    }

    public void printYield(HashMap<String, Integer> prize, int amount) {
        double lottoReturn = ((double)prize.get("totalPrize") / amount) * 100;

        System.out.println("총 수익률은 "+ String.format("%.1f", lottoReturn) + "%입니다.");
    }

}
