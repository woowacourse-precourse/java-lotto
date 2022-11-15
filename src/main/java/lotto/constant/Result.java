package lotto.constant;

public enum Result {

    RESULT {
        @Override
        public String result(int match, int price, int count) {
            String str = String.format("%,d",price);
            if(price == 30000000) {
                return match + "개 일치, 보너스 볼 일치 (" + str + "원) - "+count+"개";
            }
            return match + "개 일치 ("+ str +"원) - "+count+"개";
        }
    };

    public abstract String result(int match, int price, int count);
}
