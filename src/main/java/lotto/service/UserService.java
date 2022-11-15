package lotto.service;

import lotto.domain.User;
import lotto.domain.ValidUserInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserService {
    private static final int LOTTO_PRICE = 1000;
    // 로또 살 수 있는 갯수
    public int getUserLottoCount(){
        int userInputMoney = getUserMoney();

        return userInputMoney / LOTTO_PRICE;
    }

    // 돈 얼마 넣었는지 알 수 있음
    public int getUserMoney(){ // 인스턴수 사용 없이 쓰기 위해 static
        User userMoney = new User();
        String userInput = User.getUserInputMoney();

        ValidUserInput.isInputNumberInteger(userInput);
        ValidUserInput.isInputMoneyDivideThousand(userInput);

        return Integer.parseInt(userInput);
    }

    // 입력한 로또 번호를 알 수 있음
    public List<Integer> getLottoNumber(){
        String[] lottoNumber = User.getUserInputLottoNumber();
        List<Integer> lottoNumbers = new ArrayList<>(Collections.emptyList());

        for (String number : lottoNumber) { // 입력받은 로또 번호 숫자인지 검증
            ValidUserInput.isInputNumberInteger(number);
            ValidUserInput.isInputNumberOverZero(number);
            lottoNumbers.add(Integer.parseInt(number)); //통과했다면 List<>에 넣어줌
        }
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    // 입력한 보너스 로또 번호를 알 수 있음
    public int getBonusNumber(){
        String bonusNumber= User.getUserInputBonusNumber();
        ValidUserInput.isInputNumberInteger(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

}
