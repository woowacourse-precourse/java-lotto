package domain;

public class LottoIssue {
    public int issueLotto(String userMoney){
        return Integer.parseInt(userMoney)/1000;
    }

    public static void handleInputMoneyException(String userMoney){
        if (Integer.parseInt(userMoney)%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 잘못된 금액입니다.");
        }
    }
}
