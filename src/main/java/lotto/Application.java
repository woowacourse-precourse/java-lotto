package lotto;

import lotto.Model.Lotto;
import lotto.Model.LottoManager;
import lotto.View.LottoManagerView;

public class Application {
    private static final LottoManager manager = new LottoManager();
    private static final LottoManagerView view = new LottoManagerView();
    public static void main(String[] args) {
        // 사용자에게 로또 구입 금액 입력받기 -> Lotto View, validate 에러 처리
        getUserMoney();



        // 로또 수량만큼 로또 발행하기 -> Lotto Manager, issue (Lotto 리스트에 담아 발행)
        // 구매 내역 출력하기 -> Lotto View
        // 당첨, 보너스 번호 입력받기 -> Lotto View, validate 에러 처리 (Lotto 리스트에 담아 Lotto Manager에 저장)
        // 당첨 내역 구하기 -> LottoManager
        // 수익률 구하기 -> LottoManager
        // 당첨 통계 출력하기 -> Lotto View (Lotto Manager 에서 메서드 호출)
    }

    private static void getUserMoney(){
        manager.getUserMoney(view.inputUserMoney());
    }
}
