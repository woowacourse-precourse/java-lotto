package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        NumberGenerator numberGenerator = new NumberGenerator();

        System.out.println(Constant.INPUT_MESSAGE);
        int purchasePrice = numberGenerator.enterPurchasePrice();
        int purchaseQuantity = numberGenerator.calculatorLottoNumber(purchasePrice);

        System.out.println("\n" + purchaseQuantity + Constant.PURCHASE_MESSAGE);
        numberGenerator.createLottos(purchaseQuantity);
        numberGenerator.printLottos(numberGenerator.autoLotto);

        System.out.println("\n" + Constant.INPUT_LOTTO_NUMBERS);
        numberGenerator.enterLottoNumbers();
        Lotto lotto = new Lotto(numberGenerator.computerLotto);


        System.out.println(Constant.INPUT_BONUS_NUMBER);
        numberGenerator.enterBonusNumber();
        lotto.exceptionBonusNumberByDuplicatedLotto(numberGenerator.bonusNumber);
        lotto.exceptionBonusNumberOutOfRange(numberGenerator.bonusNumber);

        System.out.println("\n" + Constant.WINNING_STATISTICS);
        lotto.processLotto(numberGenerator.autoLotto, numberGenerator.bonusNumber, purchasePrice);

        /**
         * 구입금액을 입력해 주세요.
         * 8000
         *
         * 8개를 구매했습니다.
         * [8, 21, 23, 41, 42, 43]
         * [3, 5, 11, 16, 32, 38]
         * [7, 11, 16, 35, 36, 44]
         * [1, 8, 11, 31, 41, 42]
         * [13, 14, 16, 38, 42, 45]
         * [7, 11, 30, 40, 42, 43]
         * [2, 13, 22, 32, 38, 45]
         * [1, 3, 5, 14, 22, 45]
         *
         * 당첨 번호를 입력해 주세요.
         * 1,2,3,4,5,6
         *
         * 보너스 번호를 입력해 주세요.
         * 7
         *
         * 당첨 통계
         * ---
         * 3개 일치 (5,000원) - 1개
         * 4개 일치 (50,000원) - 0개
         * 5개 일치 (1,500,000원) - 0개
         * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
         * 6개 일치 (2,000,000,000원) - 0개
         * 총 수익률은 62.5%입니다.
         */
    }
}
