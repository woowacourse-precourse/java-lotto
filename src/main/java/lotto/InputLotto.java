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

    public List<Integer> inputValueSplitCommas(){
        String value = inputValueOfUser();
        ExceptionHandling exceptionHandling = new ExceptionHandling();

        List<String> stringsNumberList = splitCommas(value);
        List<Integer> numberList = toIntList(stringsNumberList);
        exceptionHandling.removeDuplicateNumber(numberList);
        return numberList;
    }

    public List<String> splitCommas(String value){
        List<String> valueList = List.of(value.split(","));
        return valueList;
    }

    public List<Integer> toIntList(List<String> stringsNumberList){
        List<Integer> numberList = new ArrayList<>();
        for(String stringsNumber : stringsNumberList){
            numberList.add(toInts(stringsNumber));
        }
        return numberList;
    }

    public int toInts(String value){
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        exceptionHandling.outRangeLottoNumber(value); // 숫자인지 검사
        return Integer.parseInt(value);
    }

    public int inputBonusNumber(List<Integer> winNumbers){
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        String value = inputValueOfUser();
        exceptionHandling.outRangeLottoNumber(value); // 1 ~ 45인지 검사
        int bonusNumber = toInts(value);
        exceptionHandling.containsBonusNumber(winNumbers, bonusNumber); // 입력한 보너스 번호가 당첨 번호에 포함인지 검사
        return bonusNumber;
    }

}
