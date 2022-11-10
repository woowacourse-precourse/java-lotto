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
        setGame();
    }

    private void setGame() {
        View.printInputPurchaseAmount();
        String money = getMoney();

        int lottoAmount = getLottoAmount(money);
        List<List<Integer>> lottoNumbers = getLottoNumbers(lottoAmount);
        List<Integer> bonusNumbers = getBonusNumbers(lottoAmount);
        View.printPurchaseInformation(lottoAmount, lottoNumbers);

        View.printInputLottoNumber();
        List<String> playerLottoNumbers = guessLottoNumbers();

        View.printInputBonusNumber();
        int playerBonusNumber = guessBonusNumbers();

        int[] lottoResult = Service.getLottoResult(lottoAmount, lottoNumbers, playerLottoNumbers, playerBonusNumber);
        View.printResult(lottoResult);

        double profitRates = Service.getProfitRates(money, lottoResult);
        View.printProfitRate(profitRates);
    }

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

    private int guessBonusNumbers() {
        String bonusNumbers = player.getInput();
        InputVerifier.checkBonusNumber(bonusNumbers);
        return Integer.parseInt(bonusNumbers);
    }

}
