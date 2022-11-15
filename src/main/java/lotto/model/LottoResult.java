package lotto.model;

public class LottoResult {

    private int firstCount;
    private int secondCount;
    private int thirdCount;
    private int fourthCount;
    private int fifthCount;

    public int getFirstCount() {
        return firstCount;
    }

    public int getSecondCount() {
        return secondCount;
    }

    public int getThirdCount() {
        return thirdCount;
    }

    public int getFourthCount() {
        return fourthCount;
    }

    public int getFifthCount() {
        return fifthCount;
    }

    public void addFirstCount() {
        firstCount++;
    }

    public void addSecondCount() {
        secondCount++;
    }

    public void addThirdCount() {
        thirdCount++;
    }

    public void addFourthCount() {
        fourthCount++;
    }

    public void addFifthCount() {
        fifthCount++;
    }
}
