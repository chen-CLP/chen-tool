import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName: chen-tool
 * @Description: TODO
 * @Author: 陈亮平
 * @Date: 2021/2/23 14:49
 * @Version: v1.0
 */
@XStreamAlias("BOOK")
public class Book {
    @XStreamAlias("BOOK_NAME")
    private String bookName;
    @XStreamAlias("BOOK_PRICE")
    private String bookPrice;

    public Book() {
    }

    public Book(String bookName, String bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }
}
