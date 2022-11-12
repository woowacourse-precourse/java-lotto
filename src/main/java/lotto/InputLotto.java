package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
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

    public List<Integer> IntputValueSplitCommas(){
        String value = inputValueOfUser();
        List<String> stringsNumberList = splitCommas(value);
        List<Integer> numberList = toIntList(stringsNumberList);
        return numberList;
    }

    public List<String> splitCommas(String value){
        List<String> valueList = List.of(value.split(","));
        return valueList;
    }

    public List<Integer> toIntList(List<String> stringsNumberList){
        List<Integer> numberList = new ArrayList<>();
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        for(String stringsNumber : stringsNumberList){
            exceptionHandling.outRangeLottoNumber(stringsNumber);
            numberList.add(toInts(stringsNumber));
        }
        return numberList;
    }

    public int toInts(String value){
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        exceptionHandling.isNumeric(value); // 숫자인지 검사
        return Integer.parseInt(value);
    }

}
