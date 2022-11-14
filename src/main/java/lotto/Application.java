package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

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

        int amount = getAmount(); //돈입력
        int lottoCount = getNumberOfTimes(amount); //로또 몇개 살 수 있는지 숫자 계산
        List<ArrayList<Integer>> lottos = new ArrayList<>();
        for(int lotto = 0; lotto < lottoCount; lotto++){
            lottos.add((ArrayList<Integer>) makeLottoNumber());
        }
        String winnigNumber = getWinningNumber(); //로또 정답 받기.
        List<Integer> winningNumbers = StringToIntegerList(winnigNumber); // List<Integer>로 변환
        checkIsValid(winningNumbers);//제대로된 값이 들어왔는지 확인하는 메소드

    }
    /* 돈 입력받는 메소드 */
    public static int getAmount(){
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
    private static int getNumberOfTimes(int amount){
        if(amount % 1000 != 0)
            throw new IllegalArgumentException();
        int lottoCount = amount / 1000;
        return lottoCount; //받에서 sout ~개를 구입하였습니다.
    }

    /*로또 번호 자동생성 메소드*/
    public static List<Integer> makeLottoNumber(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        System.out.println(lottoNumbers);
        return lottoNumbers;
    }

    /*당첨번호 입력 메소드*/
    public static String getWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요");
        String winningNumber = readLine();
        return winningNumber;
    }

    /*당첨번호를 list<Integer>로 바꾸는 메소드 */
    public static List<Integer> StringToIntegerList(String winningNumber){
        List<String> seperatedString = Arrays.asList(winningNumber.split(","));
        List<Integer> winningNumbers = new ArrayList<>();
        for(String character : seperatedString){
            winningNumbers.add(Integer.parseInt(character));
        }
        return winningNumbers;
    }

    /*중복되는 값이 있는지, 입력된 값이 6개인지 확인하는메소드*/
    public static void checkIsValid(List<Integer> winningNumbers){
        Set<Integer> noDuplicableSet = new HashSet<>(winningNumbers);
        if(noDuplicableSet.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    /*보너스 번호를 입력받는 메소드*/
    public static int getBonusNum(){
        //try
        int bonusNum = Integer.parseInt(readLine());
        return bonusNum;
    }


}
