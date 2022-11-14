package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.Rank;

import lotto.Service.BonusNumberService;
import lotto.Service.CalculateResultService;
import lotto.Service.LottoNumberService;
import lotto.Service.WinningNumberService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.View.PrintView.*;

public class LottoGameController {
    public static String errorContent = "";
    public static final String separator = ",";
    private static LottoNumberService lottoNumberService;
    private static WinningNumberService winningNumberService;
    private static BonusNumberService bonusNumberService;
    private static CalculateResultService calculateResultService;
    private List<Lotto> lottoList;

    public void run() {
        lottoList = new ArrayList<>();
        try {
            gameInit();

            Integer lottoSheetAmount = preparePurchaseAmount();
            Integer lottoSheetCount = preparePurchaseCount(lottoSheetAmount);
            prepareLottoRandomNumber(lottoSheetCount);

            Lotto winningNumber = inputWinningNumber();
            Integer bonusNumber = inputBonusNumber(winningNumber);

            calculateResult(lottoSheetAmount, winningNumber, bonusNumber);

            gameCleanUp();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            errorContent = "";
        }
    }

    public void gameInit() {
        lottoNumberService = new LottoNumberService();
        winningNumberService = new WinningNumberService();
        bonusNumberService = new BonusNumberService();
        calculateResultService = new CalculateResultService();
    }

    public void gameCleanUp() {
        lottoNumberService = null;
        winningNumberService = null;
        bonusNumberService = null;
        calculateResultService = null;
    }

    public Integer preparePurchaseAmount() {
        printStartMessage();
        Integer purchaseAmount = lottoNumberService.receiveLottoSheetsAmount();
        return purchaseAmount;
    }

    public Integer preparePurchaseCount(Integer purchaseAmount) {
        Integer lottoSheetCount = lottoNumberService.receiveLottoSheetsCount(purchaseAmount);
        printLottoSheetCountMessage(lottoSheetCount);
        return lottoSheetCount;

    }

    public void prepareLottoRandomNumber(Integer lottoSheetCount) {
        lottoList = lottoNumberService.generateRandomNumber(lottoSheetCount);
        for (Lotto lotto : lottoList) {
            printLottoNumber(lotto.getNumbers());
        }
    }

    public Lotto inputWinningNumber() {
        printWinningNumberMessage();
        Lotto winningNumber = winningNumberService.generateWinningNumber();
        return winningNumber;
    }

    public Integer inputBonusNumber(Lotto winningNumber) {
        printBonusNumberMessage();

        Integer bonusNumber = bonusNumberService.generateBonusNumber();
        bonusNumberService.checkBonusRange(bonusNumber);
        bonusNumberService.checkNotEqualWinningNumber(winningNumber.getNumbers(), bonusNumber);
        return bonusNumber;
    }

    public void calculateResult(Integer lottoSheetAmount, Lotto winningNumber, Integer bonusNumber) {
        Map<Rank, Integer> lottoResult = calculateResultService.compare(winningNumber.getNumbers(), bonusNumber, lottoList);
        printWinningResultMessage(lottoResult);
        double yield = calculateResultService.getYield(lottoSheetAmount, lottoResult);
        printYieldMessage(yield);
    }
}
