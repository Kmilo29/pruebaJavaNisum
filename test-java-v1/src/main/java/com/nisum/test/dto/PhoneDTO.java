package com.nisum.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PhoneDTO(String number, @JsonProperty("citycode") String cityCode,
		@JsonProperty("countrycode") String countryCode) {
}
