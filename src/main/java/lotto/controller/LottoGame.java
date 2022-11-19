package lotto.controller;

import static lotto.domain.BonusNumber.bonus;
import static lotto.domain.BonusNumber.getBonusResult;
import static lotto.domain.PurchaseLotto.printPurchaseLottos;
import static lotto.domain.PurchaseLotto.purchaseAmount;
import static lotto.domain.WinningNumber.getWinningResult;
import static lotto.domain.WinningNumber.winningCount;
import static lotto.input.BonusInput.bonusInput;
import static lotto.input.PurchaseInput.inputPurchasePrice;
import static lotto.input.BonusInput.inputBonusNumber;
import static lotto.input.WinningInput.inputWinningNumber;
import static lotto.input.WinningInput.winningInput;
import static lotto.input.WinningInput.winningNumbers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

import lotto.output.LottoRank;
import lotto.output.ErrorMessage;
import lotto.output.Message;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENT = 100;
    private static int winMoney = 0;

    public void start() {
        List<List<Integer>> lottos;
        try {
            inputPurchasePrice();
            lottos = printPurchaseLottos();
            inputWinningNumber();
            inputBonusNumber();
            validateDuplicate(winningInput, bonusInput);
            getWinningResult(lottos, winningNumbers);
            getBonusResult(lottos);
            getTotalResult();
        } catch (IllegalArgumentException Error) {
            System.out.println(Error.getMessage());
        }
    }

    private static void getTotalResult() {
        Map<LottoRank, Integer> result = setToLottoRank();
        LottoRank rank;
        double purchasePrice = purchaseAmount * LOTTO_PRICE;
        System.out.println(Message.WINNING_STATS.getMessage());
        rank = LottoRank.getRankResult(winningCount, bonus);
        result.put(rank, result.get(rank) + 1);
        winMoney = rank.getMoney();
        printWinningList(result);
        System.out.printf("총 수익률은 " + String.format("%.1f", getWinningRate(purchasePrice)) + "%%입니다.");
    }

    private static double getWinningRate(double purchasePrice) {
        return (winMoney / purchasePrice) * PERCENT;
    }

    private static void printWinningList(Map<LottoRank, Integer> result) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getMoney() == 0) {
                continue;
            }
            System.out.println(rank.getMessage() + result.get(rank) + "개");
        }
    }

    private static Map<LottoRank, Integer> setToLottoRank() {
        Map<LottoRank, Integer> result = new LinkedHashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    private static void validateDuplicate(String winningNumber, String bonusNumber) {
        String[] dupliateCheck = winningNumber.split(",");
        for (String str : dupliateCheck) {
            if (str.equals(bonusNumber)) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE.getErrorMessage());
            }
        }
    }
}
