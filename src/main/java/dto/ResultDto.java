package dto;

public class ResultDto {

    private Integer threeCount;
    private Integer fourCount;
    private Integer fiveCount;
    private Integer fiveBonusCount;
    private Integer sixCount;

    public ResultDto() {
        this.threeCount = 0;
        this.fourCount = 0;
        this.fiveCount = 0;
        this.fiveBonusCount = 0;
        this.sixCount = 0;
    }

    public Integer getThreeCount() {
        return threeCount;
    }

    public void setThreeCount(Integer threeCount) {
        this.threeCount = threeCount;
    }

    public Integer getFourCount() {
        return fourCount;
    }

    public void setFourCount(Integer fourCount) {
        this.fourCount = fourCount;
    }

    public Integer getFiveCount() {
        return fiveCount;
    }

    public void setFiveCount(Integer fiveCount) {
        this.fiveCount = fiveCount;
    }

    public Integer getFiveBonusCount() {
        return fiveBonusCount;
    }

    public void setFiveBonusCount(Integer fiveBonusCount) {
        this.fiveBonusCount = fiveBonusCount;
    }

    public Integer getSixCount() {
        return sixCount;
    }

    public void setSixCount(Integer sixCount) {
        this.sixCount = sixCount;
    }

}
