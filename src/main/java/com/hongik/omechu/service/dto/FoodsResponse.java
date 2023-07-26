package com.hongik.omechu.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FoodsResponse(@JsonProperty("food1") FoodResponse food1,
                            @JsonProperty("food2") FoodResponse food2) {
}
