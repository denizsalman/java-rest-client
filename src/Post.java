import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*Json'daki herhangi bir ekstra property'i (POJO'da karşılığı olmayanlar)
 görmezden gelmek isteyebilirsiniz.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Post {
    //@JsonProperty anotasyon'u JSON objesindeki özellik ile POJO daki field'i map eder.
    @JsonProperty("userId")
    private int userId;

    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    private String body;

    public Post() {
    }

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
