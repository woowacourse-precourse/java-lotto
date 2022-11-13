package lotto;

import static lotto.ui.ConsoleMessage.INPUT_PRICE;
import static lotto.ui.ConsoleMessage.USERS_LOTTO_OUTPUT;
import static lotto.util.LottoNumberGenerator.*;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.UserLottoInfo;
import lotto.ui.LottoConsole;

public class LottoService {

    private UserLottoInfo userLottoInfo;
    private final LottoConsole lottoConsole;

    public LottoService(LottoConsole lottoConsole) {
        this.lottoConsole = lottoConsole;
    }

    public void inputLottoPrice() {
        lottoConsole.printMessage(INPUT_PRICE.toString());
        String lottoPrice = lottoConsole.userInput();
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
        lottoConsole.printMessage(String.valueOf(userLottoInfo.getUserLottoSize()) + USERS_LOTTO_OUTPUT); // to 개선 !
        for (int i = 0; i < userLottoInfo.getUserLottoSize(); i++){
            printSingleLotto(userLottoInfo.getSingleLotto(i));
        }
    }

    private void printSingleLotto(Lotto lotto){
        List<Integer> lottoNumbers = lotto.getNumbers();
        Collections.sort(lottoNumbers);
        lottoConsole.printLottoResult(lottoNumbers);
    }
}
