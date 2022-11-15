package lotto.view.printer;

import lotto.domain.Lotto;

import java.text.NumberFormat;

public class OutputPrinter {
    public static void printBuyInformMessage(int numberOfLotto) {
        System.out.printf("%d개를 구매했습니다.%n", numberOfLotto);
    }

    public static void printLottoNumbers(Lotto lotto){
        System.out.println("["+lotto.toString()+"]");
    }
}
