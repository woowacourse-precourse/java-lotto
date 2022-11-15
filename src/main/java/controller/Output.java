package controller;

import common.message.Message;
import domain.Lotto;
import domain.Rank;
import service.Calculator;

import java.util.List;

public class Output {

    public static void outputPurchaseLottosResult(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(lottos.size()).append(Message.COUNTING_BUY.getValue()).append('\n');

        for (Lotto lotto : lottos) {
            sb.append(lotto.toString()).append('\n');
        }

        System.out.print(sb);
    }

    public static void printResult(List<Rank> ranks, int lottosSize) {
        StringBuilder sb = new StringBuilder();
        sb.append(Message.TOTAL_START.getValue()).append('\n');
        sb.append(Message.CONTOUR.getValue()).append('\n');

        for (Rank rank : ranks) {
            sb.append(rank.toString());
        }

        sb.append(Message.TOTAL_RESULT_A.getValue())
                .append(Calculator.getYield(ranks, lottosSize))
                .append(Message.TOTAL_RESULT_B.getValue());

        System.out.println(sb);
    }
}
