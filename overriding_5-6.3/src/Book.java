public class Book {
    String title;
    String author;
    String publisher;
    String releaseDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void printInfo()
    {
        System.out.println("Book Information:");
        System.out.println("\tBook Title: "+title);
        System.out.println("\tAuthor: "+author);
        System.out.println("\tPublisher: "+publisher);
        System.out.println("\tPublication Date: "+releaseDate);
    }
}
class Encyclopedia extends Book{
    String edition;
    int pages;

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public void printInfo()
    {
        super.printInfo();
        System.out.println("\tEdition: "+edition);
        System.out.println("\tNumber of Pages: "+pages);

    }
}
