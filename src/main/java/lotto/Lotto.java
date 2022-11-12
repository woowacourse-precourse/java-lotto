package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lotto {
    User user = new User();

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void inputBuyPirce1(){
        System.out.println("구입금액을 입력해주세요");
    }

    public static void buySucess(int Countlotto){
        System.out.println(Countlotto + "개를 구매하였습니다.");
    }

    public static int buyScuessCount(int Countlotto){
        return Countlotto / 1000;
    }
    public static void sayLottoNumber(){
        System.out.println("당첨 번호를 입력해주세요");
    }
    public static void bonusSay(){
        System.out.println("보너스 번호를 입력해주세요");
    }

    //당첨통계
    public static void toResult( Integer number, int correct, int Countlotto){
        List<Integer> answer = new ArrayList<>();
        User user = new User();
        // [1,2,3,4,5,6] 처럼 로또번호 입력값
        String lottoInput = user.lottoListSix();
        List<Integer> lottoToList = user.lottoToList(lottoInput);
        // [] 랜덤으로 나오는 숫자
        List<List<Integer>> lottoRandomNumber = user.lottoRandomNumber((Integer)(Countlotto));  //숫자에서 숫자로 형변환시킬때
        // [1,2,3,4,5,6] == []랜덤 으로 비교해서 안에없으면 넣어주기 카운트 또한 증가
        int count = 0;
        for(int i = 0; i < number; i++){
            if(!lottoRandomNumber.contains(lottoToList))
                lottoRandomNumber.contains(lottoToList);
                count++;
        }


        // 해당하는 숫자에 도착하면 나오는 결과값 한번에 출력
        for(int j = 0; j < correct; j++) {
            if (correct == 3) {
                System.out.println(Countlotto + "일치" + "(5,000원)" + "-" + count + "개");
            }if (correct == 4) {
                System.out.println(Countlotto + "일치" + "(50,000원)" + "-" + count + "개");
            }if (correct == 5) {
                System.out.println(Countlotto + "일치" + "(1,500,000원)" + "-" + count + "개");
            }if (correct == 5) {
                System.out.println(Countlotto + "일치" + "(30,000,000원)" + "-" + count + "개");
            }if (correct == 6) {
                System.out.println(Countlotto + "일치" + "(2,000,000,000원)" + "-" + count + "개");
            }
        }



    }





    // TODO: 추가 기능 구현
}
