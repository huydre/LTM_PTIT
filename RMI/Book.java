package RMI;

import java.io.Serializable;

public class Book implements Serializable {
    private String id, title, author, code;
    private int yearPublished, pageCount;
    private static final long serialVersionUID = 20241123L;
    public Book() {}
    public Book(String id, String title, String author, int yearPublished, int pageCount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.pageCount = pageCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPulished) {
        this.yearPublished = yearPulished;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", code='" + code + '\'' +
                ", yearPublished=" + yearPublished +
                ", pageCount=" + pageCount +
                '}';
    }
}
