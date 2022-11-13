package lotto.service;

import lotto.domain.User;
import lotto.domain.ValidUserInput;

import java.util.List;

public class UserBonusNumberService {

    private static final String bonusNumber = User.getUserInputBonusNumber();
    UserLottoNumberService userLottoNumber = new UserLottoNumberService();

    // 생성자에서 검증
    public UserBonusNumberService() {
        ValidUserInput.ValidInputNumberInteger(bonusNumber);
        ValidUserInput.ValidInputNumberOverZero(bonusNumber);
        ValidBonusNumberNotSameRandomNumber(Integer.parseInt(bonusNumber),userLottoNumber.getLottoNumber());
    }

    public int getBonusNumber(){
        return Integer.parseInt(bonusNumber);
    }

    public boolean isBonusNumberSameLottoNumber(){
        if(userLottoNumber.getLottoNumber().contains(getBonusNumber())){
            return false;
        }
        return true;
    }

    //보너스 볼이 로또 입력한 로또 번호 리스트와 같은지 검증
    public static void ValidBonusNumberNotSameRandomNumber(int bonusNumber, List<Integer> userInputNumber) {
        if (userInputNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 볼이 자동 생성된 로또 번호와 같습니다.");
        }
    }
}
