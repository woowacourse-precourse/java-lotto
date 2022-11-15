package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Application {

    public String price = "";

    public String getPrice() {
        return price;
    }

    public List<Integer> randomLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        Collections.sort(numbers);
//        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public void getLottoPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        price = Console.readLine();

    }

    public void wrongPrice(String price){
        if(Integer.parseInt(price) % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void buyLotto(){
        int costs = Integer.parseInt(price);
        costs = costs / 1000;
        System.out.println(costs + "개를 구매했습니다.");
    }

    public void showLotto(){

    }

    public String[] getPrizeNum(){
        System.out.println("당첨 번호를 입력해주세요.");
        String prizeNum = Console.readLine();
        String[] getPrizeNum = prizeNum.split(",");
        return getPrizeNum;
    }

    public int getCntNum(String[][] allMyLotto, String[] getPrizeNum, int cntEqualNumber, int times, int getPN, int getAML){
        cntEqualNumber = 0;
        if (getPrizeNum[getPN].equals(allMyLotto[times][getAML])) {
            cntEqualNumber += 1;
        }
        return cntEqualNumber;
    }

    public int sameNumber(String[][] allMyLotto, String[] getPrizeNum, int cntEqualNumbers, int times){
        for(int j = 0 ; j < 6 ; j++){
            for(int k = 0 ; k < 6 ; k++) {
                cntEqualNumbers += getCntNum(allMyLotto,getPrizeNum, cntEqualNumbers, times, j, k);
            }
        }
        return cntEqualNumbers;
    }

    public int differST(String[][] allMyLotto, String bonusNum, int cntEqualNumber, int times){
        for(int j = 0 ; j < 6 ; j++){
            if(allMyLotto[times][j].equals(bonusNum)){
                cntEqualNumber += 2;
            }
        }
        return cntEqualNumber;
    }

    public void totalPrize(double winningRate, int firstPrize, int secondPrize, int thirdPrize,
                           int fourthPrize, int fifthPrize, int howManyTimes){
        winningRate = ((500 * fifthPrize) + (5000 * fourthPrize) + (150000 * thirdPrize)
                + (3000000 * secondPrize) + (200000000 * firstPrize))/(howManyTimes);

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + fifthPrize + "개");
        System.out.println("4개 일치 (50,000원) - " + fourthPrize + "개");
        System.out.println("5개 일치 (1,500,000원) - " + thirdPrize + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondPrize + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + firstPrize + "개");
        System.out.println("총 수익률은 " + (double)winningRate + "%입니다.");
    }


    public static void main(String[] args) {
        List<Integer> myLotto = null;
        String price = "";

        int firstPrize = 0;
        int secondPrize = 0;
        int thirdPrize = 0;
        int fourthPrize = 0;
        int fifthPrize = 0;

        double winningRate = 0;

        Application application = new Application();
        application.getLottoPrice();
        application.buyLotto();
        price = application.getPrice();

        int howManyTimes = (Integer.parseInt(price))/1000;
        int[] findPrize = new int[howManyTimes];        //구매한 로또가 각각 몇등인지 담겨있음
        String[][] allMyLotto = new String[howManyTimes][6];

        for(int i = 0 ; i < howManyTimes; i ++ ){
            myLotto = application.randomLotto();
            Lotto lotto = new Lotto(myLotto);
            for(int j = 0 ; j < 6; j++){
                allMyLotto[i][j] = String.valueOf(myLotto.get(j));
            }
            System.out.println(myLotto);
        }

        String[] getPrizeNum = application.getPrizeNum();

        System.out.println("보너스 번호를 입력해주세요.");
        String bonusNum = Console.readLine();
        for(int i = 0 ; i < howManyTimes; i ++){
            int cntEqualNumbers = 0;

            cntEqualNumbers = application.sameNumber(allMyLotto, getPrizeNum, cntEqualNumbers, i);
            if(cntEqualNumbers == 5){
                cntEqualNumbers = application.differST(allMyLotto,bonusNum,cntEqualNumbers,i);
            }
            findPrize[i] += cntEqualNumbers;
        }

        for(int i = 0 ; i < findPrize.length; i ++){
            if(findPrize[i] == 6){
                firstPrize += 1;
            }
            else if(findPrize[i] == 7){
                secondPrize += 1;
            }
            else if(findPrize[i] == 5){
                thirdPrize += 1;
            }
            else if(findPrize[i] == 4){
                fourthPrize += 1;
            }
            else if(findPrize[i] == 3){
                fifthPrize += 1;
            }
        }

        application.totalPrize(winningRate,firstPrize,secondPrize,thirdPrize,fourthPrize,fifthPrize,howManyTimes);
    }
}