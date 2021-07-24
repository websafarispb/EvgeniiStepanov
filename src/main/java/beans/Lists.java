
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Lists {

    @SerializedName("openPerBoard")
    @Expose
    private OpenPerBoard openPerBoard;
    @SerializedName("totalPerBoard")
    @Expose
    private TotalPerBoard totalPerBoard;
}
