package calculator;

import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // 스캐너 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 변수 선언
        InputNum<Double> firstNum = new InputNum<>(); // 첫 번째 수
        InputNum<Double> secondNum = new InputNum<>(); // 두 번째 수
        char operator; // 사칙연산 기호
        double result; // 연산 결과 저장
        String exit; // 종료 확인
        double findNum; // 연산 결과 조회 기준

        // Calculator 인스턴스 생성
        Calculator<Double> calculator = new Calculator<>();

        while (true) {
            // 양의 정수 입력 받기
            while(true){
                System.out.print("첫 번째 숫자를 입력하세요: ");
                try {
                    firstNum.setNum(scanner.nextDouble());
                    break;
                } catch (Exception e) {
                    System.out.println("숫자가 아닙니다.");
                    scanner.next();
                }
            }

            while(true){
                System.out.print("두 번째 숫자를 입력하세요: ");
                try {
                    secondNum.setNum(scanner.nextDouble());
                    break;
                } catch (Exception e) {
                    System.out.println("숫자가 아닙니다.");
                    scanner.next();
                }
            }

            // 버퍼 비우기
            scanner.nextLine();

            // 사칙연산 기호 입력받기
            while(true){
                System.out.print("사칙연산 기호를 입력하세요: ");
                operator = scanner.nextLine().charAt(0);

                if (operator == '+' || operator == '-' || operator == '*' || operator == '/'){
                    break;
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            }

            // 연산
            Optional<Double> calculate = calculator.calculate(firstNum.getNum(), secondNum.getNum(), operator);

            // 결과값 출력
            if (calculate.isPresent()) {
                result = calculate.get();
                System.out.println("결과: " + result);
            } else {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                continue;
            }

            // Getter 사용
            calculator.getHistory();

            // 반복문 종료
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");
            exit = scanner.nextLine();
            if (exit.equals("exit")) {
                break;
            }

        }

        // Setter 사용
        calculator.setHistory(0, 0.0);
        calculator.getHistory();

        // 연산 결과 삭제 메서드
        calculator.removeHistory();
        calculator.getHistory();

        // 연산 결과 조회 메서드
        System.out.print("입력한 값보다 큰 연산 기록을 출력합니다: ");
        findNum = scanner.nextDouble();
        calculator.findHistory(findNum);
    }
}
