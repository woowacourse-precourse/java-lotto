package lotto;

import java.util.List;

public class LottoGameConsole {

    private final Emcee emcee = new Emcee();
    private final Player player = new Player();
    private final Validator validator = new Validator();

    public void startLottoGame() {
        emcee.guideGame();
        // 구입 금액 안내, 입력, 검증
        // Lotto 발행
        // 당첨 lotto 생성
        // 당첨 결과 처리, 출력
    }

    private int handlePayment() {
        emcee.guideAmountOfPurchaseMoney();
        String amountOfPurchaseMoney = player.paymentOfPurchase();
        // 구입 금액 입력값 검증
        return 0;
    }

    private List<Lotto> publishLottos(int amountOfPurchaseMoney) {
        // 발행 개수 계산
        // 발행
        // 발행 lotto 출력
        return null;
    }

    private void createWinningLotto() {
        // 당첨 번호 생성
        // 보너스 번호 생성
        return; // 당첨 번호 + 보너스 번호
    }

    private List<Integer> createWinningNumbers() {
        // 당첨 번호 안내
        // 당첨 번호 입력
        // 당첨 번호 검증
        return null;
    }

    private int createBonusNumber() {
        // 보너스 번호 안내
        // 보너스 번호 입력
        // 보너스 번호 검증
        return 0;
    }

    private void handlePrizeOfLottoGame() {
        // 당첨 결과 처리
        // 당첨 결과 출력
    }
}
