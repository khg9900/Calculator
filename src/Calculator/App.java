package Calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 스캐너 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 변수 선언
        int firstNum; // 첫 번째 정수
        int secondNum; // 두 번째 정수
        char operator; // 사칙연산 기호
        int result; // 결과값
        String exit; // 종료 확인

        while (true) {
            // 양의 정수 입력 받기
            while(true){
                System.out.print("첫 번째 숫자를 입력하세요: ");
                if (scanner.hasNextInt()){
                    firstNum = scanner.nextInt();
                    if (firstNum < 0) {
                        System.out.println("양의 정수가 아닙니다.");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("잘못된 입력입니다.");
                    scanner.next();
                }
            }

            while(true){
                System.out.print("두 번째 숫자를 입력하세요: ");
                if (scanner.hasNextInt()){
                    secondNum = scanner.nextInt();
                    if (secondNum < 0) {
                        System.out.println("양의 정수가 아닙니다.");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("잘못된 입력입니다.");
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

            // 초기화
            result = 0;

            // 연산
            switch (operator) {
                case '+' : result = firstNum + secondNum;
                    break;

                case '-' : result = firstNum - secondNum;
                    break;

                case '*' : result = firstNum * secondNum;
                    break;

                case '/' :
                    if (secondNum != 0){
                        result = firstNum / secondNum;
                    } else {
                        System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                        continue;
                    }
                    break;
            }

            // 결과값 출력
            System.out.println(result);

            // 반복문 종료
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            exit = scanner.nextLine();
            if (exit.equals("exit")) {
                break;
            }
        }
    }
}
