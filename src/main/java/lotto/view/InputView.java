package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int getMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        int inputMoney = Integer.parseInt(Console.readLine());
        validateInputMoney(inputMoney);
        return inputMoney;
    }
    public void validateInputMoney(int inputMoney){
        if(inputMoney%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위여야 합니다.");
        }
    }

}
