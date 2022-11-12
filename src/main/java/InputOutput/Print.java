package InputOutput;

import java.util.Collections;
import java.util.List;

public class Print {

    public static void buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void lottoCount(int count) {
        System.out.println(String.format("%d개를 구입했습니다.", count));
    }

    public static void winningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void BonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void errorMessage(String message){
        System.out.println(String.format("[ERROR] %s", message));
    }

    public static void lottoNumber(List<List<Integer>> lottoes){
        for (List<Integer> lotto : lottoes) {
            Collections.sort(lotto);
            System.out.println(lotto);
        }

    }
}
