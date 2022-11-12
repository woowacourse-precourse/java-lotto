package lotto.ui;

public class Output {

    public static void printInputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printBoughtLotto(int lottoCount){
        System.out.printf("%d개를 구매했습니다.\n",lottoCount);
    }

    public static void printInputWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printExceptionError(){
        System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    public static void printWinningStatistics(){
        System.out.println("당첨 통계");
        System.out.println("---");

        // TODO
        // 당첨 내역 출력
        // n개 일치, k원, - i개
    }


}
