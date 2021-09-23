
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomFieldOptions {

    @SerializedName("perField")
    @Expose
    private PerField perField;
}
