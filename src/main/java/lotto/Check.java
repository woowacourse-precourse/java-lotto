package lotto;

import java.util.List;

public class Check {
    public static boolean isMultipleOf1000(int number) throws IllegalArgumentException{
        if(number % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1000원 단위여야 합니다.");
        return true;
    }

    public static boolean isNumbersBetween1And45(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            if (number < 1 || number > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return true;
    }
}