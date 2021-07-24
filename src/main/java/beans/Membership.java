
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Membership {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("idMember")
    @Expose
    private String idMember;
    @SerializedName("memberType")
    @Expose
    private String memberType;
    @SerializedName("unconfirmed")
    @Expose
    private Boolean unconfirmed;
    @SerializedName("deactivated")
    @Expose
    private Boolean deactivated;
}
