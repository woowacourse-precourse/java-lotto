package lotto.constant;

public enum MatchingForm {
    POSITIVE_INTEGER_FORM("[1-9][0-9]+"),
    SIX_POSITIVE_INTEGER_DIVIDED_BY_COMMA("[1-9][0-9]*,[1-9][0-9]*,[1-9][0-9]*,[1-9][0-9]*,[1-9][0-9]*,[1-9][0-9]*");

    private final String form;

    MatchingForm(String form) {
        this.form = form;
    }

    public String getForm() {
        return form;
    }
}
