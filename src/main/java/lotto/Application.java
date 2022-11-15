package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 구매금액 입력받아 발행 로또 수량 계산하기
        PurchaseAmount purchaseAmount = new PurchaseAmount();
        purchaseAmount.inputPurchaseAmount();

        // 로또 번호 발행
        Publishing publishing = new Publishing();
        publishing.publishingLotto(purchaseAmount.getPurchaseNumber());

        // 당첨번호 입력
        LuckyNumber luckyNumber = new LuckyNumber();
        luckyNumber.inputLuckyNumber();

        // 보너스번호 입력
        BonusNumber bonusNumber = new BonusNumber();
        bonusNumber.inputBonusNumber();;

        // 당첨 계산
        LuckyCheck luckyCheck = new LuckyCheck();
        luckyCheck.checkLuckyLottos(publishing.getLottoList(), luckyNumber.getLuckyNumber(),
            bonusNumber.getBonusNumber());
        luckyCheck.printStatistic(purchaseAmount.getPurchaseMoney());
    }
}
