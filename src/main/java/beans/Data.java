
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
@lombok.Data
public class Data {

    @SerializedName("board")
    @Expose
    private Board board;
    @SerializedName("organization")
    @Expose
    private Organization organization;
}
