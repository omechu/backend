package com.hongik.omechu.service.dto;

public record FoodResponse(
        Long foodId,
        String name,
        String imgUrl,
        String description) {
}
