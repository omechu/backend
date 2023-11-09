package com.hongik.omechu.service;

import com.hongik.omechu.domain.Description;
import com.hongik.omechu.domain.Food;
import com.hongik.omechu.domain.Room;
import com.hongik.omechu.domain.RoomFood;
import com.hongik.omechu.repository.FoodRepository;
import com.hongik.omechu.repository.RoomFoodRepository;
import com.hongik.omechu.repository.RoomRepository;
import com.hongik.omechu.service.dto.FoodResponse;
import com.hongik.omechu.service.dto.FoodsResponse;
import com.hongik.omechu.service.dto.RoomResponse;
import java.util.List;
import java.util.Random;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OmechuService {

    private static final int SIZE = 7;
    private final FoodRepository foodRepository;
    private final RoomFoodRepository roomFoodRepository;
    private final RoomRepository roomRepository;


    public RoomResponse create(){
        Room room  = roomRepository.save(Room.create());
        return new RoomResponse(room.getUuid());
    }

    public FoodsResponse findTwoFoods(String roomUuid){
        FoodResponse response1 = findFood(roomUuid);
        FoodResponse response2 = findFood(roomUuid);
        return new FoodsResponse(response1, response2);
    }

    public FoodResponse findFood(String roomUuid) {
        Food food;
        do {
            // 랜덤으로 하나 가져오기
            final List<RoomFood> roomFoods = roomFoodRepository.findAll();
            if (roomFoods.size() == 12) {
                roomFoodRepository.deleteAll();
            }
            food = pickRandomFood();
            // roomFoodRepo에 uuid랑 있는지 확인
        } while (roomFoodRepository.existsByRoomUuidAndFoodId(roomUuid, food.getId()));

        roomFoodRepository.save(new RoomFood(null, roomUuid, food.getId()));

        Random random = new Random();
        int idx = random.nextInt(SIZE);
        String description = Description.VALUES.get(idx);
        return new FoodResponse(food.getId(), food.getName(), food.getImgUrl(), description);
    }

    private Food pickRandomFood() {
        List<Food> foods = foodRepository.findAll();
        int size = foods.size();

        Random random = new Random();
        int randomIndex = random.nextInt(size);
        return foods.get(randomIndex);
    }

    public void confirm(String roomUuid, Long foodId) {
        roomFoodRepository.save(new RoomFood(null, roomUuid, foodId));
    }
}
