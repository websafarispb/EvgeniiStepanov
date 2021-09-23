
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Prefs {

    @SerializedName("permissionLevel")
    @Expose
    private String permissionLevel;
    @SerializedName("hideVotes")
    @Expose
    private Boolean hideVotes;
    @SerializedName("voting")
    @Expose
    private String voting;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("invitations")
    @Expose
    private String invitations;
    @SerializedName("selfJoin")
    @Expose
    private Boolean selfJoin;
    @SerializedName("cardCovers")
    @Expose
    private Boolean cardCovers;
    @SerializedName("isTemplate")
    @Expose
    private Boolean isTemplate;
    @SerializedName("cardAging")
    @Expose
    private String cardAging;
    @SerializedName("calendarFeedEnabled")
    @Expose
    private Boolean calendarFeedEnabled;
    @SerializedName("background")
    @Expose
    private String background;
    @SerializedName("backgroundImage")
    @Expose
    private String backgroundImage;
    @SerializedName("backgroundImageScaled")
    @Expose
    private List<BackgroundImageScaled> backgroundImageScaled = new ArrayList<BackgroundImageScaled>();
    @SerializedName("backgroundTile")
    @Expose
    private Boolean backgroundTile;
    @SerializedName("backgroundBrightness")
    @Expose
    private String backgroundBrightness;
    @SerializedName("backgroundBottomColor")
    @Expose
    private String backgroundBottomColor;
    @SerializedName("backgroundTopColor")
    @Expose
    private String backgroundTopColor;
    @SerializedName("canBePublic")
    @Expose
    private Boolean canBePublic;
    @SerializedName("canBeEnterprise")
    @Expose
    private Boolean canBeEnterprise;
    @SerializedName("canBeOrg")
    @Expose
    private Boolean canBeOrg;
    @SerializedName("canBePrivate")
    @Expose
    private Boolean canBePrivate;
    @SerializedName("canInvite")
    @Expose
    private Boolean canInvite;
}
