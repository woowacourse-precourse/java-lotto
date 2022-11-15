package lotto.view;

import java.text.NumberFormat;
import java.util.EnumMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.ResultEnum;

public class Message {

    public void printPurchaseMsg() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public void printPurchaseLotto(List<Lotto> lottos) {
        int amount = lottos.size();
        System.out.println("\n" + amount + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
    public void printPlsInputWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printPlsInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printMsg(String msg) {
        System.out.println(msg);
    }
    public void printResult(EnumMap<ResultEnum, Integer> result, Double roi) {
        NumberFormat rewardFormat = NumberFormat.getNumberInstance();
        printMsg("\n" + "당첨 통계" + "\n" + "---");
        for (ResultEnum resultEnum : result.keySet()) {
            Integer hitAmount = resultEnum.getHitAmount();
            Integer prize = resultEnum.getRewardAmount();
            Integer amount = result.get(resultEnum);

            if (resultEnum == ResultEnum.HIT_5_AND_BONUS) {
                printMsg(hitAmount + "개 일치, 보너스 볼 일치 (" + rewardFormat.format(prize) + "원)" + " - "
                    + amount + "개");
                continue;
            }
            printMsg(
                hitAmount + "개 일치 (" + rewardFormat.format(prize) + "원)" + " - " + amount + "개");
        }
        printMsg("총 수익률은 " + roi + "%입니다.");
    }
}
