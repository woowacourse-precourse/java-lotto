package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        List<Integer> dupleCheck  = new ArrayList<>();
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (int idx =0; idx <numbers.size();idx++) {
            if (dupleCheck.contains(numbers.get(idx))) {
                throw new IllegalArgumentException();
            }
            else if (numbers.get(idx)< 1 || numbers.get(idx) > 45) {
                throw new IllegalArgumentException();
            }
            dupleCheck.add(numbers.get(idx));
        }
    }
    // TODO: 추가 기능 구현
    public static List<List<Integer>> lottoNumber(int num) {
        User user = new User();
        List<List<Integer>> answer = new ArrayList<>();
        for (int idx = 0; idx <num; idx++) {
            List<Integer>  temp = new ArrayList<>();
            List<Integer>   ans= Randoms.pickUniqueNumbersInRange(1, 45, 6);
            //1~45사이의 숫자를 6개 뽑는 경우의 수
            for(int q =0;q<ans.size();q++){
                if (temp.contains(ans.get(q))){
                    throw new IllegalArgumentException();
                }
                temp.add(ans.get(q));
            }
            Collections.sort(temp);
            user.output(temp);
            answer.add(temp);
        }
        return answer;
    }
    public int[] check(List<List<Integer>> num,int bonus){
        //로또 등수 확인
        int [] arr = new int [7];
        for (int idx=0;idx<num.size();idx++){
            int cnt=0; //몇개 맞춘지 카운트
            int bonusflag = 0;
            for (int numIdx = 0;numIdx<num.get(idx).size();numIdx++){
                if(numbers.contains(num.get(idx).get(numIdx))){  //다시 하기~!!! 깊이가 3임
                    cnt++; //개수 판단 하기
                }
                if(num.get(idx).contains(bonus)){
                    bonusflag =1;
                }
            }
            //밑에 if문들 함수 만들기
            if (cnt==6){  //등수 개수를 체크함
                arr[cnt]++;
            }
            else if(cnt==5&&bonusflag==1){
                arr[cnt]++;
            }
            else if(cnt!=0) {
                arr[cnt-1]++;
            }
        }
        return arr;
    }
}
