package com.example.demo;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * "result": "success", "documentation":
 * "https://www.exchangerate-api.com/docs", "terms_of_use":
 * "https://www.exchangerate-api.com/terms", "time_last_update_unix":
 * 1609718401, "time_last_update_utc": "Mon, 04 Jan 2021 00:00:01 +0000",
 * "time_next_update_unix": 1609804816, "time_next_update_utc": "Tue, 05 Jan
 * 2021 00:00:16 +0000", "base_code": "USD"
 */

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Xchange {

	private String result;
	private String documentation;
	private String terms_of_use;
	private String time_last_update_unix;
	private String time_last_update_utc;
	private String time_next_update_unix;
	private String time_next_update_utc;
	private String base_code;
	private Map<String, String> conversion_rates;

}
