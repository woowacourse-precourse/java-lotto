package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class Output {

    public static void printQuantity(int lottoQuantity) {
        System.out.println(System.lineSeparator() + lottoQuantity + OutputMessage.LOTTO_QUANTITY.getMessage());
    }

    public static void printAllLottoNumber(List<Lotto> lottoContainer) {
        for (Lotto lottoNumber : lottoContainer) {
            System.out.println(lottoNumber.getLotto());
        }
    }

    public static void printWinningStatics() {
        System.out.printf(System.lineSeparator() + OutputMessage.WINNING_STATICS.getMessage());
    }
}
