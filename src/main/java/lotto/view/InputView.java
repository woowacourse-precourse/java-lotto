package lotto.view;

import java.util.Scanner;

import static lotto.utils.Validator.validateInteger;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    public int printWriteBudget(){
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = SCANNER.nextLine();

        validateInteger(userInput);

        return Integer.valueOf(userInput);
    }
}
