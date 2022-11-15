package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static  String input() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
    public static int checkInput(String user) {
        if (checkNum(user) == 0) {
            try {
                throw new IllegalArgumentException("[ERROR] 1부터 45사이 숫자를 입력해주세요.");
            } catch (Exception e) {
                System.out.println(e);
            }
            return 0;
         }
        if (checkDevide(user) == 0) {
            try {
                throw new IllegalArgumentException("[ERROR] 천원단위로 입력해주세요");
            }catch (Exception e){
                System.out.println(e);
            }
            return 0;
        }
        return Integer.valueOf(user)/1000;
        }
        public static int checkDevide(String user) {
        //1000으로 나누어 떨어지는지 검사
            if(Integer.valueOf(user)%1000!=0){
                return 0;
                }
            return 1;
        }
        public static int checkNum (String num){  //숫자인지 판단
            for (int idx = 0; idx < num.length(); idx++) {
                if (Character.isDigit(num.charAt(idx)) == false) {
                    return 0;
                }
            }
            return 1;
        }
    public static List<Integer> answerInput(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String answerNum = Console.readLine();
        List<Integer> parseAnswer = parseNum(answerNum);
        return parseAnswer;
    }
    public static List<Integer> parseNum(String num) {
        List<Integer> answer = new ArrayList<>();
        String [] temp = num.split(",");
        for (int idx=0;idx<temp.length;idx++){
            answer.add(Integer.valueOf(temp[idx]));
        }
        return answer;
    }
    public static  int bonusInput(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNum = Console.readLine();
        return Integer.valueOf(bonusNum);
    }
    public static void output(List<Integer> num){
        String  aaa ="[";
        aaa+=String.valueOf(num.get(0));
        for(int i=1;i<num.size();i++){
            aaa+=", ";
            aaa+=String.valueOf(num.get(i));
        }
        aaa+="]";
        System.out.println(aaa);
    }
    public static String [] announceList(){
        String [] ans = new String[7];
        ans[2]="3개 일치 (5,000원) - ";
        ans[3]="4개 일치 (50,000원) - ";
        ans[4]="5개 일치 (1,500,000원) - ";
        ans[5]="5개 일치, 보너스 볼 일치 (30,000,000원) - ";
        ans[6]="6개 일치 (2,000,000,000원) - ";
        return ans;
    }
    public  static  void announce(int [] num,int buyValue){
        String [] ans = announceList();
        int [] lottoValue = {0,0,5000,50000,1500000,30000000,2000000000};
        int sum =0;
        for(int idx =2;idx<num.length;idx++){ //2~6까지 반복
            String aaa=ans[idx];
            aaa+=String.valueOf(num[idx]);
            aaa+="개";
            if(num[idx] !=0) {
                sum += lottoValue[idx]*num[idx];
            }
            System.out.println(aaa);
        }
        String aaa="총 수익률은 ";

        aaa+=String.format("%.1f",(double)sum/buyValue*100);  //이거 소수점 2쨰 자리에서 반올림
        aaa+="%입니다.";
        System.out.println(aaa);
    }
}