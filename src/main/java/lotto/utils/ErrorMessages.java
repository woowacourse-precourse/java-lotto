package lotto.utils;

public enum ErrorMessages {
    PRICE_ERROR("%d�� ����� �Է� �����մϴ�."),
    ZERO_ERROR("0 ���� ū ���ڸ� �Է����ּ���."),
    RANGE_ERROR("%d�� %d ������ ������ �Է� �����մϴ�."),
    DUPLICATE_ERROR("�ߺ����� ���� ���� �Է� �����մϴ�."),
    LENGTH_ERROR("%d���� ��ȣ�� �Է����ּ���."),
    NUMBER_ERROR("���ڸ� �Է� �����մϴ�.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}