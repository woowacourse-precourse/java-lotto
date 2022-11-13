package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public int setMoney(){
        String inputMoney=Console.readLine();
        checkMoney(inputMoney);
        int money=Integer.parseInt(inputMoney);
        return money;
    }

    public boolean checkMoney(String inputMoney){
        return false;
    }

    public String setWinningLotto(){
        return "";
    }

    public boolean checkWinningLotto(){
        return false;
    }

    public int setBonusNumber(){
        return 0;
    }

    public boolean checkLotto(){
        return false;
    }
}
