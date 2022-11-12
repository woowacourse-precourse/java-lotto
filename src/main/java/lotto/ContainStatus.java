package lotto;

public enum ContainStatus {

    Contain(1, true),
    NotContain(0, false);

    private int contain1Value;
    private boolean contain2Value;

    ContainStatus(int contain1Value, boolean contain2Value) {
        this.contain1Value = contain1Value;
        this.contain2Value = contain2Value;
    }

    public static ContainStatus setContainStatus(boolean contain2Value) {
        if (contain2Value) {
            return ContainStatus.Contain;
        }
        return ContainStatus.NotContain;

    }

    public int getContain1Value() {
        return contain1Value;
    }

    public boolean getContain2Value() {
        return contain2Value;
    }


}

