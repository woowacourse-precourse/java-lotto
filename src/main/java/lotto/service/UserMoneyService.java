package lotto.service;

import lotto.domain.User;
import lotto.domain.ValidUserInput;

public class UserMoneyService {

    private static final String userInput = User.getUserInputMoney();

    // 생성자에서 검증
    public UserMoneyService() {
        ValidUserInput.ValidInputNumberInteger(userInput);
        ValidUserInput.ValidInputNumberOverZero(userInput);
        int userMoney = Integer.parseInt(userInput);
        ValidInputMoneyOverThousand(userMoney);
        ValidInputMoneyDivideThousand(userMoney);

    }
    public int getUserMoney(){ // 인스턴수 사용 없이 쓰기 위해 static
        return Integer.parseInt(userInput);
    }

    private void ValidInputMoneyOverThousand(int inputMoney){
        if(inputMoney < 1000){
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 1000보다 작습니다.");
        }
    }

    private void ValidInputMoneyDivideThousand(int inputMoney){
        if((inputMoney % 1000) != 0){
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 1000으로 나누어 지지 않습니다.");
        }
    }
}
