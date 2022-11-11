package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputLotto {

    public long inputValueToints(){
        String value = inputValueOfUser();
        return toLongs(value);
    }

    public String inputValueOfUser() {
        return Console.readLine();
    }

    public long toLongs(String value) {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        exceptionHandling.isNumeric(value); // 숫자인지 검사
        return Long.parseLong(value);
    }

}
