
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LabelNames {

    @SerializedName("green")
    @Expose
    private String green;
    @SerializedName("yellow")
    @Expose
    private String yellow;
    @SerializedName("orange")
    @Expose
    private String orange;
    @SerializedName("red")
    @Expose
    private String red;
    @SerializedName("purple")
    @Expose
    private String purple;
    @SerializedName("blue")
    @Expose
    private String blue;
    @SerializedName("sky")
    @Expose
    private String sky;
    @SerializedName("lime")
    @Expose
    private String lime;
    @SerializedName("pink")
    @Expose
    private String pink;
    @SerializedName("black")
    @Expose
    private String black;
}
