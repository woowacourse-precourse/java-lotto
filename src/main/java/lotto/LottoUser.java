package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoUser {
    LottoConsole lottoConsole = new LottoConsole();

    public List<List<Integer>> generateUser(){
        List<List<Integer>> user = new ArrayList<>();
        user.add(generateLuckyNumber());
        user.add(generateBonusNumber());
        return user;
    }


    private List<Integer> generateLuckyNumber(){
        String luckyString = lottoConsole.inputLuckyNumber();
        List<Integer> luckyNumberList = changeStringToIntegerList(luckyString);
        checkDuplicationOfList(luckyNumberList);
        checkLengthOfList(luckyNumberList,6);
        checkSizeOfNumber(luckyNumberList);
        return luckyNumberList;
    }

    private List<Integer> generateBonusNumber(){
        String bonusString = lottoConsole.inputBonusNumber();
        List<Integer> bonusNumberList = changeStringToIntegerList(bonusString);
        checkLengthOfList(bonusNumberList,1);
        checkSizeOfNumber(bonusNumberList);
        return bonusNumberList;
    }


    private List<Integer> checkDuplicationOfList(List<Integer> numberList) {
        Set<Integer> numberSet = new HashSet<>(numberList);
        if(numberList.size()!=numberSet.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.");
        }
        return numberList;
    }

    private List<Integer> checkLengthOfList(List<Integer> numberList, int checkLength) {
        if (numberList.size() != checkLength){
            throw new IllegalArgumentException("[ERROR] 입력된 값이 " + checkLength + "개가 아닙니다.");
        }
        return numberList;
    }

    private List<Integer> checkSizeOfNumber(List<Integer> numberList) {
        for (Integer number : numberList) {
            if(!(1<= number && number <= 45)){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        return numberList;
    }

    private List<String> changeStringToStringList(String str1) {
        List<String> stringList = Arrays.asList(str1.split("\\s*,\\s*"));
        return stringList;
    }

    private List<Integer> changeStringListToIntegerList(List<String> stringList){
        try {
            return stringList.stream().map(Integer::parseInt).collect(Collectors.toList());
        } catch(NumberFormatException exception){
            throw new NumberFormatException("[ERROR] 입력된 값이 숫자가 아닙니다.");
        }
    }

    private List<Integer> changeStringToIntegerList(String str1) {
        return changeStringListToIntegerList(changeStringToStringList(str1));
    }
}
