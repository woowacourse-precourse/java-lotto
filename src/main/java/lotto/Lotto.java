package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 7) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static void RandomNumberGenerate(){
        //로또 당첨 정답 번호 배열입니다 (총 6개 정답번호가 저장되어있습니다)

        int lotto[] = new int[7];
        int bonus[] = new int[1];
          Arrays.fill(lotto, 0); //배열에 초기 전체 데이터 0을 모두 대입시켜줍니다

        int cnt = 0;
        boolean check = false;
        Random rnd = new Random();
        while(cnt < 7)
        {
            int num = 1 + rnd.nextInt(45);

            check = false;
            for(int i = 0; i < cnt; i++) {
                if(lotto[i] == num) { //중복제거
                    check = true;
                    break;
                }
            }
            if(!check) {
                lotto[cnt] = num;
                cnt++;
            }
            if(cnt == 7) {//마지막 번호 보너스 번호로 넣음
                bonus[0]= num;
            }


        }
        System.out.println("로또 당첨 번호 : "+Arrays.toString(lotto) + "보너스 번호 : " + Arrays.toString(bonus));
    }
}
