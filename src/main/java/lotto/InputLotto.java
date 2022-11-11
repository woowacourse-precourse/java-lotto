package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

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

    public List<String> splitCommas(String value){
        List<String> valueList = List.of(value.split(","));
        return valueList;
    }

}
