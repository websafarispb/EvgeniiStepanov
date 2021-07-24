
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Reactions {

    @SerializedName("perAction")
    @Expose
    private PerAction perAction;
    @SerializedName("uniquePerAction")
    @Expose
    private UniquePerAction uniquePerAction;
}
