package lotto;

import java.util.List;

public class LottoView {
    private String moneyQuestion = "구입금액을 입력해 주세요.";
    private String winNumberQuestion = "당첨 번호를 입력해 주세요.";
    private String numberFormatError = "[ERROR] 금액은 숫자만 입력 가능합니다.";
    private String invalidNumberError = "[ERROR] 금액은 1000원 이상이어야 하며 1000원 단위여야 합니다.";
    private String winNumberCountError = "[ERROR] 당첨 번호는 6개 있어야 합니다.";
    private String notProperNumberError = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    private String duplicatedNumberError = "[ERROR] 당첨 번호에 중복된 숫자가 있습니다.";
    public void printMoneyQuestion() {
        System.out.println(moneyQuestion);
    }
    public void printWinNumberQuestion() {
        System.out.println(winNumberQuestion);
    }
    public void printNumberFormatError() {
        System.out.println(numberFormatError);
    }

    public void printInvalidNumberError() {
        System.out.println(invalidNumberError);
    }

    public void printWinNumberCountError() {
        System.out.println(winNumberCountError);
    }

    public void printNotProperNumberError() {
        System.out.println(notProperNumberError);
    }

    public void printDuplicatedNumberError() {
        System.out.println(duplicatedNumberError);
    }
    public void printLottoList(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto i : lottos) {
            i.printLotto();
        }
    }
}
