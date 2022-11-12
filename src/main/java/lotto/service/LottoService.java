package lotto.service;

import lotto.entity.GeneratedLottos;
import lotto.entity.Lotto;
import lotto.entity.LottoInfo;
import lotto.entity.User;
import lotto.utils.Parser;
import lotto.utils.RandomUtils;
import lotto.utils.Validation;
import lotto.view.UserRequest;

import java.util.ArrayList;
import java.util.List;


public class LottoService {

    Lotto lotto;
    GeneratedLottos generatedLottos = new GeneratedLottos();
    User user = new User();

    public void getPurchaseMoney() {
        String input = UserRequest.userInput();
        if (Validation.validatePurchaseAmount(input)) {
            user.setPurchaseMoney(Parser.convertStringToInt(input));
        }
    }
    public void getLottoCount(int amount) {
        user.setLottoAmount(Parser.countLotto(amount));
    }

    public void getRandomLottos() {
        int lottoCount = user.getLottoAmount();
        generatedLottos.setAllLottos(generateLottos(lottoCount));
    }

    public List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> allLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            allLottos.add(new Lotto(RandomUtils.getRandomLottoNumber(LottoInfo.START, LottoInfo.END, LottoInfo.COUNT)));
        }
        return allLottos;
    }
    public void getUserNumber() {
        String input = UserRequest.userInput();
        user.setUserNumber(Parser.seperateCommas(input));
    }



}
