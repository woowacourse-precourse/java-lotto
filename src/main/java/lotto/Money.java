package lotto;
import camp.nextstep.edu.missionutils.Console;

public class Money {
    public static int calcmoney (){
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        if (money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해주세요.");
        }
        int lotto = money / 1000;
        System.out.println(lotto + "개를 구매했습니다.");
        return lotto;
    }
}
