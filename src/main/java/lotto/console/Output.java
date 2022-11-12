package lotto.console;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class Output {

    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final Output op = new Output();
    static final BufferedRecorder br = new BufferedRecorder();


    public static Output getOutput() {
        return op;
    }

    public static BufferedRecorder getBufferedRecorder() {
        return br;
    }

    public static class BufferedRecorder {

        public void writeBuyLotto(int cnt) throws IOException {
            bw.write(String.format("%d개를 구매했습니다.\n", cnt));
        }

        public void writeLotto(List<Integer> lst) throws IOException {
            bw.write(String.format("%s\n", lst.toString()));
        }

        public void writeStatistics() throws IOException{
            bw.write("당첨 통계\n---\n");
        }

        public void writeGrading(int correctCnt, int cnt) throws IOException {
            bw.write(String.format("%d개 일치, (%,d원) - %d개\n", correctCnt, 1000, cnt));
        }

        public void writeGradingWithBonusNumber(int correctCnt, int cnt) throws IOException {
            bw.write(String.format("%d개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", correctCnt, cnt));
        }

        public void writeRevenueRate(double rate) throws IOException {
            bw.write(String.format("총 수익률은 %.1f% 입니다.", rate));
        }

        public void writeNewLine() throws IOException{
            bw.newLine();
        }
    }

    public static void printWhenInputWinningNumber() throws IOException{
        bw.write("당첨 번호를 입력해주세요.\n");
        bw.flush();
    }

    public static void printWhenInputBonusNumber() throws IOException {
        bw.write("보너스 번호를 입력해 주세요.\n");
        bw.flush();
    }


    public static void printWhenInputCost() throws IOException {
        bw.write("구입금액을 입력해 주세요.\n");
        bw.flush();
    }

    public static void printBufferedStream() throws IOException {
        bw.flush();
    }

    public static void printError(String s) throws IOException {
        bw.write(String.format("[Error] %s",s));
    }
}
