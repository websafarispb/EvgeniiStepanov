
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NonPublic {

    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("initials")
    @Expose
    private String initials;
    @SerializedName("avatarHash")
    @Expose
    private Object avatarHash;
}
