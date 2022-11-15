package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Application {

    public String price = "";

    private static final String HOW_MUCH_LOTTO = "구입금액을 입력해주세요";
    private static final String YOU_BUY_LOTTO = "개를 구매했습니다.";
    private static final String INPUT_PRIZENUM = "당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUSNUM= "보너스 번호를 입력해주세요.";

    private static final String FIRST_WINNER = "6개 일치 (2,000,000,000원) - ";
    private static final String SECOND_WINNER = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String THIRD_WINNER = "5개 일치 (1,500,000원) - ";
    private static final String FOURTH_WINNER = "4개 일치 (50,000원) - ";
    private static final String FIFTH_WINNER = "3개 일치 (5,000원) - ";


    public String getPrice() {
        return price;
    }

    public List<Integer> randomLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        Collections.sort(numbers);
        return numbers;
    }

    public void getLottoPrice(){
        System.out.println(HOW_MUCH_LOTTO);
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
        System.out.println(costs + YOU_BUY_LOTTO);
    }

    public String[] getPrizeNum(){
        System.out.println(INPUT_PRIZENUM);
        String prizeNum = Console.readLine();
        String[] getPrizeNum = prizeNum.split(",");
        return getPrizeNum;
    }

    public String getBonusNum(){
        System.out.println(INPUT_BONUSNUM);
        String bonusNum = Console.readLine();
        return bonusNum;
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
        System.out.println(FIFTH_WINNER + fifthPrize + "개");
        System.out.println(FOURTH_WINNER + fourthPrize + "개");
        System.out.println(THIRD_WINNER + thirdPrize + "개");
        System.out.println(SECOND_WINNER + secondPrize + "개");
        System.out.println(FIRST_WINNER + firstPrize + "개");
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

        //구매금액/1000의 개수만큼 무작위 로또 발행 + 오류 발견시 예외처리
        for(int i = 0 ; i < howManyTimes; i ++ ){
            myLotto = application.randomLotto();
            Lotto lotto = new Lotto(myLotto);
            for(int j = 0 ; j < 6; j++){
                allMyLotto[i][j] = String.valueOf(myLotto.get(j));
            }
            System.out.println(myLotto);
        }

        String[] getPrizeNum = application.getPrizeNum();
        String bonusNum = application.getBonusNum();

        //일치하는 번호의 개수를 구함 + 2등과 3등을 구분
        for(int i = 0 ; i < howManyTimes; i ++){
            int cntEqualNumbers = 0;

            cntEqualNumbers = application.sameNumber(allMyLotto, getPrizeNum, cntEqualNumbers, i);
            if(cntEqualNumbers == 5){
                cntEqualNumbers = application.differST(allMyLotto,bonusNum,cntEqualNumbers,i);
            }
            findPrize[i] += cntEqualNumbers;
        }

        //구매한 로또들이 각각 몇등에 해당하는지에 대한 통계
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

        //당첨통계 및 수익률 계산
        application.totalPrize(winningRate,firstPrize,secondPrize,thirdPrize,fourthPrize,fifthPrize,howManyTimes);
    }
}