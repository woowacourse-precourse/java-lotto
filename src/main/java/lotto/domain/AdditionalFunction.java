package lotto.domain;

import java.util.NoSuchElementException;

public class AdditionalFunction {
    public static int StringToInt(String inputNumber){
        try{
            int outputNumber = Integer.parseInt(inputNumber);
            return outputNumber;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 로또 번호 및 금액은 숫자여야 합니다.");
        }
    }

    public static void validateNumRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
