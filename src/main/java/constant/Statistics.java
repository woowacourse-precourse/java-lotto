package constant;

public enum Statistics {
    LAST_RANKED("3개 일치 (5,000원) - "),
    FOURTH_RANKED("4개 일치 (50,000원) - "),
    THIRD_RANKED("5개 일치 (1,500,000원) - "),
    SECOND_RANKED("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_RANKED("6개 일치 (2,000,000,000원) - ");



    private String rank;
    Statistics(String rank) {
        this.rank=rank;
    }

    public String getStatistics(){
        return rank;
    }
}
