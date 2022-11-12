package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //구입금액 입력 받기
        int price = InputNum.askPrice();
        int lotto_cnt = Calculate.countLotto(price);

        System.out.println("lotto_cnt = " + lotto_cnt);

    }
}
