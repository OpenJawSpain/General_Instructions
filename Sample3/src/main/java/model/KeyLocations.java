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
public class KeyLocations {
    private List<PositionedItem> pools;
    private List<PositionedItem> workplaces;
    private List<PositionedItem> dogParks;
}
