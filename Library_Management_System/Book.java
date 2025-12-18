public class Book{
    public int id;
    public String bookName;
    public boolean isIssued;
    public boolean isAvailable;
    
    public Book(int id, String bookName, boolean isIssued, boolean isAvailable){
        this.id = id;
        this.bookName = bookName;
        this.isIssued = isIssued;
        this.isAvailable = isAvailable;
    }

    public void issueBook()
    {
        if(isAvailable){
        isIssued = true;
        isAvailable = false;
        }
        else{
            System.out.println("book is not available ");
        }
    }

    public void returnBook()
    {
        if(!isAvailable)
        {
            isIssued = false;
            isAvailable = true;
        }
        else {
            System.out.println("Book was already in the library ");
        }
    }

    public void displayBook()
    {
        System.out.println("book id :"+id);
        System.out.println("book name :"+bookName);
        String is_issued = (isIssued)?"book is issued":"book is not issued by anyone ";
        String is_available = (isAvailable)?"book is available":"book is not available in the Library ";
        System.out.println(is_issued);
        System.out.println(is_available);
    }
}