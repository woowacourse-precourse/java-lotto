package function;

import java.util.List;

public class calculate {
    private int earnmoney  = 0;

    private float return_rate ;
    private int fifth;
    private int forth;
    private int third;
    private int second;
    private int first;

    public calculate(List<List<Integer>> lottos, List<Integer> win, int bonus, int money) {
        System.out.println("당첨 통계");
        System.out.println("---");
        winner(lottos,win,bonus);
        fivewithbonus(lottos, win, bonus);
        fivecorrect(lottos,win,bonus);
        fourcorrect(lottos,win,bonus);
        threecorrect(lottos,win,bonus);

        printthreecorrect();
        printfourcorrect();
        printfivecorrect();
        printfivewithbonus();
        printwinner();

        printearn(money);

    }

    private void threecorrect(List<List<Integer>> lottos, List<Integer> win, int bonus){
        int cnt = 0;
        for (List<Integer> nums : lottos) {
            int i = checkloop(nums, win);
            if (i == 3) {
                cnt++;
            }
        }
        this.fifth = cnt;
        this.earnmoney += 50000*cnt;
    }

    private void printthreecorrect(){
        System.out.println(String.format("3개 일치 (5,000원) - %d개",this.fifth));
    }
    private void fourcorrect(List<List<Integer>> lottos, List<Integer> win, int bonus) {
        int cnt = 0;
        for (List<Integer> nums : lottos) {
            int i = checkloop(nums, win);
            if (i == 4) {
                cnt++;
            }
        }
        this.forth = cnt;
        this.earnmoney += 500000*cnt;
    }
    private void printfourcorrect(){
        System.out.println(String.format("4개 일치 (50,000원) - %d개",this.forth));

    }

    private void fivecorrect(List<List<Integer>> lottos, List<Integer> win, int bonus) {
        int cnt = 0;
        for (List<Integer> nums : lottos) {
            if (nums.contains(bonus)) {
                continue;
            }
            int i = checkloop(nums, win);
            if (i == 5) {
                cnt++;
            }
        }
        this.third = cnt;
        this.earnmoney += 1500000*cnt;
    }
    private void printfivecorrect(){
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개",this.third));

    }

    private void fivewithbonus(List<List<Integer>> lottos, List<Integer> win, int bonus) {
        int cnt = 0;
        for (List<Integer> nums : lottos) {
            if (!nums.contains(bonus)) {
                continue;
            }
            int i = checkloop(nums, win);
            if (i == 5) {
                cnt++;
            }
        }
        this.second = cnt;
        this.earnmoney += 30000000 * cnt;
    }
    private void printfivewithbonus(){
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개",this.second));
    }

    private void winner(List<List<Integer>> lottos, List<Integer> win, int bonus) {
        int cnt = 0;
        for (List<Integer> nums : lottos) {
            if (nums.equals(win)) {
                cnt++;
            }
        }
        this.first = cnt;
        this.earnmoney += 2000000000 * cnt;
    }
    private void printwinner(){
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개",this.first));
    }

    private int checkloop(List<Integer> lotto, List<Integer> win)  {
        int d = 0;
        for (int num : lotto) {
            if (win.contains(num)) { d++; }
        }
        return d;
    }

    private void printearn(int money) {
        float deno = (float)earnmoney;
        float nume = (float)money;
        this.return_rate = deno/nume;
        System.out.println(String.format("총 수익률은 %.2f%%입니다.",this.return_rate));

    }
}
