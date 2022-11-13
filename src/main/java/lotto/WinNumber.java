package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinNumber {

    public List<Integer> winnerNumber() {
        String inputWinNum;
        String[] numberSplit;
        List<Integer> winnerNumber = new ArrayList<>();

        System.out.println("당첨 번호를 입력해 주세요.");
        inputWinNum = Console.readLine();

        numberSplit = inputWinNum.split(",");

        for(int i =0; i<numberSplit.length; i++){
            winnerNumber.add(Integer.parseInt(numberSplit[i]));
        }

        return  winnerNumber;
    }
}
