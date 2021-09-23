
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Member {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("activityBlocked")
    @Expose
    private Boolean activityBlocked;
    @SerializedName("avatarHash")
    @Expose
    private Object avatarHash;
    @SerializedName("avatarUrl")
    @Expose
    private Object avatarUrl;
    @SerializedName("bio")
    @Expose
    private String bio;
    @SerializedName("bioData")
    @Expose
    private Object bioData;
    @SerializedName("confirmed")
    @Expose
    private Boolean confirmed;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("idEnterprise")
    @Expose
    private Object idEnterprise;
    @SerializedName("idEnterprisesDeactivated")
    @Expose
    private List<Object> idEnterprisesDeactivated = new ArrayList<Object>();
    @SerializedName("idMemberReferrer")
    @Expose
    private Object idMemberReferrer;
    @SerializedName("idPremOrgsAdmin")
    @Expose
    private List<Object> idPremOrgsAdmin = new ArrayList<Object>();
    @SerializedName("initials")
    @Expose
    private String initials;
    @SerializedName("memberType")
    @Expose
    private String memberType;
    @SerializedName("nonPublic")
    @Expose
    private NonPublic nonPublic;
    @SerializedName("nonPublicAvailable")
    @Expose
    private Boolean nonPublicAvailable;
    @SerializedName("products")
    @Expose
    private List<Object> products = new ArrayList<Object>();
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("status")
    @Expose
    private String status;
}
