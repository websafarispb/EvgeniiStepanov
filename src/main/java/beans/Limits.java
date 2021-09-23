
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Limits {

    @SerializedName("attachments")
    @Expose
    private Attachments attachments;
    @SerializedName("boards")
    @Expose
    private Boards boards;
    @SerializedName("cards")
    @Expose
    private Cards cards;
    @SerializedName("checklists")
    @Expose
    private Checklists checklists;
    @SerializedName("checkItems")
    @Expose
    private CheckItems checkItems;
    @SerializedName("customFields")
    @Expose
    private CustomFields customFields;
    @SerializedName("customFieldOptions")
    @Expose
    private CustomFieldOptions customFieldOptions;
    @SerializedName("labels")
    @Expose
    private Labels labels;
    @SerializedName("lists")
    @Expose
    private Lists lists;
    @SerializedName("stickers")
    @Expose
    private Stickers stickers;
    @SerializedName("reactions")
    @Expose
    private Reactions reactions;
}
