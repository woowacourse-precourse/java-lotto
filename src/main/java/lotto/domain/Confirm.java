package lotto.domain;

public class Confirm {
    public static String validateDigit(String input) throws IllegalArgumentException{
        for (int i = 0; i < input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException("[ERROR] 숫자만 입력 하세요.");
            }
        }
        return input;
    }
}
