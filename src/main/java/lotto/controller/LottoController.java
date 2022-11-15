package lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPrize;
import lotto.domain.player.Player;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final String DELIMITER = ",";
    private Player player;
    private List<Integer> winningNumbers;

    public LottoController() {
        getPlayerMoney();

        buyingLottoUsingAllMoney();

        getWinningNumbers();

        HashMap<LottoPrize, Long> prizeList = checkLotteryResult();
    }

    private HashMap<LottoPrize, Long> checkLotteryResult() {
        HashMap<LottoPrize, Long> playerPrizes = new HashMap<>();

        List<Lotto> playerLotteries = player.getLotteries();

        for (Lotto lotto : playerLotteries) {
            LottoPrize prize = lotto.play(winningNumbers);
            
            long count = playerPrizes.getOrDefault(prize, 0L);

            playerPrizes.put(prize, count + 1);
        }

        return playerPrizes;
    }

    private void getWinningNumbers() {
        String numberInput = InputView.getWinningNumber();

        validateLotteryFormat(numberInput);

        winningNumbers = parse(numberInput);

        String bonusInput = InputView.getBonusNumber();

        validateLotteryNumber(bonusInput);

        winningNumbers.add(Integer.parseInt(bonusInput));

        validateDuplicatedLotteryNumber(winningNumbers);
    }

    private void getPlayerMoney() {
        String moneyInput = InputView.getMoney();

        validateMoney(moneyInput);

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
            validateLotteryNumber(token);
            result.add(Integer.parseInt(token));
        }

        return result;
    }

    private void validateDuplicatedLotteryNumber(List<Integer> winningNumbers) {
        Collections.sort(winningNumbers);

        for (int i = 1; i < winningNumbers.size(); i++) {
            int prev = winningNumbers.get(i - 1);
            int cur = winningNumbers.get(i);

            if (prev == cur) {
                throw new IllegalArgumentException("[ERROR] 추첨 번호에는 중복이 있으면 안됩니다.");
            }
        }
    }

    private void validateLotteryFormat(String numberInput) {
        String pattern = "\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}";
        if (!numberInput.matches(pattern)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호 입력이 잘못됐습니다.");
        }
    }

    private void validateLotteryNumber(String token) {
        int number = Integer.parseInt(token);

        if (1 > number || 45 < number) {
            throw new IllegalArgumentException("[ERROR] 당첨번호 입력이 잘못됐습니다.");
        }
    }


    private void validateMoney(String moneyInput) {
        if (moneyInput.length() <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력의 길이가 잘못됐습니다.");
        }

        long money;

        try {
            money = Integer.parseInt(moneyInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자만 입력해주세요.");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 돈은 1000원 단위로 입력해주세요.");
        }
    }


}
