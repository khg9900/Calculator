package calculator;

public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTI('*'),
    DIV('/');

    private char operatorType;

    OperatorType(char operatorType) {
        this.operatorType = operatorType;
    }

    public char getOperatorType() {
        return operatorType;
    }

    public static OperatorType fromChar(char operator) {
        for (OperatorType type : OperatorType.values()) {
            if (type.operatorType == operator) {
                return type;
            }
        }

        throw new IllegalArgumentException("해당하는 연산자가 없습니다." + operator);
    }

}
