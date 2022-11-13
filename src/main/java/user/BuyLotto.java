package user;

public class BuyLotto {
    public int countHowMany(int cash) {
        if (cash < 1000) throw new IllegalArgumentException("[ERROR] 값을 잘못 입력하였습니다.");
        if (cash % 1000 != 0) throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 합니다.");

        int result = cash / 1000;
        return result;
    }
}
