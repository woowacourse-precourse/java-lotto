package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private int userMoney;
    private int resultMoney;

    public void readMoney(){
        int inputMoney = Integer.parseInt(readLine());
        validateInputNumber(inputMoney);
        userMoney = inputMoney;
    }

    private void validateInputNumber(int inputMoney) {
        if(inputMoney%1000 != 0){
            System.out.println("[ERROR] 금액은 1000원 단위로 나뉘어 떨어져야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
