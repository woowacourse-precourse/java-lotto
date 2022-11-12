package lotto.console;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static lotto.service.Calculator.*;


public class Output {

    final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static class BufferedRecorder() {

        void writeBuyLotto(int cnt) throws IOException {
            bw.write(String.format("%d개를 구매했습니다.\n", cnt));
        }

        void writeStatistics() throws IOException{
            bw.write("당첨 통계\n---\n");
        }

        void writeGrading(int correctCnt, int cnt) throws IOException {
            bw.write(String.format("%d개 일치, (%,d원) - %d개\n", correctCnt, , cnt));
        }

        void writeGradingWithBonusNumber(int correctCnt, int cnt) throws IOException {
            bw.write(String.format("%d개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", correctCnt, cnt));
        }

        void writeRevenueRate(double rate) throws IOException {
            bw.write(String.format("총 수익률은 %.1f% 입니다.", rate));
        }

        void writeNewLine() throws IOException{
            bw.newLine();
        }
    }

    static class ErrorWriter() {

        // 아무 메소드
        void errProcess() {

        }
    }

    void printWhenInputWinningNumber() throws IOException{
        bw.write("당첨 번호를 입력해주세요.\n");
        bw.flush();
    }

    void printWhenInputBonusNumber() throws IOException {
        bw.write("보너스 번호를 입력해 주세요.\n");
        bw.flush();
    }


    void printWhenInputCost() throws IOException {
        bw.write("구입금액을 입력해 주세요.\n");
        bw.flush();
    }

    void printBufferedStream() throws IOException {
        bw.flush();
    }
}
