package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyLotto buyLotto = new BuyLotto(InputBuyNum());

        //구매금액 입력
        public static String InputBuyNum() {
            System.out.println("구매금액을 입력해 주세요");
            String buyNum = readLine();
            return buyNum;
        }
    }
}
