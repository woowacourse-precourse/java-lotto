package lotto.console;

import lotto.model.Lotto;
import lotto.model.LottoInfo;
import lotto.model.LottoResult;

import java.util.List;

public class PrintUtil {

    public static void printInsertMoney() {
        System.out.println("구입금액을 입력해주세요");
    }

    public static void printWinningLottoStatus() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printInsertBounsNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printInsertLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printPurchaseLottoStatus(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.", lottos.size());

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printLottoResult(LottoResult lottoResult, LottoInfo lottoInfo) {
        System.out.println(lottoResult);
        System.out.printf("총 수익률은 %.1f%%입니다.", lottoResult.getRateOfReturn
                                                                  (lottoInfo.getPurchaseAmount()));
    }
}
