package lotto.model;

public class Utility {

    public static void intValidate(String s) {
        if (!s.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 값입니다..");
        }
    }

}
