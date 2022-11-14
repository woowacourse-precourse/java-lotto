package lotto.view;

public class LottoView {
    // UI를 담당하는 로직

    // 로또 금액 입력 요청
    public void inputLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    // 로또 구매 수량 출력
    public void printLottoCount() {
        System.out.println();
        System.out.println("개를 구매했습니다.");
    }

    // 로또 발행 리스트 출력
    public void printLottoNumbers() {

    }

    // 당첨 번호 입력 요청
    public void inputLottoNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    // 보너스 번호 입력 요청
    public void inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    
    // 당첨 통계 출력
    public void printLottoResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - ");
    }

    // 수익률 출력
    public void printRateOfReturn() {
        System.out.println("총 수익률은");
    }
}
