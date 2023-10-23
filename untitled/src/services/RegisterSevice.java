package services;

import entities.Account;
import entities.Register;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterSevice {
    public void register(Scanner scanner, ArrayList<Account> accounts, Account account){
        System.out.println("Đăng Ký");
        System.out.println("Nhập username: ");
        String username = scanner.nextLine();
        for (Account user : accounts){
            if (user.getUsername().equals(username)){
                System.out.println("Username đã tồn tại. Vui lòng chọn username khác.");
                return;
            }
        }
        System.out.println("Nhập password (theo dạng có in hoa, chữ thường, số, kí tự đặc biệt (từ 7-15 kí tự)): ");
        String password = scanner.nextLine();

        if(!Account.validatePassword(password)){
            System.out.println("Mật khẩu không hợp lệ mời bạn nhập lại mật khẩu theo định dạng trên.");
            password = scanner.nextLine();
            if(!Account.validatePassword(password)){
                return;
            }
        }
        System.out.println("Nhâp email (theo dạng abc@gmail.com)");
        String email = scanner.nextLine();
        if(!Account.validateEmail(email)){
            System.out.println("Email không hợp lệ");
            return;
        }
        for (Account user : accounts){
             if (user.getEmail().equals(email)){
                System.out.println("Email đã tồn tại");
                return;
            }
        }
        Account account1 = new Account(username, password, email);
        accounts.add(account1);
        System.out.println("Đăng kí thành công! ");
    }

}
