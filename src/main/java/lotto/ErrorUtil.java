package lotto;

import java.util.List;

public class ErrorUtil {
    OutputView outputView = new OutputView();
    public void errorInputMoney(int money) {
        if (money % 1000 != 0 || money == 0) {
            outputView.printErrorInputMoney();
            throw new IllegalArgumentException();
        }
    }

    public void errorInputLottoNumber(String[] lottoNumbers) {
        for (int i=0;i<lottoNumbers.length;++i) {
            if (Integer.parseInt(lottoNumbers[i]) < 1 || Integer.parseInt(lottoNumbers[i]) > 45) {
                outputView.printErrorInputLottoNumber();
                throw new IllegalArgumentException();
            }
        }
    }

    public void errorOverlapLottoNumber(List<Integer> lottoNumbers) {
        if(lottoNumbers.size() != lottoNumbers.stream().distinct().count()) {
            outputView.printErrorInputOverlapNumber();
            throw new IllegalArgumentException();
        }
    }
    public void errorInputCountLottoNumber(String[] lottoNumbers) {
        if (lottoNumbers.length != 6) {
            outputView.printErrorInputCountLottoNumber();
            throw new IllegalArgumentException();
        }
    }

    public void errorInputBonusNumber(String bonusNumber) {
        if (Integer.parseInt(bonusNumber) < 1 || Integer.parseInt(bonusNumber) > 45) {
            outputView.printErrorInputLottoNumber();
            throw new IllegalArgumentException();
        }
    }
}