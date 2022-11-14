package lotto.view;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lotto.utils.Validator.*;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static int writeBudget(){
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = SCANNER.nextLine();

        validateInteger(userInput);
        validateBudget(Integer.valueOf(userInput));

        return Integer.valueOf(userInput);
    }

    public static List<String> writeWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = SCANNER.nextLine();

        List<String> splitInput = splitWinningNumbers(userInput);

        validateWinningNumbers(splitInput);

        System.out.println();

        return splitInput;
    }

    public static int writeBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = SCANNER.nextLine();

        validateInteger(userInput);

        System.out.println();

        return Integer.valueOf(userInput);
    }

    private static List<String> splitWinningNumbers(String userInput){
        List<String> result = new ArrayList<>();

        for (String input : userInput.split(",")){
            result.add(input);
        }

        return result;
    }

}
