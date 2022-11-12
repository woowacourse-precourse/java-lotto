package lotto;

public class LottoShop {
    LottoConsole lottoConsole = new LottoConsole();

    public int buyLotto(){
        return checkMoney(lottoConsole.inputMoney());
    }

    private int checkMoney(String inputMoney){
        int money = changeStringToInteger(inputMoney);
        if((money%1000) != 0){
            throw new IllegalArgumentException("[ERROR] 입력된 값이 1000원 단위가 아닙니다.");
        }
        return money;
    }

    private int changeStringToInteger(String s1){
        try {
            int int1 = Integer.parseInt(s1);
            return int1;
        } catch(NumberFormatException exception){
            throw new NumberFormatException("[ERROR] 입력된 값이 숫자가 아닙니다.");
        }
    }
}