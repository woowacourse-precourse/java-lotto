package lotto.model;

import lotto.exception.IllegalMoneyException;

public class Money {
    long amount;
    long unit;

    public Money(String readLine, long unit) {
        try {
            long amount = Long.parseLong(readLine);
            validate(amount, unit);
            this.amount = amount;
            this.unit = unit;
        } catch (NumberFormatException e) {
            throw new IllegalMoneyException();
        }
    }

    private void validate(long amount, long unit) {
        if (amount % unit != 0 || amount <= 0) {
            throw new IllegalMoneyException();
        }
    }

    public long getPayLottos() {
        return amount / unit;
    }

    public String getBenefits(long earningMoney) {
        String benefit = String.valueOf(getBenefit((double) earningMoney));
        int decimalNumberIdx = benefit.indexOf(".");
        if (decimalNumberIdx == -1) {
            return benefit;
        }
        return removeBackZero(benefit);
    }

    private String removeBackZero(String benefit) {
        StringBuffer removeZero = new StringBuffer();
        boolean isBack = true;
        for (int i = benefit.length() - 1; i > -1; i--) {
            char value = benefit.charAt(i);
            if (value == '0' && isBack) {
                continue;
            }
            isBack = false;
            removeZero.append(value);
        }
        return removeZero.reverse().toString();
    }

    private double getBenefit(double earningMoney) {
        double benefit = earningMoney / amount * 10000;
        benefit = Math.round(benefit);
        benefit /= 100;
        return benefit;
    }
}
