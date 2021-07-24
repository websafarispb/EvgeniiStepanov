
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Action {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("idMemberCreator")
    @Expose
    private String idMemberCreator;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("appCreator")
    @Expose
    private Object appCreator;
    @SerializedName("limits")
    @Expose
    private Limits limits;
    @SerializedName("memberCreator")
    @Expose
    private MemberCreator memberCreator;
}
