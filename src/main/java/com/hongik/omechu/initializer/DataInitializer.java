package com.hongik.omechu.initializer;

import com.hongik.omechu.domain.Food;
import com.hongik.omechu.repository.FoodRepository;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.initDB();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final FoodRepository foodRepository;

        public void initDB() {
            List<Food> foods = new ArrayList<>(12);
            foods.add(new Food("햄버거", "https://dimg.donga.com/wps/NEWS/IMAGE/2022/01/02/111057059.1.edit.jpg"));
            foods.add(new Food("짜장면", "https://img.daily.co.kr/@files/www.daily.co.kr/content/food/2020/20200730/40d0fb3794229958bdd1e36520a4440f.jpg"));
            foods.add(new Food("삼겹살", "https://cdn.mindgil.com/news/photo/202004/69068_2873_1455.jpg"));
            foods.add(new Food("닭강정", "https://news.kbs.co.kr/data/news/2017/01/04/3405677_bH6.jpg"));
            foods.add(new Food("떡볶이", "https://img.freepik.com/free-photo/cheesy-tokbokki-korean-traditional-food-on-black-board-background-lunch-dish_1150-42992.jpg?size=626&ext=jpg&ga=GA1.1.386372595.1698451200&semt=ais"));
            foods.add(new Food("봉골레파스타", "https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/advices/166557187458549420.jpg?gif=1&w=480"));
            foods.add(new Food("피자", "https://src.hidoc.co.kr/image/lib/2020/11/9/1604911318873_0.jpg"));
            foods.add(new Food("비빔밥", "https://m.segye.com/content/image/2021/01/07/20210107516500.jpg"));
            foods.add(new Food("돈까스", "https://t1.daumcdn.net/cfile/tistory/99DE4D375ECFB46901"));
            foods.add(new Food("제육볶음", "https://i.namu.wiki/i/npjMucg7sLxIm8Uca8O3lygeM9UX2Dsu4RVnVxcDdaItsLZ6w0N0Ju54gVqn8O7r7taBR6bAEwL9qOLoUKKbzg.webp"));
            foods.add(new Food("칼국수", "https://i.namu.wiki/i/XOXY4Q4ix1v8LxEHg0MejrPs8uT6SKWM57pexVwJ-pqK0c7y8so9b70RMIRqaJ0aI1lVD7Uy0auXNyP_bk8_Ig.webp"));
            foods.add(new Food("치킨", "https://barunchicken.com/wp-content/uploads/2021/04/%EB%B0%98%EB%B0%98%EB%B0%94%EB%A5%B8%EC%B9%98%ED%82%A8.jpg"));
            foodRepository.saveAll(foods);
        }
    }
}
