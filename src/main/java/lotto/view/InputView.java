package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String TYPE_ERROR = "숫자만 입력 가능합니다.";
    private static final String BLANK = " ";
    private static final String EMPTY_STRING = "";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

   public static int inputAmount() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return convertToInt(scanner.nextLine());
   }

   public static String inputWinningNumbers1() {
        System.out.println(INPUT_WINNING_NUMBERS);
        return reduceBlank(scanner.nextLine());
    }

	private static String reduceBlank(String input) {
        return input.replaceAll(BLANK, EMPTY_STRING);
    }


    public static int inputBonusBall() {
        System.out.println(INPUT_BONUS_NUMBER);
        String input = scanner.nextLine();
        return convertToInt(input);
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
    }

	public static String inputWinningNumbers() {
		// TODO Auto-generated method stub
		return null;
	}

}