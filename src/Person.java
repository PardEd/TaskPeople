import java.time.LocalDateTime;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private boolean ageKnown = false;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this (name, surname);
        this.age = age;
        ageKnown = true;
    }

    public Person(String name, String surname, int age, String address) {
        this (name, surname, age);
        ageKnown = true;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        LocalDateTime dateBirthday;
        if ( ageKnown ) {
            age++;
        }
    }

    public boolean hasAge() {
        return ageKnown;
    }

    public boolean hasAddress() {
        return address != null;
    }

    PersonBuilder newChildBuilder() {
        return new PersonBuilder ().setSurname (this.surname)
                .setAge (0)
                .setAddress (this.address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + getName () + '\'' +
                ", surname='" + getSurname () + '\'' +
                ", age=" + getAge () +
                ", address='" + getAddress () + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || this.getClass () != o.getClass () ) return false;
        Person person = (Person) o;
        return (age != 0 && name.equals (person.getName ())
                || (name.equals (person.getName ()))
                || (surname.equals (person.getSurname ()))
                || (address.equals (person.getAddress ())));
    }

    @Override
    public int hashCode() {
        final int prime = 144;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode ()) +
                ((surname == null) ? 0 : surname.hashCode ()) +
                ((address == null) ? 0 : address.hashCode ());
        return result;
    }
}