package calculator;

import java.util.List;
import java.util.ArrayList;

public class Calculator {

    // 속성
    List<Integer> history = new ArrayList<>();
    int result;

    // 생성자

    // 기능
    public int calculate(int firstNum, int secondNum, char operator) {
        // 연산
        switch (operator) {
            case '+' : this.result = firstNum + secondNum;
                break;

            case '-' : this.result = firstNum - secondNum;
                break;

            case '*' : this.result = firstNum * secondNum;
                break;

            case '/' :
                if (secondNum != 0){
                    this.result = firstNum / secondNum;
                } else {
                    System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                }
                break;
        }

        // 연산 결과 저장
        this.history.add(this.result);
        // 결과값 반환
        return this.result;
    }

}
