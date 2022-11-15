package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Input {
    public String getPrice() {
        System.out.println(InputMessage.PURCHASE_AMOUNT.print());
        return Console.readLine();
    }

    public String printNext(String price){
        if(!price.matches("^[0-9]*$")){
            return "[ERROR] Only enter numbers.";
        }
        return price;
    }

    public static List<Integer> getWinningNumber() {
        System.out.println(System.lineSeparator() + InputMessage.WINNING_NUMBER.print());
        return stringToList(Console.readLine());
    }

    public static List<Integer> getBonusNumber() {
        System.out.println(System.lineSeparator() + InputMessage.BONUS_NUMBER.print());
        return stringToList(Console.readLine());
    }

    private static List<Integer> stringToList(String numbers) {
        try {
            return Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(toList());
        } catch (Exception e) {
            System.out.println("[ERROR] Only enter numbers.");
            throw new IllegalArgumentException("[ERROR] Only enter numbers.");
        }
    }
}