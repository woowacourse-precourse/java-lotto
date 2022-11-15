package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int amount;
        int quantity;
        List<Lotto> LottoList = Collections.emptyList();
        Scanner sc = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        amount = sc.nextInt();
        if(amount % 1000 != 0){
            throw new IllegalArgumentException();
        }
        quantity = amount/1000;
        System.out.println(quantity+"개를 구매했습니다.\n");

        while(LottoList.size() < quantity){
            Lotto temp = new Lotto(RandomLotto());
            LottoList.add(temp);
        }

        for(Lotto data: LottoList){
            data.printNumber();
        }

    }

    static public List<Integer> RandomLotto(){
        List<Integer> tempList = Collections.emptyList();

        while(tempList.size() < 6){
            int temp = Randoms.pickNumberInList(1,45);
            if(tempList.indexOf(temp) != -1){
                break;
            }
            tempList.add(temp);
        }
        Collections.sort(tempList);
        return tempList;
    }
}
