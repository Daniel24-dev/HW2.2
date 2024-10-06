public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(15000);

        System.out.println("Текущий остаток на счете: " + account.getAmount());

        while (true) {
            try {
                account.withdraw(6000);
                System.out.println("Снято 6000 сом. Остаток на счете: " + account.getAmount());
            } catch (LimitException e) {
                double remainingAmount = e.getRemainingAmount();
                try {
                    account.withdraw(remainingAmount);
                    System.out.println("Снято оставшиеся " + remainingAmount + " сом. Остаток на счете: 0");
                } catch (LimitException ex) {

                    System.out.println("Ошибка: " + ex.getMessage());
                }
                break;
            }
        }
    }
}
