package lotto;

public class LottoRank {
    public enum RankType{
        RANK_FIFTH(0,3,"3개 일치 (5,000원)",5000),
        RANK_FOURTH(1,4,"4개 일치 (50,000원)",50000),
        RANk_THIRD(2,5,"5개 일치 (1,500,000원)",1500000),
        RANK_SECOND(3,5.5f,"5개 일치, 보너스 볼 일치 (30,000,000원)",30000000),
        RANK_FIRST(4,6,"6개 일치 (2,000,000,000원)",2000000000);
        final private int check;
        final private float num;
        final private String result;
        private final int price;

        public int getCheck(){
            return check;
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
        private RankType(int check, float num, String result,int price){
            this.check = check;
            this.num = num;
            this.result = result;
            this.price = price;
        }

    }
}
