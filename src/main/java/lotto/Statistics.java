package lotto;

public class Statistics {
        private int pt_3,pt_4,pt_5,pt_6,bonus;
        // ror = rate of return 수익률
        private float ror;
        public Statistics(){
            setPoints();
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
        public float cal_statistics(int cnt){
            this.ror = (pt_3*5000 + pt_4*50000 + pt_5*1500000+ bonus*30000000+ pt_6*2000000000)/(cnt*1000);
            return this.ror;
        }
        public void print_statistic(int cnt){
            System.out.printf("3개 일치 (5,000원) - %d개",this.pt_3);
            System.out.printf("4개 일치 (50,000원) - %d개",this.pt_4);
            System.out.printf("5개 일치 (1,500,000원) - %d개",this.pt_5);
            System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개",this.bonus);
            System.out.printf("6개 일치 (2,000,000,000원) - %d개",this.pt_6);
            cal_statistics(cnt);
            System.out.printf("총 수익률은 %f%입니다.",ror);
        }

}
