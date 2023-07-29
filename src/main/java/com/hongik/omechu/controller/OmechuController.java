package com.hongik.omechu.controller;

import com.hongik.omechu.domain.Food;
import com.hongik.omechu.service.OmechuService;
import com.hongik.omechu.service.dto.FoodResponse;
import com.hongik.omechu.service.dto.FoodsResponse;
import com.hongik.omechu.service.dto.RoomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OmechuController {

    public final OmechuService omechuService;

    @PostMapping("/api/room")
    public ResponseEntity<RoomResponse> create() {
        return ResponseEntity.ok(omechuService.create());
    }

    @GetMapping("/api/room/{roomUuid}/foods")
    public ResponseEntity<FoodsResponse> findFoods(@PathVariable String roomUuid) {
        return ResponseEntity.ok(omechuService.findTwoFoods(roomUuid));
    }

    @GetMapping("/api/room/{roomUuid}/food")
    public ResponseEntity<FoodResponse> findFood(@PathVariable String roomUuid) {
        return ResponseEntity.ok(omechuService.findFood(roomUuid));
    }

    @PostMapping("/api/room/{roomUuid}/food")
    public ResponseEntity<Void> confirm(@PathVariable String roomUuid, @RequestBody Long foodId) {
        omechuService.confirm(roomUuid, foodId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
