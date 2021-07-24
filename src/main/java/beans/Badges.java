
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Badges {

    @SerializedName("attachmentsByType")
    @Expose
    private AttachmentsByType attachmentsByType;
    @SerializedName("location")
    @Expose
    private Boolean location;
    @SerializedName("votes")
    @Expose
    private Integer votes;
    @SerializedName("viewingMemberVoted")
    @Expose
    private Boolean viewingMemberVoted;
    @SerializedName("subscribed")
    @Expose
    private Boolean subscribed;
    @SerializedName("fogbugz")
    @Expose
    private String fogbugz;
    @SerializedName("checkItems")
    @Expose
    private Integer checkItems;
    @SerializedName("checkItemsChecked")
    @Expose
    private Integer checkItemsChecked;
    @SerializedName("checkItemsEarliestDue")
    @Expose
    private Object checkItemsEarliestDue;
    @SerializedName("comments")
    @Expose
    private Integer comments;
    @SerializedName("attachments")
    @Expose
    private Integer attachments;
    @SerializedName("description")
    @Expose
    private Boolean description;
    @SerializedName("due")
    @Expose
    private Object due;
    @SerializedName("dueComplete")
    @Expose
    private Boolean dueComplete;
    @SerializedName("start")
    @Expose
    private Object start;
}
