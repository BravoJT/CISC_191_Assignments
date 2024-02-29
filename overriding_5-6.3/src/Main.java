public class Main {
    public static void main(String[] args)
    {
        Book book = new Book();
        book.setTitle("The Hobbit");
        book.setAuthor("J. R. R. Tolkien");
        book.setPublisher("George Allen & Unwin");
        book.setReleaseDate("21 September 1937");
        book.printInfo();

        Encyclopedia pedia = new Encyclopedia();
        pedia.setTitle("The Illustrated Encyclopedia of the Universe");
        pedia.setAuthor("Ian Ridpath");
        pedia.setPublisher("Watson-Guptill");
        pedia.setReleaseDate("2001");
        pedia.setEdition("2nd");
        pedia.setPages(384);
        pedia.printInfo();

    }
}
