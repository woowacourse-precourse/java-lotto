package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.LottoGenerator;
import lotto.model.Player;
import lotto.model.Service;
import lotto.util.InputVerifier;

public class Controller {

    Player player = new Player();

    private String getMoney() {
        String money = player.getInput();
        InputVerifier.checkMoney(money);

        return money;
    }

    private int getLottoAmount(String money) {
        return Service.countLottoAmount(money);
    }

    private List<List<Integer>> getLottoNumbers(int lottoAmount) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            lottoNumbers.add(LottoGenerator.generateLottoNumbers());
        }
        return lottoNumbers;
    }

    // TODO: 당첨 결과 저장하는 기능

    private List<Integer> getBonusNumbers(int lottoAmount) {
        List<Integer> bonusNumbers = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            bonusNumbers.add(LottoGenerator.generateBonusNumber());
        }
        return bonusNumbers;
    }

    private List<String> guessLottoNumbers() {
        List<String> lottoNumbers = player.guessLottoNumbers();
        InputVerifier.checkLottoNumber(lottoNumbers);
        return lottoNumbers;
    }

}
