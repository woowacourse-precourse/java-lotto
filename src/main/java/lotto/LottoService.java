package lotto;

import static lotto.ui.ConsoleMessage.INPUT_PRICE;
import static lotto.ui.LottoConsole.*;
import static lotto.util.LottoNumberGenerator.*;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.UserLottoInfo;

public class LottoService {

    private UserLottoInfo userLottoInfo;

    public LottoService() { }

    public void inputLottoPrice() {
        printMessage(INPUT_PRICE.toString());
        String lottoPrice = userInput();
        storeLottoPrice(lottoPrice);
    }

    private void storeLottoPrice(String lottoPrice) {
        userLottoInfo = new UserLottoInfo(lottoPrice);
    }

    public void publishLottos() {
        int totalLottoCount = userLottoInfo.getLottoPrice() / 1000;
        userLottoInfo.initLottoList(totalLottoCount);
        for (int i = 0; i < totalLottoCount; i++) {
            publishSingleLotto();
        }
    }

    private void publishSingleLotto() {
        List<Integer> lottoNumbers = generateLottoNumbers();
        userLottoInfo.addSingleLotto(new Lotto(lottoNumbers));
    }

    public void showLottoResult() {
        printLottoCount(String.valueOf(userLottoInfo.getUserLottoSize()));
        for (int i = 0; i < userLottoInfo.getUserLottoSize(); i++){
            printSingleLotto(userLottoInfo.getSingleLotto(i));
        }
    }

    private void printSingleLotto(Lotto lotto){
        List<Integer> lottoNumbers = lotto.getNumbers();
        Collections.sort(lottoNumbers);
        printLottoResult(lottoNumbers);
    }
}
