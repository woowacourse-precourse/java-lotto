package lotto;

import java.util.regex.Pattern;

public class Account {

    private int account;

    public Account (final String input) {

        if(!validAccount(input)){
            this.account = Integer.parseInt(input);
        }
    }

    private static boolean validAccount(String input) {
        // 부정형..
        if(! Pattern.matches("[0-9]+" , input)){
            IOUtils.errorMessage();
            return true;
        }
        int account = Integer.parseInt(input);
        if (account % 1000 == 0) {
            return false;
        }
        IOUtils.errorMessage();
        return true;
    }

    public int account() {
        return account;
    }


}
