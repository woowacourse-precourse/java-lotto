package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void printLottoQuantity(int quantity) {

        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> lottoNumberList) {

        System.out.print("[");

        for (int i = 0; i < lottoNumberList.size() - 1; i++) {
            System.out.print(lottoNumberList.get(i) + ", ");
        }

        System.out.println(lottoNumberList.get(lottoNumberList.size() - 1) + "]");
    }

    public static void printWinningNumbersInputBox() {

        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputBox() {

        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
