package lotto;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import constant.ConstantLottoProgram;
import exceptioncase.InputLottoNumberException;
import ui.InputLottoNumberPrint;

public class InputLottoNumber {
    public static List<Integer> inputLottoAnswerNumber(){
        List<Integer> answer;
        InputLottoNumberPrint.inputAsnwerNumber();
        String input = Console.readLine();
        answer = makeAnswerNumbers(input);
        if(answer.isEmpty()){
            return Collections.emptyList();
        }
        InputLottoNumberPrint.inputBonusNumber();
        String bonusNumber = Console.readLine();
        if(!addBonusNumber(answer,bonusNumber)){
            return Collections.emptyList();
        }
        return answer;
    }
    public static List<Integer> makeAnswerNumbers(String input){
        if(!InputLottoNumberException.exceptionsTest(input)){
            return Collections.emptyList();
        }
        List<Integer> answerNumbers = new LinkedList<>();
        for(String nowNumber : input.split(",")){
            answerNumbers.add(Integer.parseInt(nowNumber));
        }
        Collections.sort(answerNumbers);
        return answerNumbers;
    }
    public static boolean addBonusNumber(List<Integer> answerNumbers, String bonusNumber){
        if(!InputLottoNumberException.bonusNumberTest(bonusNumber,answerNumbers)){
            return ConstantLottoProgram.ERROR_CODE.isErrorState();
        }
        answerNumbers.add(Integer.parseInt(bonusNumber));
        return true;
    }

}
