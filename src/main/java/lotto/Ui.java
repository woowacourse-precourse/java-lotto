package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Ui {

    private final LottoService lottoService = new LottoService();

    public void startLotto(){

        String purchaseAmount = inputPurchaseAmount();

        int lottoCount = lottoService.getLottoCount(purchaseAmount);

        lottoService.drawLottos(lottoCount);

        printLottoCountAndNumbers(lottoCount);



    }

    private void printLottoCountAndNumbers(int lottoCount) {
        System.out.println(lottoCount +"개를 구매했습니다.");
        for (Lotto lotto : lottoService.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    private String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
         return readLine();
    }






}
