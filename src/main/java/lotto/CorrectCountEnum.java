package lotto;

public enum CorrectCountEnum {
    three(0, "3개 일치 (5,000원)"),
    four(50000, "4개 일치 (50,000원)"),
    five(1500000, "5개 일치 (1,500,000원)"),
    fiveWithBonus(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    six(2000000000, "6개 일치 (2,000,000,000원)");

    private int money;
    private String str;

    CorrectCountEnum(int i, String s){
        this.money = i;
        this.str = s;
    }

    public int getMoney(){
        return money;
    }

    public String getStr(){
        return str;
    }
}
