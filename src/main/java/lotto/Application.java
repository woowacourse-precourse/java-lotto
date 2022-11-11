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
    public static int overlapCnt(List<Integer> lottoNum, List<Integer> winningNum){
        int cnt = 0;
        for (int num : lottoNum){
            if (winningNum.contains(num)){
                cnt += 1;
            }
        }
        return cnt;
    }
    public static int compareNumbers(List<Integer> lottoNum, List<Integer> winningNum, int bonusNum){
        int output = 5;
        int correctCnt = overlapCnt(lottoNum, winningNum);
        if (correctCnt == 6){
            output = 4;
        }else if (correctCnt == 5 && lottoNum.contains(bonusNum)){
            output = 3;
        }else if (correctCnt == 5){
            output = 2;
        }else if (correctCnt == 4){
            output = 1;
        }else if (correctCnt == 3){
            output = 0;
        }
        return output;
    }

    public static void printStatistic( List<List<Integer>> generatedLottos, List<Integer> winnigNum, int bonusNum, int money){
        int[] winCnt = {0,0,0,0,0};
        int winningPrice = 0;

        for (List<Integer> generatedLotto : generatedLottos){
            int winGrade = compareNumbers(generatedLotto, winnigNum, bonusNum);
            if (winGrade == 5){
                continue;
            }
            winCnt[winGrade] += 1;
        }
        for(int i = 0; i < 5; i++){
            if(i == 0){
                winningPrice += 5000 * winCnt[i];
                System.out.println("3개 일치 (5,000원) - " + winCnt[i] + "개");
            }else if(i == 1){
                winningPrice += 50000 * winCnt[i];
                System.out.println("4개 일치 (50,000원) - "+ winCnt[i]+ "개");
            }else if(i == 2){
                winningPrice += 1500000 * winCnt[i];
                System.out.println("5개 일치 (1,500,000원) - "+ winCnt[i]+ "개");
            }else if(i == 3){
                winningPrice += 30000000 * winCnt[i];
                System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ winCnt[i]+ "개");
            }else if(i == 4){
                winningPrice += 2000000000 * winCnt[i];
                System.out.println("6개 일치 (2,000,000,000원) - "+ winCnt[i]+ "개");
            }
        }

        System.out.format("총 수익률은 %.1f%%입니다.",(float)winningPrice / (float)money * 100.0);

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

        List<Integer> winnigNum = getWinningNum();

        int bonusNum = getBonusNum();

        printStatistic(generatedLottos, winnigNum, bonusNum, money);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        execute();
    }

}
