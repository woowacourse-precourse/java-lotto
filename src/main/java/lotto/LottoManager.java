/*
package lotto;

import lotto.controller.LottoGenerator;
import lotto.controller.ValidationException;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.controller.LottoGenerator.generateLottoNumber;

public class LottoManager {

    public List<Lotto> lottoNums = new ArrayList<>();

    public void sss() {
        String userMoney = InputView.priceInput();
        boolean noException = ValidationException.checkValidPrice(userMoney);
        if (noException) {
            int lottoNum = calculateLottoNum(Integer.parseInt(userMoney));
            for (int idx = 0; idx < lottoNum; idx++) {
                List<Integer> userLottoNumber = LottoGenerator.generateLottoNumber();
            }

        }
    }

    public int calculateLottoNum(int userMoney) {
        return userMoney/ 1000;
    }




}
*/
