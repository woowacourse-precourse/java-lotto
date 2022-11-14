package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
//### 입력 받은 금액 예외처리
//### 금액을 통해 로또 개수 계산 메소드
//### 당첨 번호 추첨 메소드
//### 중복되는 번호 카운트 메소드
//### 에러 메세지 출력메소드 ?
//### 입력받은 번호 분리 메소드
//### 당첨금 합산 메소드
//### 수익률 계산 메소드
//### Enum활용하여 등수별 금액

    }
    /* 돈 입력받는 메소드 */
    public int getAmount(){
        System.out.println("구매금액을 입력해 주세요.");
        int amount = 0;
        try{
            amount = Integer.parseInt(readLine());
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
        return amount;
    }

    /* 몇개의 로또를 구입할 수 있는지 계산하는 메소드*/
    private int getNumberOfTimes(int amount){
        if(amount % 1000 != 0)
            throw new IllegalArgumentException();
        int lottoCount = amount / 1000;
        return lottoCount; //받에서 sout ~개를 구입하였습니다.
    }

//    /*로또 번호 자동생성 메소드*/
//    public List<Integer> makeLottoNumber(){
//        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//        System.out.println(lottoNumbers);
//        return lottoNumbers;
//
//    }


}
