package calculator;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class Calculator <T extends Number> {

    // 1. 속성
    private List<Double> history = new ArrayList<>();

    // 2. 생성자


    // 3. 기능
    public Optional<Double> calculate(T firstNum, T secondNum, char operator) {

        // 초기화
        double result = 0;
        OperatorType op = OperatorType.PLUS;

        // enum
        for (OperatorType type : OperatorType.values()) {
            if (type.getOperatorType().equals(String.valueOf(String.valueOf(operator)))) {
                op = OperatorType.valueOf(type.name());
            }
        }

        // 연산
        switch (op) {
            case PLUS : result = firstNum.doubleValue() + secondNum.doubleValue();
                break;

            case MINUS : result = firstNum.doubleValue() - secondNum.doubleValue();
                break;

            case MULTI : result = firstNum.doubleValue() * secondNum.doubleValue();
                break;

            case DIV :
                if (secondNum.doubleValue() != 0){
                    result = firstNum.doubleValue() / secondNum.doubleValue();
                } else {
                    return Optional.ofNullable(null);
                }
                break;
        }

        // 연산 결과 저장
        this.history.add(result);

        // 결과값 반환
        return Optional.ofNullable(result);
    }

    public void getHistory() {
        System.out.println("연산 기록: " + history);
    }

    public void setHistory(int indexNum, Double newNum) {
        history.set(indexNum, newNum);
        System.out.println("수정 완료.");
    }

    public void removeResult() {
        history.remove(0);
        System.out.println("첫 번째 연산 기록이 삭제되었습니다.");
    }
}
