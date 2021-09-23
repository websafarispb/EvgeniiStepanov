
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Organization {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
}
