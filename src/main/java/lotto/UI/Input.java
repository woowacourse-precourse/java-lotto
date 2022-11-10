package lotto.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Input {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public Input() {
    }

    public int howMuchLotto() throws IOException {
        int money = Integer.parseInt(br.readLine());
        return countLotto(money);
    }

    public int countLotto(int money){
        if(money % 1000 != 0){
            System.out.println("[ERROR] 잘못된 금액 입력 에러 발생");
            throw new IllegalArgumentException();
        }
        int count = money / 1000;
        return count;
    }
}
