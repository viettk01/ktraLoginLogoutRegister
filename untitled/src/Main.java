import entities.Account;
import entities.Login;
import menu.Menu;
import services.LoginService;
import services.RegisterSevice;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        Account account = new Account();
        LoginService login = new LoginService();
        RegisterSevice register = new RegisterSevice();
        Menu menu = new Menu();
        menu.menuDisplay(scanner, accounts, login, register,account);
    }
}