package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class DataInput {
    private static final String VALID_INPUT_PATTERN = "[^0-9]";
    private static final String VALID_FORMAT_PATTERN = "[^0-9,]";
    private static final String ERROR_MESSAGE_NUMBER = "[ERROR] 숫자를 입력해주세요";
    private static final String ERROR_MESSAGE_UNIT = "[ERROR] 1000원 단위로 입력해주세요";
    private static final String ERROR_MESSAGE_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자를 입력해주세요";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] 당청 번호 형식에 맞게 입력해주세요";
    private static final String ERROR_MESSAGE_DUPLICATE = "[ERROR] 보너스 번호와 당첨 번호가 중복입니다.";
    private static final int MAXIMUM_NUMBER_OF_LOTTO = 45;
    private static final int MINIMUM_NUMBER_OF_LOTTO = 1;
    private static final String MESSAGE_TO_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_TO_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String MESSAGE_TO_INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";

    public static int PurchaseAmount() {
        String input = UserInput(MESSAGE_TO_INPUT_PURCHASE_AMOUNT);
        ValidateNumber(input);
        ValidateAmountUnit(input);

        return Integer.parseInt(input) / 1000;
    }

    public static int BonusNumber(List<Integer> winningNumber) {
        String input = UserInput(MESSAGE_TO_INPUT_BONUS_NUMBER);
        ValidateNumber(input);
        int bonusNumber = ValidateRange(input);
        ValidateWinningAndBonusNumber(winningNumber, bonusNumber);

        return bonusNumber;
    }

    public static List<Integer> WinningNumber() {
        String input = UserInput(MESSAGE_TO_INPUT_WINNING_NUMBER);
        ValidateFormat(input);

        return StringToList(input);
    }


    public static String UserInput(String Message) {
        System.out.println(Message);
        String input = Console.readLine();
        input = input.replaceAll("\\s+","");
        return input;
    }

    private static void ValidateNumber(String input) {
        if (input.matches(VALID_INPUT_PATTERN)) {
            System.out.println(ERROR_MESSAGE_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    private static void ValidateAmountUnit(String input) {
        if(input.length() < 4){
            System.out.println(ERROR_MESSAGE_UNIT);
            throw new IllegalArgumentException();
        }

        if (!input.substring(input.length()-3, input.length()).equals("000")) {
            System.out.println(ERROR_MESSAGE_UNIT);
            throw new IllegalArgumentException();
        }
    }

    private static int ValidateRange(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < MINIMUM_NUMBER_OF_LOTTO || bonusNumber > MAXIMUM_NUMBER_OF_LOTTO) {
            System.out.println(ERROR_MESSAGE_RANGE);
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

    private static void ValidateFormat(String input) {
        if(input.matches(VALID_FORMAT_PATTERN)){
            System.out.println(ERROR_MESSAGE_FORMAT);
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> StringToList(String input) {
        String[] convert = input.split(",");
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < convert.length; i++){
            result.add(Integer.parseInt(convert[i]));
        }
        return result;
    }

    private static void ValidateWinningAndBonusNumber(List<Integer> winningNumber, int bonusNumber) {
        if(winningNumber.contains(bonusNumber)){
            System.out.println(ERROR_MESSAGE_FORMAT);
            throw new IllegalArgumentException();
        }
    }
}
