package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
//사용자가 로또는 몇개를 구매했는지 확인하는 메서드
    public static int countBuyGame(int buyMoney){
        int returnData = buyMoney / 1000;
        int remainder = buyMoney % 1000;
        if(remainder != 0){
            throw new IllegalArgumentException("[ERROR] 구매금액은 1000원 단위로 입력가능합니다.");
        }
        return returnData;
    }
    public static Lotto[] buyLotto (int buyCnt){
        Lotto[] returnData = new Lotto[buyCnt];

        for(int i = 0; i < buyCnt; i++){
            List<Integer> lottoNumber = inputLottoNumber();
            returnData[i] = new Lotto(lottoNumber);
        }

        return returnData;
    }
    public static List<Integer> convertStringToInt(String input){
        String[] inputSplit = input.split(",");
        List<Integer> returnData = new ArrayList<Integer>();
        for(int index = 0; index < inputSplit.length; index++){
            returnData.add(Integer.valueOf(inputSplit[index]));
        }
        return returnData;
    }
    public static List<Integer> inputLottoNumber(){
        String userInput = Console.readLine();
        List<Integer> returnData = convertStringToInt(userInput);
        return returnData;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

//        LottoWin a = LottoWin.getInstance();
//        int[] b_1 = {1000,1900};
//        int[] b_2 = {1000,2000};
//        int[] b_3 = {1000,2000};
//        List<int[]> b = List.of(b_1,b_2,b_3);
//
//        a.profitRateCal(b);
//        System.out.println(a.getLottoNum());


//        String a = "1,24,35,45,23";
//        int[] c = convertStringToInt(a);
//        for(int i = 0; i < c.length; i++){
//            System.out.println(c[i]);
//        }

    }
}
