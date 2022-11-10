package exceptioncase;

public class PurchaseException {
    public static void inputMoneyException(String money){
        if(money.length()!=money.replaceAll("^0-9", "").length())
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        int moneyint= Integer.valueOf(money);
        if(moneyint%1000 !=0)
            throw  new IllegalArgumentException("[ERROR] 1000의 배수를 입력해주세요");
    }
}
