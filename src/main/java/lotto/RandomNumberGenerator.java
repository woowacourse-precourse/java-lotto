package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {
    public List<Integer> RndNumGen() {

        List<Integer> numbers = new ArrayList<>();
        int Lotto[] = new int[7];
        int Bonus[] = new int[1];
        Arrays.fill(Lotto, 0); //배열에 초기 전체 데이터 0을 모두 대입시켜줍니다

        int cnt = 0;
        boolean check;
        Random rnd = new Random();
        while(cnt < 7)
        {
            int num = 1 + rnd.nextInt(45);

            check = false;
            for(int i = 0; i < cnt; i++) {
                if(Lotto[i] == num) { //중복제거
                    check = true;
                    break;
                }
            }
            if(!check) {
                Lotto[cnt] = num;
                numbers.add(num); //로또번호 넣기
                cnt++;
            }

            if(cnt == 7) {//마지막 번호 보너스 번호로 넣음
                Bonus[0]= num;
            }
        }

        return numbers;
    }
}
