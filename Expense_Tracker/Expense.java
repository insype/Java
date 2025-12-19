public class Expense {

    private int id;
    private double amount;
    private ExpenseCategory category;
    private String description;

    public Expense(int id , double amount, ExpenseCategory category, String description){
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public void Display(){
        System.out.println(id +"|" +category +"|" +amount +"|" +description);
    }

    public double getAmount(){
        return amount;
    }
}
