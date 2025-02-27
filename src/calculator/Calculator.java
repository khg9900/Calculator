package calculator;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class Calculator {

    // 속성
    List<Integer> history = new ArrayList<>();
    private int result;

    // 생성자

    // 기능
    public Optional<Integer> calculate(int firstNum, int secondNum, char operator) {

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
                    return Optional.ofNullable(null);
                }
                break;
        }

        // 결과값 반환
        return Optional.ofNullable(this.result);
    }

}
