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

        // 입력받은 문자열을 enum 상수로 치환
        for (OperatorType type : OperatorType.values()) {
            if (type.getOperatorType().equals(String.valueOf(String.valueOf(operator)))) {
                op = OperatorType.valueOf(type.name());
            }
        }

        // 연산 - enum을 활용한 switch 문
        switch (op) {
            case PLUS : result = firstNum.doubleValue() + secondNum.doubleValue();
                break;

            case MINUS : result = firstNum.doubleValue() - secondNum.doubleValue();
                break;

            case MULTI : result = firstNum.doubleValue() * secondNum.doubleValue();
                break;

            case DIV :
                if (secondNum.doubleValue() != 0){ // 두 번째 수가 0이 아닌지 확인
                    result = firstNum.doubleValue() / secondNum.doubleValue();
                } else {
                    return Optional.ofNullable(null); // 0일 경우 결괏값으로 null return
                }
                break;
        }

        // 연산 결과 저장
        this.history.add(result);

        // 결과값 반환
        return Optional.ofNullable(result);
    }

    // Getter
    public void getHistory() {
        System.out.println("연산 기록: " + history);
    }

    // Setter
    public void setHistory(int indexNum, Double newNum) {
        history.set(indexNum, newNum);
        System.out.println("수정 완료.");
    }

    // 컬렉션 삭제
    public void removeHistory() {
        history.remove(0);
        System.out.println("첫 번째 연산 기록이 삭제되었습니다.");
    }

    // 람다 + 스트림
    public void findHistory(Double findNum) {
        List<Double> findHistory = history.stream()
                .filter(historyNum -> historyNum > findNum) // 입력값보다 큰 수 필터
                .sorted() // 정렬
                .toList();
        System.out.println("조회 결과: " + findHistory);
    }
}
