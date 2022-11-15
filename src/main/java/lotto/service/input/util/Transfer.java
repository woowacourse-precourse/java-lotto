package lotto.service.input.util;


import java.util.NoSuchElementException;

public class Transfer {


    private static final String ONLY_NUMBER = "[ERROR] 숫자만 입력할 수 있습니다.";

    public static Integer toInteger(String readline) {
        try {
            return Integer.parseInt(readline);
        } catch (NumberFormatException e) {
            System.out.println(ONLY_NUMBER);
            throw new NoSuchElementException(ONLY_NUMBER);
        }
    }


}
