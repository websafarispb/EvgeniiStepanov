
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MemberCreator {

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
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("idMemberReferrer")
    @Expose
    private Object idMemberReferrer;
    @SerializedName("initials")
    @Expose
    private String initials;
    @SerializedName("nonPublic")
    @Expose
    private NonPublic nonPublic;
    @SerializedName("nonPublicAvailable")
    @Expose
    private Boolean nonPublicAvailable;
    @SerializedName("username")
    @Expose
    private String username;
}
