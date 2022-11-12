package lotto;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchasedLottoNumber;

        purchasedLottoNumber = purchaseLotto();
        System.out.println();
        System.out.println(purchasedLottoNumber+"개를 구매했습니다.");

    }
    public static int purchaseLotto(){
        int cost;

        System.out.println("구입금액을 입력해 주세요.");
        try{
            cost = Integer.parseInt(Console.readLine());
        }
        catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력하세요.");
        }
        if (cost % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위에 금액을 입력하세요.");
        }
        return cost/1000;
    }
}
