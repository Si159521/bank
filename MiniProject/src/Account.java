import java.util.Scanner;

public class Account {
    //입금과 출금을 처리하는 클래스
    Scanner scanner=new Scanner(System.in);
    Bank bank = new Bank();

    public void deposit(String accountNum){ //입금
        //계좌번호 입력
        System.out.println("계좌번호를 입력해주세요.");
        accountNum=scanner.nextLine();
        double balance = bank.checkBalance(accountNum); //해당 계좌의 잔액
        
        System.out.print("입금할 금액을 입력해주세요 : ");
        double money = scanner.nextInt();  //입금액
        if (money <= 0) {
            throw new Exception.InvalidTransactionException("입금 금액은 0원보다 커야 합니다.");
        }
        balance += money;

        Customer customer=bank.findCustomer(accountNum); //계좌번호로 찾은 고객 객체 생성
        customer.setBalance(balance); //잔액 갱신
        System.out.println(money+"원이 입금되었습니다.");
        System.out.println("잔액 : "+balance+"원");
    }

    public void withdraw(String accountNum){ //출금
        System.out.println("계좌번호를 입력해주세요.");
        accountNum=scanner.nextLine();
        double balance = bank.checkBalance(accountNum); //해당 계좌의 잔액
        
        System.out.print("인출할 금액을 입력해주세요 : ");
        double money = scanner.nextInt(); //출금액
        if (money > balance) {
            throw new Exception.InvalidTransactionException("잔액이 부족합니다.");
        }
        balance -= money;

        Customer customer=bank.findCustomer(accountNum); //계좌번호로 찾은 고객 객체 생성
        customer.setBalance(balance); //잔액 갱신
        System.out.println(money+"원이 인출되었습니다.");
        System.out.println("잔액 : "+balance+"원");
    }
}
