package lotto;

public enum WinningPrize {
    COUNT3(3,"5000"),
    COUNT4(4,"50000"),
    COUNT5(5,"1500000"),
    COUNT5ANDBONUS(7,"30000000"),
    COUNT6(6,"2000000000");

    int countOfContain;
    String winningPrize;
    WinningPrize(int countOfContain, String winningPrize) {
        this.countOfContain = countOfContain;
        this.winningPrize = winningPrize;
    }
}
