package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.exception.ErrorHandler.unCorrectMoneyInputException;
import static lotto.exception.ErrorHandler.unCorrectMoneyRangeException;
import static lotto.view.OutputLotto.*;

public class InputLotto {
    public static List<Integer> getInput(){
        List<Integer> inputNumber = new ArrayList<>();
        char[] input = Console.readLine().replaceAll("[^0-9]","").toCharArray();
        for(char inputNum :input){
            inputNumber.add(inputNum-'0');
        }
        return inputNumber;
    }
    public static int moneyInput(){
        int lottoCount = 0;
        initInput();
        try{
            lottoCount=Integer.parseInt(Console.readLine());
        }catch (NumberFormatException n){
            unCorrectMoneyRangeException();
        }
        if(lottoCount%1000!=0){
            unCorrectMoneyInputException();
        }
        lottoCount/=1000;
        buyView(lottoCount);
        return lottoCount;
    }
}
