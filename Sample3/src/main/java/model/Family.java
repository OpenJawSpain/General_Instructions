package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Family extends PositionedItem {
    private String name;
    private int workers;
    private int children;
    private int dogs;
    @JsonProperty("Budget")
    private float budget;
}
