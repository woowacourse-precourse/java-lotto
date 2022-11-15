package lotto.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPrize;
import lotto.domain.player.Player;
import lotto.domain.utils.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final String DELIMITER = ",";
    private Player player;
    private List<Integer> winningNumbers;

    public LottoController() {
    }

    public void run() {
        getPlayerMoney();

        buyingLottoUsingAllMoney();

        getWinningNumbers();

        LinkedHashMap<LottoPrize, Long> prizeList = checkLotteryResult();

        player.saveResult(prizeList);

        OutputView.printTotalResult(prizeList, player.getEarningRate());
    }

    private LinkedHashMap<LottoPrize, Long> checkLotteryResult() {
        LinkedHashMap<LottoPrize, Long> playerPrizes = initializePrizeMap();

        List<Lotto> playerLotteries = player.getLotteries();

        for (Lotto lotto : playerLotteries) {
            LottoPrize prize = lotto.play(winningNumbers);

            long count = playerPrizes.get(prize);

            playerPrizes.put(prize, count + 1);
        }

        playerPrizes.remove(LottoPrize.DEFAULT);

        return playerPrizes;
    }

    private LinkedHashMap<LottoPrize, Long> initializePrizeMap() {
        LinkedHashMap<LottoPrize, Long> prizeMap = new LinkedHashMap<>();

        for (LottoPrize lottoPrize : LottoPrize.values()) {
            prizeMap.put(lottoPrize, 0L);
        }

        return prizeMap;
    }

    private void getWinningNumbers() {
        String numberInput = InputView.getWinningNumber();

        InputValidator.validateLotteryFormat(numberInput);

        winningNumbers = parse(numberInput);

        String bonusInput = InputView.getBonusNumber();

        InputValidator.validateLotteryNumber(bonusInput);

        winningNumbers.add(Integer.parseInt(bonusInput));

        InputValidator.validateDuplicatedLotteryNumber(winningNumbers);
    }

    private void getPlayerMoney() {
        String moneyInput = InputView.getMoney();

        InputValidator.validateMoney(moneyInput);

        int money = Integer.parseInt(moneyInput);

        player = new Player(money);
    }

    private void buyingLottoUsingAllMoney() {
        player.buyLotto();

        List<Lotto> playerLotteries = player.getLotteries();

        OutputView.printBuyingCount(playerLotteries);
    }

    private List<Integer> parse(String numberInput) {
        List<Integer> result = new ArrayList<>();

        String[] tokens = numberInput.split(DELIMITER);

        for (String token : tokens) {
            InputValidator.validateLotteryNumber(token);
            result.add(Integer.parseInt(token));
        }

        return result;
    }

}
