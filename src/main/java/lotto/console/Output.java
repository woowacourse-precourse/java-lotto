package lotto.console;

import lotto.domain.Statistic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;


public class Output {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class BufferedRecorder {

        public static void writeBuyLotto(int cnt) {
            System.out.println(String.format("%d개를 구매했습니다.\n", cnt));
        }

        public static void writeLotto(List<Integer> lst) {
            System.out.println(String.format("%s\n", lst.toString()));
        }

        public static void writeStatistics() {
            System.out.println("당첨 통계\n---\n");
        }

        public static void writeGrading(int idx, int correctCnt) {
            System.out.println(String.format(Statistic.getMsg(idx), correctCnt));
        }

        public static void writeRevenueRate(float rate) {
            System.out.println(String.format("총 수익률은 %.1f", rate) + "%입니다.");
        }

//        public static void writeNewLine() {
//            bw.newLine();
//        }
    }

    public static void printInputWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요.\n");
    }

    public static void printInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.\n");
    }

    public static void printInputCost() {
        System.out.println("구입금액을 입력해 주세요.\n");
    }

//    public static void printBufferedStream() {
//        bw.flush();
//    }
}