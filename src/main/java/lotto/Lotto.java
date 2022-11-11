package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {

    private final List<Integer> numbers;
    static int pay;
    static int Lotto_cnt; // 로또 개수
    public Lotto(List<Integer> numbers) {
        Get_Lotto_Number Lot_Num = new Get_Lotto_Number();
        pay = Input();
        Lotto_cnt = NumberOfLotto();
        int[][] arr = new int[Lotto_cnt][6];
        for(int i =0; i< Lotto_cnt; i++){
            Lot_Num.GetLotto(numbers); // 랜덤 로또 번호 6개 저장
            validate(numbers);
            Lotto_number(i,arr, numbers); // 로또 번호 2차원 배열에 저장
            numbers.clear();
        }
        //printLottoNum(arr);
        this.numbers = numbers;



    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public static int Input(){
        pay = Integer.parseInt(Console.readLine()); //구입금액
        System.out.println(pay);
        return pay;
    }
    public int NumberOfLotto(){ // 로또 개수
        Lotto_cnt = pay / 1000;
        return Lotto_cnt;
    }
    public int WinNum(){ // 당첨번호
        win_number = Integer.parseInt(Console.readLine()); //구입금액
        System.out.println(win_number);
        return win_number;
    }

    public void Lotto_number(int i, int[][] arr, List<Integer> numbers){
        for(int j =0; j< numbers.size(); j++){
            arr[i][j] = numbers.get(j);
        }
    }
    /*public void printLottoNum(int[][] arr){
        for(int i =0; i< Lotto_cnt; i++){
            for(int j =0; j< arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }*/
}
