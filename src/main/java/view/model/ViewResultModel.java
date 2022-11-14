package view.model;

public enum ViewResultModel {

    FIRST(6, 2000000000, Boolean.FALSE),
    SECOND(6, 30000000, Boolean.TRUE),
    THIRD(5, 1500000, Boolean.FALSE),
    FOURTH(4, 50000, Boolean.FALSE),
    FIFTH(6, 5000, Boolean.FALSE),;

    private static final ViewResultModel[] RESULT_ARR = ViewResultModel.values();
    private final int matchedCount;
    private final long reward;
    private final boolean IsMatchedBonus;

    ViewResultModel(int matchedCount, long reward, boolean isMatchedBonus) {
        this.matchedCount = matchedCount;
        this.reward = reward;
        IsMatchedBonus = isMatchedBonus;
    }
}
