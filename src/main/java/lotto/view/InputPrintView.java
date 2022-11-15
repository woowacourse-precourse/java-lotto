package lotto.view;

import java.io.IOException;

import static lotto.view.OutputLotto.bw;

public class InputPrintView {
    public static void initInput(){
        try {
            bw.append("구입금액을 입력해 주세요.\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void buyView(int lottoCount){
        try {
            bw.append(lottoCount+"개를 구매했습니다.\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void inputView_First(){
        try {
            bw.append("당첨 번호를 입력해 주세요.\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void inputView_Second() {
        try {
            bw.append("보너스 번호를 입력해 주세요.\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
