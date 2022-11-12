package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.LottoGenerator;
import lotto.model.Player;
import lotto.model.Service;
import lotto.util.InputVerifier;
import lotto.view.View;

public class Controller {

    Player player = new Player();

    public void run() {
        try {
            setGame();
        } catch (IllegalArgumentException ie) {
            return;
        }
    }

    public void setGame() {
        View.printInputPurchaseAmount();
        String input = player.input();

        try {
            InputVerifier.checkMoney(input);
        } catch (IllegalArgumentException ie) {
            return;
        }

        int money = Integer.parseInt(input);
        int lottoAmount = Service.getLottoAmount(money);

        List<List<Integer>> lottoNumbers;

        try {
            lottoNumbers = new ArrayList<>(buyLotto(lottoAmount));
        } catch (IllegalArgumentException ie) {
            return;
        }

        List<Integer> bonusNumbers = getBonusNumbers(lottoAmount);  // TODO: BONUS 넘버 검증
        View.printPurchaseInformation(lottoAmount, lottoNumbers);

        View.printInputLottoNumber();
        List<Integer> playerLottoNumbers;

        try {
            playerLottoNumbers = player.inputLottoNumbers();
            Lotto lotto = new Lotto(playerLottoNumbers);
        } catch (IllegalArgumentException ie) {
            return;
        }

        View.printInputBonusNumber();
        input = player.input();

        try {
            InputVerifier.checkBonusNumber(input);
        } catch (IllegalArgumentException ie) {
            return;
        }

        int playerBonusNumber = Integer.parseInt(input);

        int[] lottoResult = Service.getLottoResult(lottoAmount, lottoNumbers, playerLottoNumbers, playerBonusNumber);
        View.printResult(lottoResult);

        double profitRates = Service.getProfitRates(money, lottoResult);
        View.printProfitRate(profitRates);
    }


    private List<List<Integer>> buyLotto(int lottoAmount) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> checkValid = LottoGenerator.generateLottoNumbers();
            Lotto lotto = new Lotto(checkValid);
            lottoNumbers.add(checkValid);
        }
        return lottoNumbers;
    }

    private List<Integer> getBonusNumbers(int lottoAmount) {
        List<Integer> bonusNumbers = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            bonusNumbers.add(LottoGenerator.generateBonusNumber());
        }
        return bonusNumbers;
    }

//    private int guessBonusNumbers() {
//        String bonusNumbers = player.inputSingleNumber();
//        InputVerifier.checkBonusNumber(bonusNumbers);
//        return Integer.parseInt(bonusNumbers);
//    }


}
