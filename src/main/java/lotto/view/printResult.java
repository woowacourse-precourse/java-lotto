package lotto.view;

public class printResult {
    public void printStart() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public void printList(int list) {
        System.out.println(list+"개를 구매했습니다.");
    }
    public void printNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public void printBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    public void printState() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
