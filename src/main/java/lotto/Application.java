package lotto;

/*
 * [필요 기능 명세]
 * [O] 랜덤 로또 번호 생성
 * [O] 당첨금 enum class 생성
 * [X] 당첨 로또 번호 입력
 * [X] 당첨 통계 계산
 * [X] 총 수익률 계산
 * [X] 입력 예외 처리
 * [X] 단위 테스트 생성
 * [X] 테스트 확인
 */

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public enum WINNINGS{
        FIRST(2000000000),
        SECOND(30000000),
        THIRD(1500000),
        FOURTH(50000),
        FIFTH(5000);

        int value;

        private WINNINGS(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현


        createRandomLottoList();
    }

    private static List<Integer> createRandomLottoList() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().collect(Collectors.toList());

        // System.out.println(numbers.toString());

        return numbers;
    }
}
