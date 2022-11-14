package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int buylotto = askmoney();
        Random random = new Random();
        // TODO: 프로그램 구현
    }
    public static int askmoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        int buymoney = Integer.parseInt(input), buylotto;

        if(buymoney%1000 != 0)
            throw new IllegalArgumentException("[ERROR] 금액은 천원 단위여야 합니다.");
        buylotto = buymoney / 1000;
        System.out.println("\n"+buylotto+"개를 구매했습니다.");
        return buylotto;
    }
}
