package lotto;

public class RankSystem {
    public enum RankType{
        RANK_5(0,3,"3개 일치 (5,000원)",5000),
        RANK_4(1,4,"4개 일치 (50,000원)",50000),
        RANk_3(2,5,"5개 일치 (1,500,000원)",1500000),
        RANK_2(3,5.5f,"5개 일치, 보너스 볼 일치 (30,000,000원)",30000000),
        RANK_1(4,6,"6개 일치 (2,000,000,000원)",2000000000);
        final private int index;
        final private float num;
        final private String result;
        private final int price;

        public int getIndex(){
            return index;
        }
        public float getNum(){
            return num;
        }
        public String getResult(){
            return result;
        }
        public int getPrice(){
            return price;
        }
        private RankType(int index, float num, String result,int price){
            this.index = index;
            this.num = num;
            this.result = result;
            this.price = price;
        }

    }
}
