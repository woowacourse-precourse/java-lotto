package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        
        
        //구입금액
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해주세요.");

        int buyMoney = sc.nextInt();

        //로또 구매및 출력
        ArrayList<Lotto> lottoList = buyLotto();
        
        //당첨번호 입력받기
        //보너스 번호 입력받기
        //당첨 확인
        //당첨통계
        //수익률 출력

    }
    static int countPurchaseLotto(int buyMoney) {
        int countPurase=0;

        return countPurase;
    }

    static ArrayList<Lotto> buyLotto(){

        ArrayList<Lotto> lottoList = new ArrayList<Lotto>();
        //List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return lottoList;
    }


}
