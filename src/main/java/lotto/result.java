package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class result {


    // 비교
    // map을 사용하여 정수,정수로 묶는다.
    // 구매한 리스트를 반복문을 통해 입력받은 로또의 번호와 비교한다.
    // 비교하며 count로 수량을 체크한 후 반복문이 끝나면 count의 값(map의 value)를 증가 시킨다.
    // 이후 출력/

    //수익률 --> (획득 금액 / 구입금액) * 100




    public static void printSixRange(List<Integer> randomLottos, int row) {
        List<Integer> seperateRandomLotto = new ArrayList<>();

        for(int j=row*6 ; j<(row+1)*6 ; j++){
            int target = randomLottos.get(j);
            seperateRandomLotto.add(target);
        }
        Collections.sort(seperateRandomLotto);
        System.out.println(seperateRandomLotto);
    }

}
