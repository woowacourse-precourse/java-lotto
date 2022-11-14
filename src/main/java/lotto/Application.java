package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application extends Lotto {

    public String price = "";

    public Application(List<Integer> numbers) {
        super(numbers);
    }

    public void getLottoPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        price = Console.readLine();
    }

    public void buyLotto(){
        int costs = Integer.parseInt(price);
        costs = costs / 1000;
        System.out.println(costs + "개를 구매했습니다.");
    }

    public static void main(String[] args) {
        List<Integer> myLotto = null;
        String price = "";

        int firstPrize = 0;
        int secondPrize = 0;
        int thirdPrize = 0;
        int fourthPrize = 0;
        int fifthPrize = 0;

        System.out.println("구입금액을 입력해 주세요.");
        price = Console.readLine();     //구입금액

        int howManyTimes = (Integer.parseInt(price))/1000;
        int[] findPrize = new int[howManyTimes];        //구매한 로또가 각각 몇등인지 담겨있음
        int[][] allMyLotto = new int[howManyTimes][6];

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Application application = new Application(numbers);

//        myLotto = application.randomLotto();
        System.out.println(howManyTimes + "개를 구매했습니다.");

        for(int i = 0 ; i < howManyTimes; i ++ ){
            myLotto = application.randomLotto();
            for(int j = 0 ; j < 6; j++){
                allMyLotto[i][j] = myLotto.get(j);
            }
            System.out.println(myLotto);
        }

        System.out.println("당첨 번호를 입력해주세요.");
        String prizeNum = Console.readLine();
        //split으로 String 배열에 넣어야함
        String[] getPrizeNum = prizeNum.split(",");

        System.out.println("보너스 번호를 입력해주세요.");
        String bonusNum = Console.readLine();
        for(int i = 0 ; i < howManyTimes; i ++){
            int cntEqualNumbers = 0;
            for(int j = 0 ; j < 6 ; j++){
                if(getPrizeNum[j].equals(allMyLotto[i][j])){
                    cntEqualNumbers += 1;
                }
            }
            if(cntEqualNumbers == 5){
                for(int j = 0 ; j < 6 ; j++){
                    if(getPrizeNum[j].equals(bonusNum)){
                        cntEqualNumbers += 2;
                    }
                }
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

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + fifthPrize + "개");
        System.out.println("4개 일치 (50,000원) - " + fourthPrize + "개");
        System.out.println("5개 일치 (1,500,000원) - " + thirdPrize + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondPrize + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + firstPrize + "개");
    }
}