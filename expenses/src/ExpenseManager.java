import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseManager {
    List<Expense> expenses = new ArrayList<>();

    public void displayAllExpenses()  //wyświetlenie wydatków
    {
        expenses.forEach(ExpenseManager::displayExpense);
    }

    private static void displayExpense(Expense expense) {
        System.out.println("Nazwa: " + expense.description());
        System.out.println("Typ:" + expense.type());
        System.out.println("Wartość: " + expense.value());
        System.out.println("Miesiąc: " + expense.month());
    }

    public void displayMonthlyExpenses(Scanner scanner) {
        System.out.println("Z którego miesiąca chcesz wyświetlić wydatki?");
        int month = Integer.parseInt(scanner.nextLine());
        //filtrowanie wydatkow pod katem danego miesiaca
        expenses.stream()
                .filter(expense -> expense.month() == month)
                .forEach(ExpenseManager::displayExpense);
    }

    public void addExpense(Scanner scanner) //wprowadzenie pozycji
    {
        System.out.println("Jaki wydatek chcesz dodać?");
        String description = scanner.nextLine();
        System.out.println("Jakiego typu jest to wydatek?");
        String type = scanner.nextLine();
        System.out.println("Ile to kosztowało?");
        double value = Double.parseDouble(scanner.nextLine());
        System.out.println("Z którego miesiąca wydatek?");
        int month = Integer.parseInt(scanner.nextLine());



        Expense expense = new Expense(type, month, value, description);
        expenses.add(expense);
    }
}
