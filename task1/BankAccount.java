import java.time.LocalDateTime;

public class BankAccount {

    private String ownerName;
    private int balance;
    private LocalDateTime openingDate;
    private boolean isBlocked;

    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0;
        this.openingDate = LocalDateTime.now();
        this.isBlocked = false;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getBalance() {
        return balance;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public boolean deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            System.out.println("Сумма пополнения должна быть больше 0.");
            return false;
        }
    }

    public boolean withdraw(int amount) {
        if (amount > 0 && amount <= this.balance && !isBlocked) {
            this.balance -= amount;
            return true;
        } else if (isBlocked) {
            System.out.println("Счет заблокирован, снятие невозможно.");
            return false;
        } else {
            System.out.println("Недостаточно средств на счете или сумма снятия некорректна.");
            return false;
        }
    }

    public boolean transfer(BankAccount otherAccount, int amount) {
        if (amount > 0 && amount <= this.balance && otherAccount != null && !isBlocked) {
            if (this.withdraw(amount)) { // Используем метод withdraw для снятия денег
                if (otherAccount.deposit(amount)) { //Используем deposit для пополнения
                    return true;
                } else {
                    // Если пополнение на другой счет не удалось, возвращаем деньги на исходный счет
                    this.deposit(amount);
                    System.out.println("Ошибка при переводе средств на счет " + otherAccount.getOwnerName() + ". Средства возвращены.");
                    return false;
                }
            } else {
                return false; // withdraw уже выведет причину неудачи
            }

        } else if (isBlocked) {
            System.out.println("Счет заблокирован, перевод невозможен.");
            return false;
        } else {
            System.out.println("Недостаточно средств на счете, некорректная сумма перевода или счет назначения недействителен.");
            return false;
        }
    }
}