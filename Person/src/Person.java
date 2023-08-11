import java.util.Objects;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String address;
    private boolean hasAge = false;

/*    public Person(String name, String surname) { не вижу смысла оставлять конструкторы если мы сделали Builder, логика подсказывает, что не надо оставлять иные возможности создания объектов кроме как билдером.
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }*/

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException();
        }
        if (personBuilder.age > 0) {
            this.age = personBuilder.age;
            this.setHasAge();
        } else if (personBuilder.age == 0) {
            this.age = 0;
        } else {
            throw new IllegalArgumentException();
        }

        this.address = personBuilder.address;
    }

    public boolean hasAge() {
        return hasAge;
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
        System.out.println("С Днём рождения!!!");
        this.age++;
        this.setHasAge();
    }

    private void setHasAge() {
        this.hasAge = true;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.surname = this.surname;
        childBuilder.address = this.address;
        return childBuilder;
    }

    @Override
    public String toString() {
        if (this.age == 0) {
            return "Персонаж {" +
                    "Имя = '" + name + '\'' +
                    ", Фамилия = '" + surname + '\'' +
                    ", Адрес = '" + address + '\'' +
                    '}';
        } else {
            return "Персонаж {" +
                    "Имя = '" + name + '\'' +
                    ", Фамилия = '" + surname + '\'' +
                    ", Возраст = " + age +
                    ", Адрес = '" + address + '\'' +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
