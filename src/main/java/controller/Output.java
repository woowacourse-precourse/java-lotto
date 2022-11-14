package controller;

import common.message.Message;
import domain.Lotto;

import java.util.List;

public class Output {

    public static void outputPurchaseLottosResult(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder(lottos.size());
        sb.append(Message.COUNTING_BUY.getValue()).append('\n');

        for(Lotto lotto : lottos) {
            sb.append(lotto.toString()).append('\n');
        }

        System.out.print(sb);
    }
}
