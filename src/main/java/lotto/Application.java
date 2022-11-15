package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        
        
        //구입금액
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해주세요.");
        
        ////todo: 1000원으로 나누어떨어지지않으면 오류발생시키기 추가예정
        int buyMoney = sc.nextInt();

        //로또 구매및 출력
        ArrayList<Lotto> lottoList = buyLotto(countPurchaseLotto(buyMoney));

        //당첨번호 입력받기
        ArrayList<Integer> luckyList = inputLuckyNumber();
        //보너스 번호 입력받기
        //당첨 확인
        //당첨통계
        //수익률 출력

    }
    static int countPurchaseLotto(int buyMoney) {

        return buyMoney % 1000;
    }

    static ArrayList<Lotto> buyLotto(int countPurchase){

        ArrayList<Lotto> lottoList = new ArrayList<Lotto>();
        for(int i=0; i<countPurchase; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            System.out.println(numbers.toString());
            lottoList.add(new Lotto(numbers));

        }
        return lottoList;
    }

    static ArrayList<Integer> inputLuckyNumber(){
        ArrayList<Integer> luckyList = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("당첨 번호를 입력해 주세요.");

        //todo: 잘못입력시 에러발생
        String inputLuckyNumber[] = sc.next().split(",");
        for(int i=0; i<inputLuckyNumber.length; i++){
            luckyList.add(Integer.parseInt(inputLuckyNumber[i]));
        }

        return luckyList;
    }


}
