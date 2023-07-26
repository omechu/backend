package com.hongik.omechu.controller;

import com.hongik.omechu.service.OmechuService;
import com.hongik.omechu.service.dto.FoodResponse;
import com.hongik.omechu.service.dto.FoodsResponse;
import com.hongik.omechu.service.dto.RoomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Void> confirm(@PathVariable String roomUuid) {
        return ResponseEntity.ok(omechuService.confirm());
    }
}
