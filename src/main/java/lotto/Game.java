package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    static Validation validation = new Validation();
    static int purchase;
    static Lotto winningNumber;
    static List<Lotto> lottos;
    static int bonusNumber;
    static Map<String, Integer> winningStatus;

    static void run() throws IllegalArgumentException {
        UI ui = new UI();
        Game.setPurchase(ui.inputPurchase());
        ui.outputLottoCount();
        Game.generateLottos();
        ui.outputLottoNumbers();
        Game.setWinningNumber(ui.inputWinningNumber());
        Game.setBonusNumber(ui.inputBonusNumber());
        Game.calculateWinningStatus();
        ui.outputWinningStatus();
        ui.outputRateOfReturn();
    }

    static void setPurchase(String input) throws IllegalArgumentException {
        validation.checkNull(input);
        validation.checkNumeric(input);
        purchase = Integer.parseInt(input);
        validation.checkDividable(purchase);
    }

    static int getLottoCount() {
        return (purchase / Constant.LOTTO_PRICE);
    }

    static void generateLottos() {
        lottos = new ArrayList<>();
        for (int i = 0; i < getLottoCount(); i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
    }

    static void setWinningNumber(String input) throws IllegalArgumentException {
        validation.checkNull(input);
        validation.checkWinningFormat(input);
        List<Integer> number = new ArrayList<>();
        for (String token : input.split(",")) {
            number.add(Integer.parseInt(token));
        }
        winningNumber = new Lotto(number);
    }

    static void setBonusNumber(String input) throws IllegalArgumentException {
        validation.checkNull(input);
        validation.checkNumeric(input);
        bonusNumber = Integer.parseInt(input);
        validation.checkNumberInRange(bonusNumber);
        validation.checkBonusDuplicate(winningNumber, bonusNumber);
    }

    static void initializeWinningStatus() {
        winningStatus = new HashMap<>();
        for (Rank rank : Rank.values()) {
            winningStatus.put(rank.getMessage(), Constant.NONE);
        }
    }

    static int getWins(Lotto lotto) {
        int wins = Constant.NONE;
        for (int number : lotto.getNumbers()) {
            if (winningNumber.hasNumber(number)) {
                wins += Constant.WIN;
            }
        }
        if (wins == Rank.THIRD.getWins() && lotto.hasNumber(bonusNumber)) {
            return Rank.SECOND.getWins();
        }
        return wins;
    }

    static String getRank(Lotto lotto) {
        int wins = getWins(lotto);
        for (Rank rank : Rank.values()) {
            if (wins == rank.getWins()) {
                return rank.getMessage();
            }
        }
        return Rank.UNRANKED.getMessage();
    }

    static void calculateWinningStatus() {
        initializeWinningStatus();
        for (Lotto lotto : lottos) {
            String rank = getRank(lotto);
            winningStatus.put(rank, winningStatus.get(rank) + Constant.WIN);
        }
    }

    static float getTotalPrice() {
        long totalPrice = Constant.NONE;
        for (Rank rank : Rank.values()) {
            totalPrice += (rank.getPrice() * winningStatus.get(rank.getMessage()));
        }
        return totalPrice;
    }

    static float getRateOfReturn() {
        float rateOfReturn = (getTotalPrice() / purchase) * Constant.PERCENTAGE;
        return rateOfReturn;
    }

}
