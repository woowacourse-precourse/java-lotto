package lotto;

import java.util.List;

public class LottoGameConsole {

    private final Emcee emcee = new Emcee();

    public void startLottoGame() {
        startingGuide();
        // 구입 금액 안내, 입력, 검증
        // Lotto 발행
        // 당첨 lotto 생성
        // 당첨 결과 처리, 출력
    }

    private void startingGuide() {
        String startingGuide = "Lotto game 에 오신 것을 환영합니다.\n" +
                "원하시는 만큼의 lotto 를 구매할 수 있으며 lotto 는 자동 발행됩니다.\n" +
                "당첨 번호와 보너스 번호를 생성하면 발행된 lotto 들의 당첨 여부를 계산합니다.\n" +
                "최종적으로 당첨 통계와 수익률을 알려드립니다.\n" +
                "게임을 시작하겠습니다.";
        System.out.println(startingGuide);
    }

    private int handleAmountOfPurchaseMoney() {
        // 구입 금액 입력 안내
        // 구입 금액 입력
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
