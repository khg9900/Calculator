package calculator;

public enum OperatorType {
    PLUS("+"),
    MINUS("-"),
    MULTI("*"),
    DIV("/");

    private String operatorType;

    OperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperatorType() {
        return operatorType;
    }

}
