package lotto.Input;

import lotto.Validate.HandleException;
import lotto.Constant.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import lotto.Application;

public class Input {
    static int castInt(String str){
        int num = 0;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException ex){
            System.out.println(ErrorMessage.INVALID_NOTANUMBER.print());
        }
        return num;
    }
    public static List<String> parsingString(int maxArgc){
        String hitString = Console.readLine();
        List<String> hitStringParsed = Arrays.asList(hitString.split(","));

        HandleException.InputArgsNum(hitStringParsed, maxArgc);
        return hitStringParsed;
    }
    public static int singleNumber(){
        int inputNum = castInt(Console.readLine());
        return inputNum;
    }
    public static List<Integer> multiNumber(int maxArgc){
        List<String> stringParsed = parsingString(maxArgc);
        List<Integer> multiNumberList = new ArrayList<>(Application.getlottoNum());
        for (int i = 0; i < Application.lottoLength; i++) {
            multiNumberList.add(castInt(stringParsed.get(i)));
        }

        HandleException.DuplicatedNum(multiNumberList);
        return multiNumberList;
    }
}
