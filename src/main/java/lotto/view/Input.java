package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private static final String ERROR_CODE = "[ERROR] ";

    public static int purchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        int price = convertToInteger(Console.readLine());
        validatePrice(price);
        System.out.println(price);

        return price;
    }

    public static List<Integer> enterWinNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println(input);
        return convertToList(input);
    }

    public static int enterBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNum = convertToInteger(Console.readLine());
        System.out.println(bonusNum);
        return bonusNum;
    }

    public static void validatePrice(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_CODE + "구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public static List<Integer> convertToList(String input) {
        String[] str = input.split(",");
        // TODO: exception handler
        if (str.length != 6) {
            throw new IllegalArgumentException();
        }
        List<Integer> numbers = new ArrayList<>();
        for (String s : str) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

    public static int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_CODE + "입력된 값이 숫자가 아닙니다.");
        }
    }

}