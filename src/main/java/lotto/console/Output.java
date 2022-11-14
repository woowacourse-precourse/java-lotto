package lotto.console;

import lotto.domain.Statistic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;


public class Output {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class BufferedRecorder {

        public static void writeBuyLotto(int cnt) throws IOException {
            bw.write(String.format("%d개를 구매했습니다.\n", cnt));
        }

        public static void writeLotto(List<Integer> lst) throws IOException {
            bw.write(String.format("%s\n", lst.toString()));
        }

        public static void writeStatistics() throws IOException{
            bw.write("당첨 통계\n---\n");
        }

        public static void writeGrading(int idx, int correctCnt) throws IOException {
            bw.write(String.format(Statistic.getMsg(idx), correctCnt));
        }

        public static void writeRevenueRate(float rate) throws IOException {
            bw.write(String.format("총 수익률은 %.1f", rate) + "% 입니다.");
        }

        public static void writeNewLine() throws IOException {
            bw.newLine();
        }
    }

    public static void printInputWinningNumber() throws IOException{
        bw.write("당첨 번호를 입력해주세요.\n");
        bw.flush();
    }

    public static void printInputBonusNumber() throws IOException {
        bw.write("보너스 번호를 입력해 주세요.\n");
        bw.flush();
    }

    public static void printInputCost() throws IOException {
        bw.write("구입금액을 입력해 주세요.\n");
        bw.flush();
    }

    public static void printBufferedStream() throws IOException {
        bw.flush();
    }
}