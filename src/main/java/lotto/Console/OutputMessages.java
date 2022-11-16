package lotto.Console;

import java.util.List;

public class OutputMessages {

    //Number -> Num으로 축약해서 사용
    //Message -> Msg로 축약해 사용
    public static final String errorMessage = "[ERROR]";

    public void inputMoneyMsg() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void countEnterMsg(Integer countEnter) {
        System.out.println(countEnter+"개를 구매했습니다.");
    }

    public void printLottoList(List<Integer> list) {
        System.out.println(list);
    }

    public void winNumInputMsg() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void bonusNumInputMsg() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void totalResultMsg(int fifth, int fourth, int third, int second, int first, String earningRate) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - "+fifth+"개");
        System.out.println("4개 일치 (50,000원) - "+fourth+"개");
        System.out.println("5개 일치 (1,500,000원) - "+third+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+second+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+first+"개");
        System.out.println("총 수익률은 "+earningRate+"%입니다.");
    }

    public String CashIsNotInt() {
        return errorMessage+" : input string 형태가 숫자가 아닙니다.";
    }

    public OutputMessages() {

    }

}
