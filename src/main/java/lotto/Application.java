package lotto;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        Integer lottoCount = 0;
        try {
            lottoCount = lottoController.getUserLottoCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        List<Lotto> issuedLotto = lottoController.issueLotto(lottoCount);
        lottoController.showIssueResult(issuedLotto);

        Lotto lotto = lottoController.getLottoInput();
        Integer bonus = lottoController.getBonusInput();

        lottoController.computeResult(issuedLotto, lotto, bonus);
        lottoController.printResult();
        lottoController.printYield(lottoCount);

    }
}
