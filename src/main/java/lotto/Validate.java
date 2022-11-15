package lotto;

import java.util.List;

public class Validate {

    public void bonusValidate(List<Integer> lottoNumber, int bonusNumber){
        if (lottoNumber.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 6개의 로또 번호와 중복이 불가합니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
    }
}
