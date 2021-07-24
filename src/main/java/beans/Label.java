
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Label {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("idBoard")
    @Expose
    private String idBoard;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("color")
    @Expose
    private String color;
}
