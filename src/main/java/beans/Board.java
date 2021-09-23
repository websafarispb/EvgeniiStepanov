
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Board {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("descData")
    @Expose
    private Object descData;
    @SerializedName("closed")
    @Expose
    private Boolean closed;
    @SerializedName("dateClosed")
    @Expose
    private Object dateClosed;
    @SerializedName("idOrganization")
    @Expose
    private String idOrganization;
    @SerializedName("shortLink")
    @Expose
    private String shortLink;
    @SerializedName("powerUps")
    @Expose
    private List<Object> powerUps = new ArrayList<Object>();
    @SerializedName("dateLastActivity")
    @Expose
    private Object dateLastActivity;
    @SerializedName("idTags")
    @Expose
    private List<Object> idTags = new ArrayList<Object>();
    @SerializedName("datePluginDisable")
    @Expose
    private Object datePluginDisable;
    @SerializedName("creationMethod")
    @Expose
    private Object creationMethod;
    @SerializedName("idBoardSource")
    @Expose
    private Object idBoardSource;
    @SerializedName("idMemberCreator")
    @Expose
    private String idMemberCreator;
    @SerializedName("idEnterprise")
    @Expose
    private Object idEnterprise;
    @SerializedName("pinned")
    @Expose
    private Boolean pinned;
    @SerializedName("starred")
    @Expose
    private Boolean starred;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("shortUrl")
    @Expose
    private String shortUrl;
    @SerializedName("enterpriseOwned")
    @Expose
    private Boolean enterpriseOwned;
    @SerializedName("ixUpdate")
    @Expose
    private String ixUpdate;
    @SerializedName("limits")
    @Expose
    private Limits limits;
    @SerializedName("subscribed")
    @Expose
    private Boolean subscribed;
    @SerializedName("templateGallery")
    @Expose
    private Object templateGallery;
    @SerializedName("premiumFeatures")
    @Expose
    private List<Object> premiumFeatures = new ArrayList<Object>();
    @SerializedName("dateLastView")
    @Expose
    private String dateLastView;
    @SerializedName("labelNames")
    @Expose
    private LabelNames labelNames;
    @SerializedName("prefs")
    @Expose
    private Prefs prefs;
    @SerializedName("actions")
    @Expose
    private List<Action> actions = new ArrayList<Action>();
    @SerializedName("cards")
    @Expose
    private List<Object> cards = new ArrayList<Object>();
    @SerializedName("labels")
    @Expose
    private List<Label> labels = new ArrayList<Label>();
    @SerializedName("lists")
    @Expose
    private List<Object> lists = new ArrayList<Object>();
    @SerializedName("members")
    @Expose
    private List<Member> members = new ArrayList<Member>();
    @SerializedName("checklists")
    @Expose
    private List<Object> checklists = new ArrayList<Object>();
    @SerializedName("customFields")
    @Expose
    private List<Object> customFields = new ArrayList<Object>();
    @SerializedName("memberships")
    @Expose
    private List<Membership> memberships = new ArrayList<Membership>();
    @SerializedName("pluginData")
    @Expose
    private List<Object> pluginData = new ArrayList<Object>();
}
