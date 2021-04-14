import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAliasType;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @ClassName: chen-tool
 * @Description: TODO
 * @Author: 陈亮平
 * @Date: 2021/2/23 14:49
 * @Version: v1.0
 */

@XStreamAlias("USER")
public class User {
    @XStreamAlias("NAME")
    private String name;
    @XStreamAlias("ACCOUNT")
    private String account;
    @XStreamAlias("BOOKS")
    private List<Book> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
