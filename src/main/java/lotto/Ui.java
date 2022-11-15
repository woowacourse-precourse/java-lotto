package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Ui {

    private final LottoService lottoService = new LottoService();

    public void startLotto(){

        String purchaseAmount = inputPurchaseAmount();

        int lottoCount = lottoService.getLottoCount(purchaseAmount);

        lottoService.drawLottos(lottoCount);

        printLottoCountAndNumbers(lottoCount);

        String winNumber= inputWinNumber();

        String bonusNumber= inputBonusNumber();

        List<Integer> numbersOfWin = lottoService.findNumbersOfWin(winNumber, bonusNumber);


    }

    private String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        //당연히 validation 있어야 하고
        return readLine();
    }

    private String inputWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        //validation 있어야 하고
        return readLine();
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
