package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        runLottoApp();
    }
    public static void runLottoApp(){
        int lottoCount = howMuchLottoBuy();
    }
    public static int howMuchLottoBuy(){
        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();
        moneyErrorCheck(money);
        return Integer.parseInt(money)/1000;
    }
    public static void moneyErrorCheck(String money){
        for(int i = 0 ; i < money.length() ;i++){
            if(!Character.isDigit(money.charAt(i))){
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해야합니다.");
            }
        }
        if((Integer.parseInt(money) % 1000) != 0)
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000으로 나누어 떨어져야합니다.");
    }
}
