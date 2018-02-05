package io.pivotal.events.sentimentui.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalyzerResponse {

    private Float score;
    private Float magnitude;

    public boolean isValid() {
        return score!=null && magnitude!=null;
    }
}
