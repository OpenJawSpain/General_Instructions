package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Scenario {
    private DimensionedItem map;
    private KeyLocations keyLocations;
    private List<Home> homes;
    private List<Family> families;
}
