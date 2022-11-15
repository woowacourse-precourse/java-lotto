package lotto.view;

import lotto.model.BuyingLottoList;
import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.List;

public class LottoResultView {

    public void printBuyResult(BuyingLottoList buyingLottoList) {

        System.out.println(buyingLottoList.getNumberOfLotto() + "개를 구매했습니다.");

        List<Lotto> buyingLottos = buyingLottoList.getLottoList();
        for (Lotto buyingLotto : buyingLottos) {
            List<Integer> buyingLottoNumber = buyingLotto.getNumbers();
            printLottoNumber(buyingLottoNumber);
        }
    }

    private void printLottoNumber(List<Integer> buyingLottoNumber) {

        StringBuilder printLottoMessage= new StringBuilder();
        int lottoSize = buyingLottoNumber.size();

        printLottoMessage.append("[");
        for (int index = 0; index < lottoSize; index++) {
            printLottoMessage.append(buyingLottoNumber.get(index));
            if (index < lottoSize - 1) {
                printLottoMessage.append(", ");
            }
        }
        printLottoMessage.append("]");

        System.out.println(printLottoMessage.toString());
    }

    public void printResult(LottoResult lottoResult) {

        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.getFifthCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.getFourthCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.getThirdCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.getSecondCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.getFirstCount() + "개");
        System.out.println("총 수익률은 "+ lottoResult.getProfit() + "%입니다.");
    }
}
