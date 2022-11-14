package lotto;

import java.util.List;

public class ErrorUtil {
    public void errorInputCharacter(String numbers) {
        for (int i=0;i<numbers.length();++i)
            if (numbers.charAt(i) < '0' || numbers.charAt(i) > '9')
                throw new IllegalArgumentException("[ERROR] 유효한 숫자가 아닙니다.");
    }
    public void errorInputMoney(int money) {
        if (money % 1000 != 0 || money == 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력되어야 합니다.");
        }
    }

    public void errorInputLottoNumber(String[] lottoNumbers) {
        for (String lottoNumber : lottoNumbers) {
            if (Integer.parseInt(lottoNumber) < 1 || Integer.parseInt(lottoNumber) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public void errorOverlapLottoNumber(List<Integer> lottoNumbers) {
        if(lottoNumbers.size() != lottoNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복 번호는 입력할 수 없습니다.");
        }
    }
    public void errorInputCountLottoNumber(String[] lottoNumbers) {
        if (lottoNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
    }

    public void errorInputBonusNumber(String bonusNumber) {
        if (Integer.parseInt(bonusNumber) < 1 || Integer.parseInt(bonusNumber) > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}