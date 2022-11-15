package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static config.Error.*;

public class Application {

    static String InputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    static String InputWinningNum(){
        System.out.println("당첨 번호를 입력해 주세요.\n");
        String input = Console.readLine();
        return input;
    }

    static List<Integer> SeparateInput(String input){
        String[] inputs = input.split(",");
        List<Integer> winningNum = new ArrayList<>();
        if(inputs.length != 6) throw new IllegalArgumentException(ERROR_MESSAGE+ERROR_INPUT_NUM);
        for(int i=0; i<6; i++){
            Integer num = stringToInt(inputs[i]);
            winningNum.add(num);
        }
        return winningNum;
    }

    public static int stringToInt(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_INTEGER);
        }
    }

    static List<Integer> InputWinningNumException(List<Integer>input) throws IllegalArgumentException{
        List<Integer> winningNum = new ArrayList<>();
        for(int i=0; i<6; i++){
            if(input.get(i) < 1 || input.get(i) > 45) {
                System.out.println(ERROR_MESSAGE+ERROR_NUM_RANGE);
                throw new IllegalArgumentException(ERROR_MESSAGE+ERROR_NUM_RANGE);
            }
            if(winningNum.contains(input.get(i))) {
                System.out.println(ERROR_MESSAGE+ERROR_DUPLICATION_NUM);
                throw new IllegalArgumentException(ERROR_MESSAGE+ERROR_DUPLICATION_NUM);
            }
            winningNum.add(input.get(i));
        }
        return winningNum;
    }

    static Integer InputMoneyException(String input) throws IllegalArgumentException{

        int money = stringToInt(input);
        if(money % 1000 == 0 ){
            return money % 1000;
        }

        System.out.println(ERROR_MESSAGE+ERROR_INPUT_MONEY);
        throw new IllegalArgumentException(ERROR_MESSAGE+ERROR_INPUT_MONEY);
    }

    public static void main(String[] args) {
        String inputMoney = InputMoney();
        int chance = InputMoneyException(inputMoney);
        String inputWinningNum = InputWinningNum();
        List<Integer> winningNum = SeparateInput(inputWinningNum);
        InputWinningNumException(winningNum);
        winningNum.add(stringToInt(Console.readLine())); // 보너스 번호 입력
    }
}
