package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class View {

    public void printAmountInput() {
        System.out.println(GameConstant.START.getValue());
    }

    public int getAmount() {
        String input;

        input = Console.readLine();

        try {
            validateAmountInput(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }

        return Integer.parseInt(input);
    }

    public int getBonusNumber() {
        String number;

        number = Console.readLine();
        validateBonusNumber(number);

        return Integer.parseInt(number);
    }

    public List<Integer> getWinningNumber() {
        List<Integer> winningNumber;
        String[] commaSeparate;
        String input;

        input = Console.readLine();
        commaSeparate = input.split(",");
        validateWinningNumber(Arrays.asList(commaSeparate));

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

    public void validateAmountInput(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(GameConstant.TYPE_EXCEPTION.getValue());
        }

        if (isDivisible(input)) {
            throw new IllegalArgumentException(GameConstant.DIVISIBLE_EXCEPTION.getValue());
        }
    }

    public void validateWinningNumber(List<String> numbers) {
        for (String element : numbers) {
            if (!isInteger(element)) {
                throw new IllegalArgumentException(GameConstant.TYPE_EXCEPTION.getValue());
            }

            if (checkBoundary(element)) {
                throw new IllegalArgumentException(GameConstant.BOUNDARY_EXCEPTION.getValue());
            }
        }
    }

    public void validateBonusNumber(String number) {
        if (!isInteger(number)) {
            throw new IllegalArgumentException(GameConstant.TYPE_EXCEPTION.getValue());
        }

        if (checkBoundary(number)) {
            throw new IllegalArgumentException(GameConstant.BOUNDARY_EXCEPTION.getValue());
        }
    }

    public boolean checkBoundary(String input) {
        return Integer.parseInt(input) < 1 || Integer.parseInt(input) > 45;
    }

    public boolean isDivisible(String input) {
        return (Integer.parseInt(input) % 1000 != 0);
    }

    public boolean isInteger(String input) {
        return input.matches("[0-9.]+");
    }

}
