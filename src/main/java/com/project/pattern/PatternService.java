package com.project.pattern;

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
}
