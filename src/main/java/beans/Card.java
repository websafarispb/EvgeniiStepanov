
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Card {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("checkItemStates")
    @Expose
    private List<Object> checkItemStates = new ArrayList<Object>();
    @SerializedName("closed")
    @Expose
    private Boolean closed;
    @SerializedName("dateLastActivity")
    @Expose
    private String dateLastActivity;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("descData")
    @Expose
    private DescData descData;
    @SerializedName("dueReminder")
    @Expose
    private Object dueReminder;
    @SerializedName("idBoard")
    @Expose
    private String idBoard;
    @SerializedName("idList")
    @Expose
    private String idList;
    @SerializedName("idMembersVoted")
    @Expose
    private List<Object> idMembersVoted = new ArrayList<Object>();
    @SerializedName("idShort")
    @Expose
    private Integer idShort;
    @SerializedName("idAttachmentCover")
    @Expose
    private Object idAttachmentCover;
    @SerializedName("idLabels")
    @Expose
    private List<Object> idLabels = new ArrayList<Object>();
    @SerializedName("manualCoverAttachment")
    @Expose
    private Boolean manualCoverAttachment;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("pos")
    @Expose
    private Integer pos;
    @SerializedName("shortLink")
    @Expose
    private String shortLink;
    @SerializedName("isTemplate")
    @Expose
    private Boolean isTemplate;
    @SerializedName("cardRole")
    @Expose
    private Object cardRole;
    @SerializedName("dueComplete")
    @Expose
    private Boolean dueComplete;
    @SerializedName("due")
    @Expose
    private Object due;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("labels")
    @Expose
    private List<Object> labels = new ArrayList<Object>();
    @SerializedName("shortUrl")
    @Expose
    private String shortUrl;
    @SerializedName("start")
    @Expose
    private Object start;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("idMembers")
    @Expose
    private List<Object> idMembers = new ArrayList<Object>();
    @SerializedName("badges")
    @Expose
    private Badges badges;
    @SerializedName("subscribed")
    @Expose
    private Boolean subscribed;
    @SerializedName("idChecklists")
    @Expose
    private List<Object> idChecklists = new ArrayList<Object>();
    @SerializedName("cover")
    @Expose
    private Cover cover;
}
