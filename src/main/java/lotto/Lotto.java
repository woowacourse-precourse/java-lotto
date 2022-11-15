package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Lotto {

    private final List<Integer> numbers;
    static int pay;
    static int lottoQuantity; // 로또 개수
    static int bonusNumber; //보너스번호

    static int[] winLottoNumber = {0,0,0,0,0};  // 당첨 개수 저장
    static double profit; //수익률
    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        GetLottoNumber lotteNum = new GetLottoNumber(numbers);
        pay = Input(); //구입금액
        if(pay == 0)
            return;
        lottoQuantity = NumberOfLotto(); // 로또 개수
        int[][] lottoNumberList = new int[lottoQuantity][6];
        System.out.println("\n" + lottoQuantity + "개를 구매했습니다.");
        for(int i = 0; i< lottoQuantity; i++){
            lotteNum.GetLotto(numbers); // 랜덤 로또 번호 6개 저장
            validate(numbers);
            Lotto_number(lottoNumberList, i, numbers); // 로또 번호 2차원 배열에 저장
            numbers.clear();
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        int[] winNumber = lotteNum.WinNum(lotteNum.WinNumInput());
        if(winNumber[0] == 0){
            return;
        }

        System.out.println("\n보너스 번호를 입력해 주세요.");
        bonusNumber = lotteNum.Bonus();
        if(bonusNumber == 0){
            return;
        }

        System.out.println("\n당첨 통계\n---\n");
        CheckLottoNumber(lottoNumberList, winNumber);
        System.out.println("3개 일치 (5,000원) - "+ winLottoNumber[0] + "개");
        System.out.println("4개 일치 (50,000원) - "+  winLottoNumber[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - "+ winLottoNumber[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+  winLottoNumber[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ winLottoNumber[4] + "개");
        System.out.println("총 수익률은 " +  CalcProfit() + "%입니다.");

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public int Input() {
        String strPay = Console.readLine();
        try {
            pay = Integer.parseInt(strPay); //구입금액
            System.out.println(pay);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]: 구입금액은 숫자여야 합니다." +e.getMessage());
        }
        return pay;
    }
    public int NumberOfLotto(){ // 로또 개수
        lottoQuantity = pay / 1000;
        return lottoQuantity;
    }
    public void Lotto_number(int[][]winLottoNumber, int i , List<Integer> numbers){
        for(int j =0; j< numbers.size(); j++){
            winLottoNumber[i][j] = numbers.get(j);
        }
        for(int k =0; k< numbers.size(); k++) {
            for (int l = k + 1; l < numbers.size(); l++) {
                if (winLottoNumber[i][k] == winLottoNumber[i][l])
                    System.out.println("[ERROR]: 로또 번호는 중복된 숫자가 아니여야 합니다.");
            }
        }
    }
    public void CheckLottoNumber(int[][]arr, int[] winNumber){ // 일치 개수 찾기
        int cnt = 0;
        int bonusCount = 0;
        for(int i = 0; i< lottoQuantity; i++){
            for(int j =0; j< arr[0].length; j++) {
                for(int k=0; k<winNumber.length; k++){
                    if(arr[i][j] == winNumber[k])
                        cnt++;
                    else if(arr[i][j] == bonusNumber)
                        bonusCount++;
                }
            }
            if(cnt == 3)
                winLottoNumber[0]++;
            else if(cnt == 4)
                winLottoNumber[1]++;
            else if(cnt == 5){
                if(bonusCount == 6)
                    winLottoNumber[3]++;
                else
                    winLottoNumber[2]++;
            }
            else if(cnt == 6)
                winLottoNumber[4]++;
            cnt =0;
            bonusCount = 0;
        }
    }

    public String CalcProfit(){
        int money = winLottoNumber[0] * 5000 + winLottoNumber[1] * 50000 + winLottoNumber[2] * 1500000 + winLottoNumber[3] * 30000000 + winLottoNumber[4] * 2000000000;
        profit = (double) money / pay *100;
        return String.format("%.1f",profit);
    }
}