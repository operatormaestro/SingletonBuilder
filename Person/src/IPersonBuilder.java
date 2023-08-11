public interface IPersonBuilder {
    IPersonBuilder setName(String name);

    IPersonBuilder setSurname(String surname);

    IPersonBuilder setAge(int age);

    IPersonBuilder setAddress(String address);

    Person build();

}
