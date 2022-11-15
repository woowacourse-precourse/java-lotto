package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class IOController {

    public static int readBuyingMoney() {
        String input = Console.readLine();
        int buyingMoney;
        try {
            buyingMoney = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자입니다.");
        }
        if (buyingMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위입니다.");
        }
        return buyingMoney / 1000;
    }

    public static List<Integer> readWinningNumbers() throws IllegalArgumentException {
        String input = Console.readLine();
        String pattern = "^([1-9]?[0-9],){5}[1-9]?[0-9]$";
        if (!Pattern.matches(pattern, input)) {
            throw new IllegalArgumentException("[ERROR] 쉼표로 구분된 6개의 숫자를 입력해야 합니다.");
        }
        String[] splitedInputs = input.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String splitedInput : splitedInputs) {
            int lottoNumber = Integer.parseInt(splitedInput);
            validateNumberRange(lottoNumber);
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

    public static int readBonusNumber() throws IllegalArgumentException {
        String input = Console.readLine();
        String pattern = "^[1-9]?[0-9]$";
        if (!Pattern.matches(pattern, input)) {
            throw new IllegalArgumentException("[ERROR] 최대 두자리 숫자를 입력해야 합니다.");
        }
        validateNumberRange(Integer.parseInt(input));
        return Integer.parseInt(input);
    }

    private static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

}
