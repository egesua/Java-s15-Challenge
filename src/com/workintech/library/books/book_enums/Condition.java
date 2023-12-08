package com.workintech.library.books.book_enums;

import java.util.Random;

public enum Condition {
    FACTORY_NEW,
    MINIMAL_WEAR,
    FIELD_TESTED,
    WELL_WORN,
    BATTLE_SCARRED;

    public static Condition randomCondition(){
        Condition[] conditions = Condition.values();
        Random random = new Random();
        int randomIndex = random.nextInt(conditions.length);
        System.out.println(conditions[randomIndex]);
        return conditions[randomIndex];
    }
}
