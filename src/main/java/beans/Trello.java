
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Trello {

    @SerializedName("board")
    @Expose
    private Integer board;
    @SerializedName("card")
    @Expose
    private Integer card;
}
