
package com.moonstonks.moonstonksbackendnew.model.API;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "01. symbol",
    "02. open",
    "03. high",
    "04. low",
    "05. price",
    "06. volume",
    "07. latest trading day",
    "08. previous close",
    "09. change",
    "10. change percent"
})
@Data
public class GlobalQuote__1 {

    @JsonProperty("01. symbol")
    private String _01Symbol;
    @JsonProperty("02. open")
    private double _02Open;
    @JsonProperty("03. high")
    private double _03High;
    @JsonProperty("04. low")
    private double _04Low;
    @JsonProperty("05. price")
    private double currentPrice;
    @JsonProperty("06. volume")
    private double _06Volume;
    @JsonProperty("07. latest trading day")
    private String _07LatestTradingDay;
    @JsonProperty("08. previous close")
    private String _08PreviousClose;
    @JsonProperty("09. change")
    private String _09Change;
    @JsonProperty("10. change percent")
    private String _10ChangePercent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
