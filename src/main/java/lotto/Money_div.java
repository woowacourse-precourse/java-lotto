package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Money_div {

    private static final int MIN_COST = 1000;

    private final int money;

    public Money_div(int money){
        validateNum(money);
        this.money = money;
    }

    public int LottoCount() {
        return money / MIN_COST;
    }

    public void Profit(double total_sum) {
        double percent = (total_sum/money)*100;

        System.out.println("총 수익률은" +percent+"%입니다.");
    }

    public void Game() {
//        String lotto_num = getUserInput();
//        int lotto_nums = Integer.parseInt(lotto_num);
//        if ((lotto_nums%1000) != 0) {
//            throw new IllegalArgumentException("[ERROR]구매금액은 1천원 단위입니다.");
//        }
//        money = lotto_nums/1000;


    }

    private void validateNum(int money) {
        validateMinMoney(money);
        validateDivisible(money);
    }

    private void validateMinMoney(int money) {
        if (money < MIN_COST) {
            throw new IllegalArgumentException("[ERROR]구매금액은 최소 1천원입니다.");
        }
    }

    private void validateDivisible(int money) {
        if (money % MIN_COST !=0) {
            throw new IllegalArgumentException("[ERROR]구매금액은 1천원 단위입니다.");
        }
    }



    public String getUserInput() {
        System.out.println("구매금액을 입력해주세요");
        return readLine();
    }

}
