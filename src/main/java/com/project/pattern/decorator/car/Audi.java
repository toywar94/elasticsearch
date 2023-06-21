package com.project.pattern.decorator.car;

import com.project.pattern.decorator.Size;

public class Audi extends Car {

    public Audi(){
        description = "Audi";
    }

    //swich factory 패턴 쓰면 중복 코드 제거 가능할 것 같은데
    @Override
    public double cost() {
        return 10000 ;
    }
}
