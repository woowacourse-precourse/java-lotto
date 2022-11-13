package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
public class LottoWin {
    static LottoWin lotto;
    private List<Integer> lottoNum;

    private LottoWin(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        List<Integer> numbers = convertStringToInt(userInput);
        System.out.println("보너스 번호를 입력해 주세요.");
        numbers.add(Integer.valueOf(Console.readLine()));
        this.lottoNum = numbers;
    }

    public static LottoWin getInstance() {
        if(lotto == null){ //최초 한번만 new 연산자를 통하여 메모리에 할당한다.
            lotto = new LottoWin();
        }
        return lotto;
    }

    public static List<Integer> convertStringToInt(String input){
        String[] inputSplit = input.split(",");
        List<Integer> returnData = new ArrayList<Integer>();
        for(int index = 0; index < inputSplit.length; index++){
            returnData.add(Integer.valueOf(inputSplit[index]));
        }
        return returnData;
    }

}
