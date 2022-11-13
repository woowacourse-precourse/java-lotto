package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GetLottoNumber {
    static String win_number; //당첨번호
    static int[] win_num; // 당첨번호
    static int BonusNumber; //보너스번호
    List<Integer> temp = new ArrayList<>();

    public List<Integer> GetLotto(List<Integer> numbers){
        int cnt =0;
        temp = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        for(int i =0; i<temp.size(); i++)
            if(temp.get(i) >= 1 && temp.get(i) <= 45){
                cnt++;
            }
        if(cnt == temp.size()){
            numbers.addAll(temp);
            System.out.println(numbers);
        }
        else{
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        cnt =0;
        return numbers;
    }
    public String WinNumInput(){ // 당첨번호 입력
        win_num = new int[6];
        String[] temp;
        win_number = Console.readLine();
        temp = win_number.split(",");
        for(int i =0; i< 6; i++){
            win_num[i] = Integer.parseInt(temp[i]);
        }
        if(win_num.length != 6){
            System.out.println("[ERROR] 당첨 번호는 6개의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return win_number;
    }
    public int[] WinNum(){ // 당첨번호 배열에 저장
        win_num = new int[6];
        String[] temp = new String[win_num.length];
        temp = win_number.split(",");
        for(int i =0; i< 6; i++){
            win_num[i] = Integer.parseInt(temp[i]);
            if(win_num[i] < 1 || win_num[i] > 45){
                System.out.println("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
        return win_num;
    }

    public int Bonus() {// 보너스번호
        BonusNumber = Integer.parseInt(Console.readLine());
        if (BonusNumber < 1 || BonusNumber > 45) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return BonusNumber;
    }

}