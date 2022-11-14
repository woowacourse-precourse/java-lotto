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

        System.out.println("구입금액을 입력해 주세요.");
        price = Console.readLine();     //구입금액

        int howManyTimes = (Integer.parseInt(price))/1000;
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

        System.out.println("보너스 번호를 입력해주세요.");
        String bonusNum = Console.readLine();
    }
}
