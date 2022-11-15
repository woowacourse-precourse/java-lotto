package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        int bonusNumber = inputBonusNumber();
        //당첨 확인
        ArrayList<Integer> winList = winCount(lottoList, luckyList, bonusNumber);
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

        //todo: 잘못입력시 에러발생 1~45, 숫자
        String inputLuckyNumber[] = sc.next().split(",");
        for(int i=0; i<inputLuckyNumber.length; i++){
            luckyList.add(Integer.parseInt(inputLuckyNumber[i]));
        }

        return luckyList;
    }

    static int inputBonusNumber() {
        int bonusNumber=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("보너스 번호를 입력해 주세요.");

        //todo: 잘못입력시 에러발생 1~45, 숫자
        bonusNumber = sc.nextInt();

        return bonusNumber;
    }

    static ArrayList<Integer> winCount(List<Lotto> lottoList, List<Integer> luckyList, int bonusNumber){
        ArrayList<Integer> winList = new ArrayList<Integer>();
        ArrayList<Integer> difference;
        /*
        * 구매한 로또번호와 당첨번호를 차집합을 통해 비교
        * 차집합이 0일경우 1등
        * 차집합이 1일경우에 보너스가 일치하면 2등
        * 차집합이 1일경우에 보너스가 일치하지 않으면 3등
        * 차집합이 2일경우 4등
        * 차집합이 3일경우 5등
        */

        return winList;
    }



}
