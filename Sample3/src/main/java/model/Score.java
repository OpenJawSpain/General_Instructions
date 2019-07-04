package model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Score {
    @Builder.Default
    private int modifierPerWorker = Integer.MIN_VALUE;
    @Builder.Default
    private int modifierPerChildren = Integer.MIN_VALUE;
    @Builder.Default
    private int modifierPerDog = Integer.MIN_VALUE;
}