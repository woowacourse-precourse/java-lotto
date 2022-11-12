package lotto;

import lotto.Service.LottoNumberService;

public class Application {
    public static String errorContent = "";


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoNumberService randomNumberService = new LottoNumberService();
            Integer purchaseAmount = randomNumberService.receiveLottoSheetsAmount();
            Integer lottoSheetCount = randomNumberService.receiveLottoSheetsCount(purchaseAmount);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("[ERROR]" + illegalArgumentException.getMessage());
        }


    }
}
