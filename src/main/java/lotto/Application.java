package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//예외처리
//1.로또 숫자 갯수
//2.로또 중복 숫자 포함
//3.사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료
//4.로또 구입 금액 1,000원으로 나누어 떨어지지 않는 경우 예외 처리
//5.당첨 번호 입력 예외  1부터 45 사이의 숫자
//6.보너스 번호 입력 예외  1부터 45 사이의 숫자
//7.수익률은 소수점 둘째 자리에서 반올림
//8.예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작
//9.로또 번호는 오름차순으로 정렬
public class Application {
    //1.입력: 로또 구입금액
    //2.로또 구매: 1개 1000원,
    //구입금액/1000 갯수만큼 구매
    //중복 예외처리
    //남는 금액 예외처리
    //3.입력: 당첨 번호 6자리, "," 로 구분 입력
    //4.입력: 보너스 번호
    //5.당첨 통계 계산
    //1) 각 구매 로또 리스트 탐색
    //만약 당첨번호 일치하는 것 있으면 카운트
    //만약 보너스 번호 맞으면 카운트
    //2) 당첨 갯수 계산
    //6개 일치
    //5개 일치, 보너스 볼 일치
    //5개 일치
    //4개 일치
    //3개 일치
    //3)수익률 계산

    public static List<Lotto> buyLotto(List<Lotto> lottos, List<Integer> numbers, int buyCashN){
        System.out.println(buyCashN/1000+"개를 구매했습니다.");
        for(int i=0;i<buyCashN/1000;i++){
            numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));

            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
            lotto.printNumbers();
        }
        return lottos;
    }

    public static List<Integer> inputWinLotto(List<Integer> lottoNum){
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winLotto;
        try{
            lottoNum = new ArrayList<>(Arrays.stream(Console.readLine().split(",")).map(num -> Integer.parseInt(num)).collect(Collectors.toList()));
            Collections.sort(lottoNum);
            winLotto = new Lotto(lottoNum);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }

        for(int i=0;i<lottoNum.size();i++){
            if(i==0) System.out.print(lottoNum.get(i));
            if(i!=0) System.out.print(","+lottoNum.get(i));
        }
        return winLotto.getNumbers();
    }

    public static void main(String[] args) {
        //TODO: 프로그램 구현
        //1.입력: 로또 구입금액
        System.out.println("구입금액을 입력해 주세요.");
        String buyCash = Console.readLine();
        System.out.println(buyCash);
        System.out.println();

        int buyCashN=0;
        try{
            buyCashN = Integer.parseInt(buyCash);
            if((float)buyCashN%1000 !=0){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 구입금액은 1000단위 숫자여야 합니다.");
            return;
        }


        Float earnCash=0F;
        Float earnPerc=0F;
        int num3 = 0;
        int num4 = 0;
        int num5=0;
        int num5Bonus=0;
        int num6 = 0;
        //2.로또 구매: 1개 1000원,
        //구입금액/1000 갯수만큼 구매
        //중복 예외처리
        //남는 금액 예외처리
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        lottos = buyLotto(lottos, numbers, buyCashN);

        //3.입력: 당첨 번호 6자리, "," 로 구분 입력
        List<Integer> lottoNum = new ArrayList<>();
        try{
            lottoNum = inputWinLotto(lottoNum);
        }catch(IllegalArgumentException e){
            return;
        }
    }
}
