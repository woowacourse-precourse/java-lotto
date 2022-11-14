package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Lotto {

    private final List<Integer> numbers;
    static int pay;
    static int Lotto_cnt; // 로또 개수
    static int BonusNumber; //보너스번호

    static int[] WinLottoNumber = {0,0,0,0,0};  // 당첨 개수 저장
    static double profit; //수익률
    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        GetLottoNumber Lot_Num = new GetLottoNumber();
        pay = Input(); //구입금액
        Lotto_cnt = NumberOfLotto(); // 로또 개수
        int[][] arr = new int[Lotto_cnt][6];
        System.out.println("\n" + Lotto_cnt+ "개를 구매했습니다.");
        for(int i =0; i< Lotto_cnt; i++){
            Lot_Num.GetLotto(numbers); // 랜덤 로또 번호 6개 저장
            validate(numbers);
            Lotto_number(arr, i, numbers); // 로또 번호 2차원 배열에 저장
            numbers.clear();
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        Lot_Num.WinNumInput();

        System.out.println("\n보너스 번호를 입력해 주세요.");
        BonusNumber = Lot_Num.Bonus();

        System.out.println("\n당첨 통계\n---\n");
        CheckLottoNumber(arr, Lot_Num);
        System.out.println("3개 일치 (5,000원) - "+ WinLottoNumber[0] + "개");
        System.out.println("4개 일치 (50,000원) - "+  WinLottoNumber[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - "+ WinLottoNumber[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+  WinLottoNumber[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ WinLottoNumber[4] + "개");
        System.out.println("총 수익률은 " +  CalcProfit() + "%입니다.");

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public static int Input() {
        int cnt = 0;
        String str_pay = Console.readLine();
        for (int i = 0; i < str_pay.length(); i++)
            if (str_pay.charAt(i) -48 >= 0 && str_pay.charAt(i) - 48<= 9)
                cnt++;
        try {
            if (cnt != str_pay.length())
                throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        } catch (Exception e) {
            e.printStackTrace(); //예외정보 출력
        }
        finally {
            pay = Integer.parseInt(str_pay); //구입금액
            System.out.println(pay);
        }
        return pay;
    }
    public int NumberOfLotto(){ // 로또 개수
        Lotto_cnt = pay / 1000;
        return Lotto_cnt;
    }
    public void Lotto_number(int[][]arr, int i , List<Integer> numbers){
        for(int j =0; j< numbers.size(); j++){
            arr[i][j] = numbers.get(j);
        }
        try {
            IllegalArgumentException e = new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 아니여야 합니다.");
            for(int k =0; k< numbers.size(); k++){
                for(int l=k+1; l< numbers.size(); l++){
                    if(arr[i][k] == arr[i][l])
                        throw e;
                }
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace(); //예외정보 출력
        }
    }
    public void CheckLottoNumber(int[][]arr, GetLottoNumber Lot_Num){ // 일치 개수 찾기
        int[] temp = Lot_Num.WinNum();
        int cnt = 0;
        int BonusCnt = 0;
        for(int  i =0; i< Lotto_cnt; i++){
            for(int j =0; j< arr[0].length; j++) {
                for(int k=0; k<temp.length; k++){
                    if(arr[i][j] == temp[k])
                        cnt++;
                    else if(arr[i][j] == BonusNumber)
                        BonusCnt++;
                }

            }
            if(cnt == 3)
                WinLottoNumber[0]++;
            else if(cnt == 4)
                WinLottoNumber[1]++;
            else if(cnt == 5){
                if(BonusCnt
                        == 6)
                    WinLottoNumber[3]++;
                else
                    WinLottoNumber[2]++;
            }
            else if(cnt == 6)
                WinLottoNumber[4]++;
            cnt =0;
            BonusCnt = 0;
        }
    }

    public String CalcProfit(){
        int money = WinLottoNumber[0] * 5000 + WinLottoNumber[1] * 50000 + WinLottoNumber[2] * 1500000 + WinLottoNumber[3] * 30000000 + WinLottoNumber[4] * 2000000000;
        profit = (double) money / pay *100;
        String RoundProfit = String.format("%.1f",profit);
        return RoundProfit;
    }



    /*public void printLottoNum(int[][] arr){
        for(int  i =0; i< Lotto_cnt; i++){
            for(int j =0; j< arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }*/
}