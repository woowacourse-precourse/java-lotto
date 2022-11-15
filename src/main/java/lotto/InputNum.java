package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputNum {


    public static int askPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String answer = Console.readLine();
        int price =0;

        try{
            Validate.validateInt(answer);
            price = Integer.parseInt(answer);
            Validate.validatePrice(price);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR]1000단위로 입력하여 주세요.");
        }

        return price;
    }


    public static List<Integer> askWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String InputNums = Console.readLine();
        List<Integer> winningNums = changStringToInteger(InputNums);

        try{
            Validate.validateLotto(InputNums);
            for (int num : winningNums){
                Validate.validateRange(num);
            }
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 1~45사이의 숫자로 입력하여 주세요.");
        }


        return winningNums;
    }


    public static int askBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");

        String inputNum = Console.readLine();

        int num = 0;

        try{
            Validate.validateInt(inputNum);
            num = Integer.valueOf(inputNum);
            Validate.validateRange(num);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 1~45사이의 숫자로 입력하여 주세요.");
        }

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
