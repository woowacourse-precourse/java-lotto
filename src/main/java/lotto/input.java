package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class input {
    static int ownMoney(){
        int own_money =0;
        String inputMoney;
        inputMoney = Console.readLine();
        if (inputMoney.isBlank()) throw new IllegalArgumentException("[ERROR] 로또를 구매 하시려면 돈을 입력해 주세요.");
        System.out.println("구입금액을 입력해 주세요");
        try{
            own_money = Integer.parseInt(inputMoney);
        }catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력해 주세요");
        }
        if(own_money <=0){
            throw new IllegalArgumentException("[ERROR] 금액이 0원 이하 입니다.");
        }
        return own_money;
    }
    static List<Integer> checkWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinNum = Console.readLine();
        List<Integer> winNumbers;
        try {
            List<String> winNumbersString = Arrays.asList(inputWinNum.split(","));
            winNumbers = winNumbersString.stream()
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 숫자여야 합니다.");
        }
        return winNumbers;
    }
    static int inputBonus(){
        String input_num= Console.readLine();
        int bonus;
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            bonus = Integer.parseInt(input_num);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개의 숫자만 입력하셔야 합니다.");
        }
        return bonus;
    }
}
