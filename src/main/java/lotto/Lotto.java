package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

// 로또 알고리즘

public class Lotto {
    private final List<Integer> numbers; //접근 제어자 private 변경 불가능

    //로또 번호 추첨시 중복되지 않는 숫자 6개 + 보너스 번호 1개
    List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6); //로또 당첨 번호 추첨
    List<Integer> lottoBonus = Randoms.pickUniqueNumbersInRange(1, 45, 1); //보너스 번호 추첨


    //매개변수로 사용자로부터 입력받은 List<Integer> numbers 받아온다고 가정:

    //사용자 입력 번호 == 로또 당첨 번호 확인 알고리즘
    int same=0; //같은 번호 개수 세는 변수 선언
    //(for i=0; i<lottoNumbers.size(); i++){
    // if lottoNumbers.contains(numbers.get(i)){
    // same++;
    // }
    // }




    //사용자 입력 보너스 번호 == 로또 보너스 번호 확인 알고리즘
    //당첨번호 확인이랑 같은 원리로


    //수익률 출력
    // switch(same){
    // case 3:
    // System.out.println("3개 일치 (5,000)원");
    // break;
    // case 4:
    // System.out.println("4개 일치 (5,0000)원");
    // break;
    // .... and so on

    // }


    public Lotto(List<Integer> numbers, List<Integer> bonusNumber) {
        validate(numbers);
        this.numbers = numbers;;

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
