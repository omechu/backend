package com.hongik.omechu.service;

import com.hongik.omechu.domain.Food;
import com.hongik.omechu.domain.Room;
import com.hongik.omechu.repository.DescriptionRepository;
import com.hongik.omechu.repository.FoodRepository;
import com.hongik.omechu.repository.RoomFoodRepository;
import com.hongik.omechu.repository.RoomRepository;
import com.hongik.omechu.service.dto.FoodResponse;
import com.hongik.omechu.service.dto.FoodsResponse;
import com.hongik.omechu.service.dto.RoomResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OmechuService {

    private final DescriptionRepository descriptionRepository;
    private final FoodRepository foodRepository;
    private final RoomFoodRepository roomFoodRepository;
    private final RoomRepository roomRepository;


    public RoomResponse create(){
        Room room  = roomRepository.save(Room.create());

    }

    public FoodsResponse findTwoFoods(){
        FoodResponse response1 = findFood();
        FoodResponse response2 = findFood();

    }

    public FoodResponse findFood(String roomUuid) {
        List<Food> foods = foodRepository.findAll();
        Food food = null;
        while (true) {
            // 랜덤으로 하나 가져오기
            food = pickRandomFood(foods);
            // roomFoodRepo에 uuid랑 있는지 확인
            if (roomFoodRepository.existsByRoomUuidAndFoodId(roomUuid, )) {
                continue;
            }
        }
        //
    }

    public void confirm() {

    }
}
