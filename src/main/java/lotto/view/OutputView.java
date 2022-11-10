package lotto.view;

import lotto.model.Lotto;

import java.util.*;

public class OutputView {

    public void printLottoAmount(int lottoAmount){
        System.out.println(lottoAmount+"개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            printLottos(lottoNumbers);

        }
    }

    private static void printLottos(List<Integer> lottoNumbers) {
        printLeftBorder();
        printLotto(lottoNumbers);
        printRightBorder();
    }

    private static void printLotto(List<Integer> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            System.out.print(lottoNumbers.get(i));
            printComma(lottoNumbers, i);

        }
    }

    private static void printComma(List<Integer> lottoNumbers, int i) {
        if(i == lottoNumbers.size()-1) {
            return;
        }
        System.out.print(", ");
    }

    private static void printLeftBorder(){
        System.out.print("[");
    }

    private static void printRightBorder(){
        System.out.println("]");
    }
}
