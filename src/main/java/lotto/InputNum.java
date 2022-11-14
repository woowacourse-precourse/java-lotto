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


    public static Lotto askWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String InputNums = Console.readLine();
        validateLotto(InputNums);

        return new Lotto(changStringToInteger(InputNums));
    }

    public static int askBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");

        String inputNum = Console.readLine();
        validateBonus(inputNum);

        return Integer.valueOf(inputNum);
    }

    private static void validateLotto(String InputNums){
        if(!InputNums.contains(",") || InputNums.matches("[a-zA-Z ㄱ-ㅎㅏ-ㅣ가-힣.]")){
            throw new IllegalArgumentException("[ERROR] 쉼표로 구분하여 1~45사이의 숫자를 입력하여 주세요.");
        }
    }

    private static void validateBonus(String inputNum) {
        int Num = Integer.valueOf(inputNum);
        if(inputNum.length() != 1 || Num < 1 || Num > 45 || inputNum.matches("[a-zA-Z ㄱ-ㅎㅏ-ㅣ가-힣.,]")){
            throw new IllegalArgumentException("[ERROR] 1~45사이의 숫자 1개를 입력하여 주세요.");
        }
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
