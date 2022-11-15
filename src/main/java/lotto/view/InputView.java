package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        return toInteger(Console.readLine());
    }

    public List<Integer> inputLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < input.length; i++){
            numbers.add(toInteger(input[i]));
        }
        return numbers;
    }

    public String inputBonusLotto(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public int toInteger(String input){
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}
