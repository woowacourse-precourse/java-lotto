package lotto;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import exceptioncase.InputLottoNumberException;
public class InputLottoNumber {
    public static List<Integer> inputLottoAnswerNumber(){
        List<Integer> answer;
        String input = Console.readLine();
        answer = makeAnswerNumbers(input);
        String bonusNumber = Console.readLine();
        addBonusNumber(answer,bonusNumber);
        return answer;
    }
    public static List<Integer> makeAnswerNumbers(String input){
        InputLottoNumberException.exceptionsTest(input);
        List<Integer> answerNumbers = new LinkedList<>();
        for(String nowNumber : input.split(",")){
            answerNumbers.add(Integer.parseInt(nowNumber));
        }
        Collections.sort(answerNumbers);
        return answerNumbers;
    }
    public static void addBonusNumber(List<Integer> answerNumbers, String bonusNumber){
        InputLottoNumberException.bonusNumberTest(bonusNumber,answerNumbers);
        answerNumbers.add(Integer.parseInt(bonusNumber));
    }

}
