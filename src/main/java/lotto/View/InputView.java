package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int getAmount(){
        System.out.println("구앱 금액을 입력해 주세요.");
        return validateNumber(Console.readLine());
    }

    private int validateNumber(String input){
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ok){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

}
