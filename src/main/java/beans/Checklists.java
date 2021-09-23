
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Checklists {

    @SerializedName("perBoard")
    @Expose
    private PerBoard perBoard;
    @SerializedName("perCard")
    @Expose
    private PerCard perCard;
}
