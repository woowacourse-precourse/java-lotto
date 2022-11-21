package lotto.controller;

import static lotto.controller.UserController.PRICE;

import java.util.List;
import lotto.view.ExceptionHandlerUI;

public class ExceptionHandler {


    private static final String excMessageAboutRange = "1에서 45 사이의 수만 입력 가능합니다.";
    private static final String excMessageAboutLenght = "6자리 수여야 합니다.";

    private static final String excMessageAboutDupplication = "중복된 값은 입력할 수 없습니다.";
    private static final String excMessageAboutWinningForm =  "쉼표로 구분된 6개의 수만 입력 가능합니다.";

    private static final String excMessageAboutPurchaseForm = "1000원 단위로만 구입이 가능합니다.";

    private static final String excMessageAboutInt = "정수 이외의 값은 입력할 수 없습니다.";

    private static ExceptionHandlerUI view = new ExceptionHandlerUI();
    public static void validNumberRange(int num){
        if(num < 1 || num > 45){
            throw new IllegalArgumentException(excMessageAboutRange);
        }
    }

    public static void validNumbersLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(excMessageAboutLenght);
        }
    }


    public static void validWinningDupplication(int newNumber, List<Integer> numbers){
        validNumbersDupplication(numbers);

        if(numbers.contains(newNumber)){
            throw new IllegalArgumentException(excMessageAboutDupplication);
        } // 보너스 번호 중복 체크
    }

    public static void validNumbersDupplication(List<Integer> numbers){
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(excMessageAboutDupplication);
        } // 당첨 번호 중복 체크
    }

    public static void validWinningForm(String readline){
        String[] numbers = readline.split(",");
        if(numbers.length != 6){
            throw new IllegalArgumentException(excMessageAboutWinningForm);
        }
    }

    public static void validPurchaseForm(String readline){
        int amount = excParseInt(readline);
        if(amount%PRICE != 0){
            throw new IllegalArgumentException(excMessageAboutPurchaseForm);
        }
    }

    public static Integer excParseInt(String input) {
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException( excMessageAboutInt);
        }
    }

    public void printErrorMessage(IllegalArgumentException e){
        view.printErrorMessage(e.getMessage());
    }
}
