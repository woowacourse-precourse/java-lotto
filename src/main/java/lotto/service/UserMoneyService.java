package lotto.service;

import lotto.domain.User;
import lotto.domain.ValidUserInput;

public class UserMoneyService {

    private final String userInput = User.getUserInputMoney();
    private final int userMoney = Integer.parseInt(userInput);

    // 생성자에서 검증
    public UserMoneyService() {
        ValidUserInput.ValidInputNumberInteger(userInput);
        ValidUserInput.ValidInputNumberOverZero(userInput);
        ValidInputMoneyOverThousand(userMoney);
    }

    public String getUserMoney(){ // 인스턴수 사용 없이 쓰기 위해 static
        return userInput;
    }

    // 여기선 string 으로 주고 뷰에서 integer 파싱해도 되는데
    // 자동생성 로또 번호에도 써야 하기 때문에 int 로 바꾼 뒤에 보내줌
    public int getUserLottoCount(){ // 로또 갯수는 1000으로 떨어지는지 추가로 검증
        ValidInputMoneyDivideThousand(userMoney);
        return Integer.parseInt(userInput);
    }

    public void ValidInputMoneyOverThousand(int inputMoney){
        if(inputMoney < 1000){
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 1000보다 작습니다.");
        }
    }

    public void ValidInputMoneyDivideThousand(int inputMoney){
        if((inputMoney % 1000) != 0){
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 1000으로 나누어 지지 않습니다.");
        }
    }
}
