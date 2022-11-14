package lotto.Model;

public enum Rank {
    FIFTH(5_000),
    FOURTH(50_000),
    THIRD(1_500_000),
    SECOND(30_000_000),
    FIRST(2_000_000_000);

    final private int money;
    Rank(int money) {
        this.money = money;
    }
    public static String getGrade(int count, int bonus_cnt){
        if(count == 6) return "FIRST";
        else if (count == 5 && bonus_cnt == 1) return "SECOND";
        else if (count == 5) return "THIRD";
        else if (count == 4) return "FOURTH";
        else if (count == 3) return "FIFTH";
        return "NONE";
    }

    public static String getGradeForDisplay(String key){
        if(key.equals("FIRST")) return "6개 일치 (2,000,000,000원)";
        else if(key.equals("SECOND")) return "5개 일치, 보너스 볼 일치 (30,000,000원)";
        else if(key.equals("THIRD")) return "5개 일치 (1,500,000원)";
        else if(key.equals("FOURTH")) return "4개 일치 (50,000원)";
        else if(key.equals("FIFTH")) return "3개 일치 (5,000원)";
        return "NONE";
    }

    public int getMoney(){
        return money;
    }
}
