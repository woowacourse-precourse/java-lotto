package lotto.service;

import lotto.entity.GeneratedLottos;
import lotto.entity.Lotto;
import lotto.entity.User;
import lotto.utils.Parser;
import lotto.utils.RandomUtils;
import lotto.utils.Validation;
import lotto.view.UserRequest;

import java.util.ArrayList;
import java.util.List;


public class LottoService {
    public static int START = 1;
    public static int END = 45;
    public static int COUNT = 6;

    Lotto lotto;
    GeneratedLottos generatedLottos = new GeneratedLottos();
    User user = new User();

    public void getPurchaseAmount() {
        String input = UserRequest.userInput();
        if (Validation.validatePurchaseAmount(input)) {
            user.setPurchaseAmount(Parser.convertStringToInt(input));
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
            allLottos.add(new Lotto(RandomUtils.getRandomLottoNumber(START, END, COUNT)));
        }
        return allLottos;
    }

}
