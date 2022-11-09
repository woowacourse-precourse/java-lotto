package lotto.view.output;

import java.util.List;

public class LottoPrinter {

    // 발행한 로또 수량을 출력한다.
    public void printTheNumberOfLottos(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    // 발행한 로또 번호를 출력한다.
    public void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    // 당첨 내역을 출력한다. (나중에 구현 후 변경)
//    public void printResults(Result result) {
//        System.out.println(result);
//    }

    // 수익률을 출력한다.
    public void printRateOfReturn(int rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    // 예외 메세지를 출력한다.
    public void printError(String errorMessage) {
        System.out.println("[ERROR]" + errorMessage);
    }

}
