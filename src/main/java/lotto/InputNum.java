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
        validateLotto(InputNums);

        List<Integer> winningNums = changStringToInteger(InputNums);

        //중복 검사
        validateDuplication(winningNums);

        for(int num : winningNums){
            validateRange(num);
        }

        winningNums.add(askBonusNum());

        //중복 검사
        validateDuplication(winningNums);

        return winningNums;
    }

    public static int askBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");

        String inputNum = Console.readLine();
        validateBonus(inputNum);

        int num = Integer.valueOf(inputNum);
        validateRange(num);


        return num;
    }

    private static void validateLotto(String InputNums){
        if(!InputNums.contains(",") || InputNums.matches("[a-zA-Z ㄱ-ㅎㅏ-ㅣ가-힣.]")){
            throw new IllegalArgumentException("[ERROR] 쉼표로 구분하여 1~45사이의 숫자를 입력하여 주세요.");
        }

    }

    private static void validateBonus(String inputNum) {

        if(inputNum.length() != 1 || inputNum.matches("[a-zA-Z ㄱ-ㅎㅏ-ㅣ가-힣.,]")){
            throw new IllegalArgumentException("[ERROR] 1~45사이의 숫자 1개를 입력하여 주세요.");
        }
    }

    private static void validateRange(int Num){
        if(Num < 1 || Num > 45){
            throw new IllegalArgumentException("[ERROR] 1~45사이의 숫자 1개를 입력하여 주세요.");
        }
    }

    private static void validateDuplication(List<Integer> winningNums){
        if(winningNums.size() != winningNums.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");
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
