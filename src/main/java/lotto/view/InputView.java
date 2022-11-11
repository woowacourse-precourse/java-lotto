package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static Integer requestPurchaseMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney=Console.readLine();
        return Integer.parseInt(inputMoney);
    }
    public static List<Integer> requestLottoNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String tmpInputNumbers=Console.readLine();

        List<Integer> inputNumbers=new ArrayList<>();

        String[] tmpInputNumber=tmpInputNumbers.split(",");

        for(int i=0;i< tmpInputNumber.length;i++){
            inputNumbers.add(Integer.parseInt(tmpInputNumber[i]));
        }

        return inputNumbers;
    }
    public static int requestBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber=Console.readLine();
        return Integer.parseInt(inputBonusNumber);
    }
}
