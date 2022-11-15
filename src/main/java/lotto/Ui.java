package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Ui {

    private final LottoService lottoService = new LottoService();

    public void startLotto(){

        String purchaseAmount = inputPurchaseAmount();

        int lottoCount = lottoService.getLottoCount(purchaseAmount);
        lottoService.drawLottos(lottoCount);


    }

    private String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
         return readLine();
    }






}
