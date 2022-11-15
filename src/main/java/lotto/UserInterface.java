package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInterface {
    Validation validation = new Validation();

    public int getPrice() {
        int price = Integer.parseInt(Console.readLine());
        validation.isValidPrice(price);
        return price;
    }

    public List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        validation.isValidWinningNumbersInput(input);
        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validation.isValidWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    public int getBonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }
}
