
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DescData {

    @SerializedName("emoji")
    @Expose
    private Emoji emoji;
}
