
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BackgroundImageScaled {

    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("url")
    @Expose
    private String url;
}
