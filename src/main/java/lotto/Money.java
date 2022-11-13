package lotto;

public class Money {

    public static int num_lotto(int money) {
        int num = 0;
        num = money / 1000 ;
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1,000 단위의 금액을 입력하세요");
        }
        return num;
    }

}
