package lotto;

import lotto.Model.Lotto;
import lotto.Service.BonusNumberService;
import lotto.Service.LottoNumberService;
import lotto.Service.WinningNumberService;

import java.util.ArrayList;
import java.util.List;

import static lotto.View.PrintView.*;
import static lotto.View.PrintView.printLottoNumber;

public class Application {
    public static String errorContent = "";
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final String separator = ",";


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Lotto> lottoList;
        try {
            printStartMessage();
            LottoNumberService lottoNumberService = new LottoNumberService();
            Integer purchaseAmount = lottoNumberService.receiveLottoSheetsAmount();
            Integer lottoSheetCount = lottoNumberService.receiveLottoSheetsCount(purchaseAmount);

            printLottoSheetCountMessage(lottoSheetCount);
            lottoList = lottoNumberService.generateRandomNumber(lottoSheetCount);
            for(Lotto lotto : lottoList){
                printLottoNumber(lotto.getNumbers());
            }

            printWinningNumberMessage();
            WinningNumberService winningNumberService = new WinningNumberService();
            Lotto winningNumber = winningNumberService.generateWinningNumber();

            BonusNumberService bonusNumberService = new BonusNumberService();
            Integer bonusNumber = bonusNumberService.generateBonusNumber();
            bonusNumberService.checkBonusRange(bonusNumber);
            bonusNumberService.checkNotEqualWinningNumber(winningNumber.getNumbers(), bonusNumber);

        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            errorContent = "";
        }


    }
}
