package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputNum {


    public static int askPrice() {

        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();
        return Integer.parseInt(price);
    }


    public static List<Integer> askWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String InputNums = Console.readLine();
        Validate.validateLotto(InputNums);

        List<Integer> winningNums = changStringToInteger(InputNums);


        return winningNums;
    }

    public static int askBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");

        String inputNum = Console.readLine();
        Validate.validateBonus(inputNum);

        int num = Integer.valueOf(inputNum);
        Validate.validateRange(num);


        return num;
    }



    private static List<Integer> changStringToInteger(String InputNums){
        String[] winningNumbers = InputNums.split(",");

        List<Integer> winningNums = new ArrayList<>();

        for(String num : winningNumbers) {
            winningNums.add(Integer.valueOf(num));
        }

        return winningNums;
    }


}
