package hu.uni.eszterhazy;

import java.time.LocalDate;
import java.util.UUID;

public class Customer {
    private final UUID id;
    private String name;
    private final LocalDate birthday;
    private String location;

    public Customer(UUID id, String name, LocalDate birthday, String location) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.location = location;
    }
}
