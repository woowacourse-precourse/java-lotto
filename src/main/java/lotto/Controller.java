package lotto;

public class Controller {
    public int getCount(int money) {
        int count = 0;
        if (money%1000 !=0) {
            System.out.println("[ERROR] 1,000원 단위가 아닙니다.");
            throw new IllegalArgumentException();
        }
        count = money/1000;
        return count;
    }


}
