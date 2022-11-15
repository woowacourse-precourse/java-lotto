package lotto;

import java.util.Arrays;
import java.util.List;

public class Statistics {
        private int pt_3,pt_4,pt_5,pt_6,bonus;
        private int[] ans_num;
        private int ans_bonus;
        private boolean bonus_flag;
        // ror = rate of return 수익률
        private float ror;
        private List<Lotto> numbers;
        public Statistics(List<Lotto> numbers, int[] ans_num, int bonus){
            setPoints();
            setNumbers(numbers);
            setAns(ans_num,bonus);
        }

        private void setAns(int[] ans_num, int ans_bonus) {
            this.ans_num = ans_num;
            this.ans_bonus = ans_bonus;
            this.bonus_flag = false;

        }

    public void setNumbers(List<Lotto> numbers){
            this.numbers = numbers;
        }
        public void setPoints(){
            this.pt_3=0;
            this.pt_4=0;
            this.pt_5=0;
            this.pt_6=0;
            this.ror =0;
            this.bonus = 0;
        }
        public void addPt3(){
            this.pt_3+=1;
        }
        public void addPt4(){
            this.pt_4+=1;
        }
        public void addPt5(){
            this.pt_5+=1;
        }
        public void addPt6(){
            this.pt_6+=1;
        }
        public void addBonus(){
            this.bonus +=1;
        }
        public void cal_statistics(float cnt){
            this.ror = ((pt_3*5000 + pt_4*50000 + pt_5*1500000+ bonus*30000000+ pt_6*2000000000)
                    /(cnt*1000))*100;
        }
        public static boolean contains(final int[] arr, final int key) {
            return Arrays.stream(arr).anyMatch(i -> i == key);
        }
        public void adder(Lotto e){
            int cnt=0;
            for (int i=0;i<ans_num.length;i++) {
                if (contains(ans_num,e.getNumByIndex(i))){
                 cnt++;
                }
                if(ans_bonus == e.getNumByIndex(i)){
                    bonus_flag=true;
                }
            }
            if(cnt == 3){
                addPt3();
            }if(cnt==4){
                addPt4();
            }if (cnt==5){
                addPt5();
            }if (cnt==6){
                addPt6();
            }if(cnt==5 && bonus_flag){
                addBonus();
            }

        }
        public void check_points(){
            List<Lotto> checks = this.numbers;
            for (Lotto l:checks) {
                adder(l);
            }
        }
        public void print_statistic(int cnt){
            System.out.printf("3개 일치 (5,000원) - %d개\n",this.pt_3);
            System.out.printf("4개 일치 (50,000원) - %d개\n",this.pt_4);
            System.out.printf("5개 일치 (1,500,000원) - %d개\n",this.pt_5);
            System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",this.bonus);
            System.out.printf("6개 일치 (2,000,000,000원) - %d개\n",this.pt_6);
            cal_statistics(cnt);
            System.out.println("총 수익률은 "+ror+"%"+"입니다.");
        }

}
