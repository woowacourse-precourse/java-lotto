package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static int getMoney(){
        String inputMoney = Console.readLine();
        isInteger(inputMoney);

        int money = Integer.parseInt((inputMoney));
        isSplit(money);

        return money;
    }
    public static void isSplit(int money){
        if (money % 1000 != 0){
            throw new IllegalArgumentException("다시 입력 해주세요");
        }
    }
    public static void isInteger(String inputMoney){
        for(int i = 0; i < inputMoney.length(); i++){
            if (inputMoney.charAt(i) < '0' || inputMoney.charAt(i) > '9' ){
                System.err.println("[ERROR]");
                throw new IllegalArgumentException("다시 입력 해주세요");
            }
        }
    }
    public static List<Integer> generateLotto(){ // 숫자 생성
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1,45,6);
        return lotto;
    }

    public static void printLotto(List<Integer> lotto){
        System.out.println(lotto);
    }

    public static List<Integer> getWinningNum() {
        String inputNum= Console.readLine();

        validateNum(inputNum);
        String[] inputNums = inputNum.split(",");

        List<Integer> winningNums = new ArrayList<>();
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

    public static void validateNumCnt(List<Integer> winningNums){
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
            throw new IllegalArgumentException("숫자 하나만 입력해 주세요");
        }
        if(bonusNum.charAt(0) < '0' || bonusNum.charAt(0) > '9'){
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
    }

    public static void execute(){
        int money = getMoney();
        int lottoCnt = money / 1000;
        String output = "";
        output += lottoCnt + "개를 구매했습니다.";
        System.out.println(output);
        List<Integer> lotto;
        List<List<Integer>> generatedLottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++){
            lotto = generateLotto();
            printLotto(lotto);
            generatedLottos.add(lotto);
        }

    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        execute();
    }

}
