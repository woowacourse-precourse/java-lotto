package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    public static int getMoney(){
        String inputMoney = Console.readLine();
        isInteger(inputMoney);

        int money = Integer.parseInt((inputMoney));
        isSplit(money);

        int lottoCnt;
        lottoCnt = money / 1000;
        return lottoCnt;
    }
    public static void isSplit(int money){
        if (money % 1000 != 0){
            throw new IllegalArgumentException("다시 입력 해주세요");
        }
    }
    public static void isInteger(String inputMoney){
        for(int i = 0; i < inputMoney.length(); i++){
            if (inputMoney.charAt(i) < '0' || inputMoney.charAt(i) > '9' ){
                throw new IllegalArgumentException("다시 입력 해주세요");
            }
        }
    }
    public static ArrayList<Integer> generateLotto(){ // 숫자 생성
        ArrayList<Integer> lotto = new ArrayList<>();
        while (lotto.size() < 8) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!lotto.contains(randomNumber)) {
                lotto.add(randomNumber);
            }
        }
        return lotto;
    }

    public static void printLotto(ArrayList<Integer> lotto){
        System.out.println(lotto);
    }

    public static ArrayList<Integer> getWinningNum() {
        String inputNum= Console.readLine();
        validateNum(inputNum);

        String[] inputNums = inputNum.split(",");
        ArrayList<Integer> winningNums = new ArrayList<>();
        for(String num:inputNums){
            winningNums.add(Integer.parseInt(num.trim()));
        }
        validateNumCnt(winningNums);
        return winningNums;
    }

    public static void validateNum(String inputNum){
        for (int i = 0; i < inputNum.length(); i++){
            if(inputNum.charAt(i) == ','){
                continue;
            }
            if (inputNum.charAt(i) < '0' || inputNum.charAt(i) > '9' ){
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateNumCnt(ArrayList<Integer> winningNums){
        if (winningNums.size() != 6){
            throw new IllegalArgumentException();
        }
    }

    public static int getBonusNum(){
        String inputNum= Console.readLine();
        int bonusNum;
        validateBonusNum(inputNum);
        bonusNum = Integer.parseInt(inputNum);
        return bonusNum;
    }

    public static void validateBonusNum(String bonusNum){
        if(bonusNum.length() != 1){
            throw new IllegalArgumentException();
        }
        if(bonusNum.charAt(0) < '0' || bonusNum.charAt(0) > '9'){
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

}
