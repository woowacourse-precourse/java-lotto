package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static final int THOUSAND=1000;
    private static final int LOTTONUMCOUNT=6;

    public int setMoney(){
        String inputMoney=Console.readLine();
        checkMoney(inputMoney);
        int money=Integer.parseInt(inputMoney);
        return money;
    }

    public void checkMoney(String inputMoney){
        if(!inputMoney.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액에 숫자만 입력하세요.");
        }
        int money=Integer.parseInt(inputMoney);
        if(money%THOUSAND!=0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 천원으로 나누어 떨어져야 합니다.");
        }
    }

    public String setWinningLotto(){
        String inputWinningLotto=Console.readLine();
        checkWinningLotto(inputWinningLotto);
        String[] lottoNumArray=inputWinningLotto.split(",");
        for(int index=0;index<LOTTONUMCOUNT;index++){
            checkLotto(lottoNumArray[index]);
        }

        return inputWinningLotto;
    }

    public int setBonusNumber(){
        String inputBonusNumber=Console.readLine();
        checkLotto(inputBonusNumber);
        int bonusNumber=Integer.parseInt(inputBonusNumber);
        return bonusNumber;
    }

    public void checkLotto(String inputWinningLotto){
        if(!inputWinningLotto.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액에 숫자만 입력하세요.");
        }
        int winningLotto=Integer.parseInt(inputWinningLotto);
        if(winningLotto<1||winningLotto>45){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void checkWinningLotto(String inputWinningLotto){

    }


}
