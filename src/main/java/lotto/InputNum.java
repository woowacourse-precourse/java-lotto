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
        validate(InputNums);

        return new Lotto(changStringToInteger(InputNums));
    }

    private static void validate(String InputNums){
        if(!InputNums.contains(",") || InputNums.matches("[a-zA-Z ㄱ-ㅎㅏ-ㅣ가-힣]")){
            throw new IllegalArgumentException("[ERROR] 쉼표로 구분하여 1~45사이의 정수를 입력하여 주세요.");
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
