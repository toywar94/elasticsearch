package com.project.pattern;

import com.project.pattern.component.DefaultItem;
import com.project.pattern.component.Inventory;
import com.project.pattern.component.Item;
import com.project.pattern.component.ItemBag;
import com.project.pattern.decorator.Door;
import com.project.pattern.decorator.Navigation;
import com.project.pattern.decorator.Size;
import com.project.pattern.decorator.Wheel;
import com.project.pattern.decorator.car.Audi;
import com.project.pattern.decorator.car.Benz;
import com.project.pattern.decorator.car.Car;
import com.project.pattern.decorator.car.Ferrari;
import com.project.pattern.observer.MessagePublisher;
import com.project.pattern.observer.MessageSubscriber;
import com.project.pattern.observer.Observer;
import com.project.pattern.strategy.AggressiveStrategy;
import com.project.pattern.strategy.Character;
import com.project.pattern.strategy.DefensiveStrategy;
import com.project.pattern.strategy.TacticalStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PatternService {

    public void strategy(){

        Character character = new Character();
        //공격 전략
        character.setStrategy(new AggressiveStrategy());
        character.attackOpponent();

        //방어 전략
        character.setStrategy(new DefensiveStrategy());
        character.attackOpponent();

        //전술 전략
        character.setStrategy(new TacticalStrategy());
        character.attackOpponent();

    }

    public void observer(){
        MessagePublisher publisher = new MessagePublisher();

        Observer subscriber1 = new MessageSubscriber("kakao");
        Observer subscriber2 = new MessageSubscriber("naver");
        Observer subscriber3 = new MessageSubscriber("google");

        publisher.attach(subscriber1);
        publisher.attach(subscriber2);
        publisher.attach(subscriber3);

        publisher.sendMessage("할루 구독자들!");

        publisher.detach(subscriber2);

        publisher.sendMessage("remove someone");

    }

    public void decorator(){
        Car audi = new Audi();
        audi = new Wheel(audi);
        audi = new Door(audi);
        audi = new Navigation(audi);
        System.out.println(audi.getDescription() + " $" + audi.cost());

        Car ferrari = new Ferrari();
        ferrari = new Wheel(ferrari);
        ferrari = new Door(ferrari);
        System.out.println(ferrari.getDescription() + " $" + ferrari.cost());

        Car benz = new Benz();
        benz = new Wheel(benz);
        System.out.println(benz.getDescription() + " $" + benz.cost());

    }

    public void component(){
        Inventory inventory = new Inventory();
        Item longSword = new DefaultItem(1000, "긴 검");
        inventory.addItem(longSword);

        ItemBag beginnerBag = new ItemBag(120, "모험자의 가방");
        Item rareSword = new DefaultItem(600, "레어 검");
        Item uniqueSword = new DefaultItem(1200, "유니크 검");
        Item rarePant = new DefaultItem(500, "레어 바지");

        beginnerBag.addItem(rareSword);
        beginnerBag.addItem(uniqueSword);
        beginnerBag.addItem(rarePant);

        System.out.println("롱소드의 가격 : " + getPrice(longSword));
        System.out.println("모험자의 가방과 내부 아이템들의 가격 :  " + getPrice(beginnerBag));
        System.out.println("인벤토리 아이템 가격의 총 함계 : " + inventory.getAllPrice());

        beginnerBag.removeItem(rarePant);
        System.out.println("모험자의 가방과 내부 아이템들의 가격 - Pant :  " + getPrice(beginnerBag));
    }

    private static int getPrice(Item item){
        return item.getPrice();
    }
}
