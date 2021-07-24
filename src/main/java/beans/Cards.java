
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Cards {

    @SerializedName("openPerBoard")
    @Expose
    private OpenPerBoard openPerBoard;
    @SerializedName("openPerList")
    @Expose
    private OpenPerList openPerList;
    @SerializedName("totalPerBoard")
    @Expose
    private TotalPerBoard totalPerBoard;
    @SerializedName("totalPerList")
    @Expose
    private TotalPerList totalPerList;
}
