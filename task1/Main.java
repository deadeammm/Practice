public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Иван Иванов");
        BankAccount account2 = new BankAccount("Петр Петров");

        System.out.println("Счет 1 (Иван): Баланс = " + account1.getBalance());
        System.out.println("Счет 2 (Петр): Баланс = " + account2.getBalance());

        System.out.println("Пополнение счета 1 на 1000: " + account1.deposit(1000));
        System.out.println("Счет 1 (Иван): Баланс = " + account1.getBalance());

        System.out.println("Снятие со счета 1 500: " + account1.withdraw(500));
        System.out.println("Счет 1 (Иван): Баланс = " + account1.getBalance());

        System.out.println("Перевод со счета 1 на счет 2 200: " + account1.transfer(account2, 200));
        System.out.println("Счет 1 (Иван): Баланс = " + account1.getBalance());
        System.out.println("Счет 2 (Петр): Баланс = " + account2.getBalance());

        System.out.println("Попытка снятия со счета 1 1000 (недостаточно средств): " + account1.withdraw(1000));
        System.out.println("Счет 1 (Иван): Баланс = " + account1.getBalance());

        account1.setBlocked(true);
        System.out.println("Счет 1 заблокирован");
        System.out.println("Попытка снятия со счета 1 100: " + account1.withdraw(100));
        System.out.println("Перевод со счета 1 на счет 2 50: " + account1.transfer(account2, 50));
        account1.setBlocked(false);
        System.out.println("Счет 1 разблокирован");
        System.out.println("Снятие со счета 1 100: " + account1.withdraw(100));
        System.out.println("Счет 1 (Иван): Баланс = " + account1.getBalance());

    }
}