package lotto;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
 
public class lotto_1 {
    public static void main(String[] args) {
 
        // 배열크기 정의
        int LottoNumber[] = new int[6];
 
        // 랜덤함수 정의
        Random random = new Random();
 
        // 로또숫자 범의 (min, max 정의)
        int min = 1;
        int max = 45;
 
        // for문 돌려서 1 ~ 45번의 랜덤숫자 추출
        for (int i = 0; i < LottoNumber.length; i++) {
            // nextInt(45) 이면 해당 범위가 0 ~ 44 이므로
            // 내가 실제 구하고 싶은건 1 ~ 45 이기 때문에 마지막에 츼소값인 min을 더해주면 된다!
            LottoNumber[i] = (random.nextInt((max - min) + 1) + min);
            System.out.println("LottoNumber --> " + LottoNumber[i]);
 
            // 중복처리로직
            // 앞의 숫자와 뒤의 숫자가 같으면 중복된 숫자를 알려주고 다시 한 번돈다.
 
            for (int j = 0; j < i; j++) {
                if (LottoNumber[i] == LottoNumber[j]) {
                    //System.out.println("중복된 숫자가 있어요 --> " + LottoNumber[i]);
                    // 중복건수를 처리하기의해 반복분 i 번째를 다시 내린다.
                    i--;
                }
 
                //오름차순 처리로직
                //해당 알고리즘은 정말많이 쓰인다. 현재는 작은 수부터 크게 나오게 코딩했지만
                //부등호를 반대로해주면 큰 수부터 차례대로 내열한다.
                if (LottoNumber[i] < LottoNumber[j]) {
                    int LottoNumberTemp = LottoNumber[i];
                    LottoNumber[i] = LottoNumber[j];
                    LottoNumber[j] = LottoNumberTemp;
                }
 
            }
 
        }
 
        // 위에서 정리된 LottoNumber 배열을 다시 마지막으로 정리
        for (int i = 0; i < LottoNumber.length; i++) {
            System.out.println("LOTTO NUMBER  ------->               " + LottoNumber[i]);
        }
    }
}
/*
public class Lotto {
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

    
    // TODO: 추가 기능 구현
}
*/