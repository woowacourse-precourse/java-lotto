package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.ui.*;

public class Application {
    public static void main(String[] args) {
        int count = 0;
        boolean bonusCheck=false;
        int price=0;
        String msg="";
        List<List<Integer>> lottoNumbers= new ArrayList<>();

        // 입력
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());

        // 입력 예외 처리
        MoneyException moneyException = new MoneyException(money);

        // 입력 수 만큼 6개의 랜덤 숫자 생성
        count = money / 1000;
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lottoNumber);
            lottoNumbers.add(lottoNumber);
        }
        // 생성한 랜덤 숫자 배열 출력
        System.out.println("\n"+count+"개를 구매했습니다.");
        for (int i=0;i<count;i++){
            System.out.println(lottoNumbers.get(i));
        }

        // 사용자로부터 번호 입력 받음
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String userNumbers = Console.readLine();
        NumberSplit numberSplit = new NumberSplit(userNumbers);

        // 사용자 입력 검증
        Lotto lotto = new Lotto(numberSplit.getNumber());

        // 사용자 수와 로또의 수 비교
        Compare[] compare = new Compare[count];
        for (int i=0;i<count;i++) {
            compare[i] = new Compare(numberSplit.getNumber(), lottoNumbers.get(i));
            //System.out.println(compare[i].getSame());   // 잘 작동하는 지 확인하는 코드
        }

        // 보너스 번호
        int []arrCount=new int[5];
        int winningGrade=0;
        WinningCount winningCount = new WinningCount();
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        for (int i=0;i<count;i++) {
            List<Integer> lottoNumber = lottoNumbers.get(i);
            Bonus bonus = new Bonus(lottoNumber, bonusNumber);
            bonusCheck = bonus.getBonusCheck();

            // 당첨 내역 구하기
            winningCount.init();
            winningGrade= winningCount.count(compare[i].getSame(),bonusCheck);
            if (winningGrade==-1)   continue;
            arrCount[winningGrade]++;
            //System.out.println(compare[i].getSame()+"개"+"즉,"+(6-winningGrade)+"가 일치하여 "+(winningGrade+1)+"등입니다.");
        }
        // 당첨 내역 출력
        WinningPrint winningPrint = new WinningPrint(arrCount);
        // 수익률
    }
}
