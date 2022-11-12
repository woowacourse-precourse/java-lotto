package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Validator {

    public static void purchase(String purchase){
        if (!purchase.matches("^[1-9]")){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
        if (Integer.parseInt(purchase) % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위이여야 합니다.");
        }
    }

    public static void winningNumbers(String winningNumbers) {
        if (!winningNumbers.contains(",")){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분하여 입력해야 합니다.");
        }
        Arrays.stream(winningNumbers.split(","))
                .forEach(Validator::checkNumber);
        checkDuplicate(winningNumbers.split(","));
    }

    public static void bonusNumber(String bonusNumber){
        checkNumber(bonusNumber);
        if (Integer.parseInt(bonusNumber) < 1 || Integer.parseInt(bonusNumber) > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45사이의 수여야 합니다.");
        }
    }

    public static void checkDuplicate(List<Integer> numbers){
        HashSet<Integer> checkDuplicate = new HashSet<>(numbers);
        if (checkDuplicate.size() != 6){
            throw new IllegalArgumentException("[ERROR] 6개의 중복되지 않은 수여야 합니다.");
        }
    }

    public static void checkDuplicate(List<Integer> winningNumbers, int bonusNumber){
        if (winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 수여야 합니다.");
        }
    }

    private static void checkDuplicate(String[] numbers){
        HashSet<String> checkDuplicate = new HashSet<>(List.of(numbers));
        if (checkDuplicate.size() != 6){
            throw new IllegalArgumentException("[ERROR] 6개의 중복되지 않은 수여야 합니다.");
        }
    }

    private static void checkNumber(String number){
        try {
            Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야합니다.");
        }
    }

}
