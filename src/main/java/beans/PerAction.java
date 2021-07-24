
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PerAction {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("disableAt")
    @Expose
    private Integer disableAt;
    @SerializedName("warnAt")
    @Expose
    private Integer warnAt;
}
