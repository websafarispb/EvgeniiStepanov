
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Boards {

    @SerializedName("totalMembersPerBoard")
    @Expose
    private TotalMembersPerBoard totalMembersPerBoard;
}
