package lotto;

import static lotto.ui.ConsoleMessage.USERS_LOTTO_OUTPUT;
import static lotto.util.LottoNumberGenerator.*;
import static lotto.util.Validator.validateLottoPrice;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.UserLottoInfo;
import lotto.ui.LottoConsole;

public class LottoService {
    public static final int START_IDX = 1;
    public static final int END_IDX = 45;
    public static final int NUMBER_COUNT = 6;

    private final UserLottoInfo userLottoInfo;
    private final LottoConsole lottoConsole;

    public LottoService(UserLottoInfo userLottoInfo, LottoConsole lottoConsole) {
        this.userLottoInfo = userLottoInfo;
        this.lottoConsole = lottoConsole;
    }

    public String inputLottoPrice(String lottoPrice) {
        validateLottoPrice(lottoPrice);
        return lottoPrice;
    }

    public void storeLottoPrice(String lottoPrice) {
        userLottoInfo.setLottoPrice(Integer.parseInt(lottoPrice));
    }

    // lotto 개수만큼 lotto 발행 (-> Lotto 객체 n개)
    public void publishLottos() {
        int totalLottoCount = userLottoInfo.getLottoPrice() / 1000;
        userLottoInfo.initLottoList(totalLottoCount);
        for (int i = 0; i < totalLottoCount; i++) {
            publishSingleLotto();
        }
    }

    private void publishSingleLotto() {
        List<Integer> lottoNumbers = generateRandomNumbers(START_IDX, END_IDX, NUMBER_COUNT);
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
