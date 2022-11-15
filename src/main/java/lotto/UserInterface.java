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

    }

    public int getBonusNumber() {

    }
}
