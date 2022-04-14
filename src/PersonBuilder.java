public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surName) {
        this.surname = surName;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 150) throw new IllegalStateException("Указан недопустимый возраст " + age + "!");
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) throw new IllegalStateException("Не заполены обязательные поля!");
        return new Person(name, surname, age, address);
    }
}