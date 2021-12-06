package com.csl.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Location {
    private Long locationId;
    private String country;
    private String province;
    private String city;
    private String address;

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
