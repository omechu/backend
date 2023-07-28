package com.hongik.omechu.repository;

import com.hongik.omechu.domain.RoomFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomFoodRepository extends JpaRepository<RoomFood, Long>  {

    boolean existsByRoomUuidAndFoodId(String roomUuid, Long foodId);

}
