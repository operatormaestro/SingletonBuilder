public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);
        System.out.println("Возраст сына указан: " + son.hasAge());
        son.happyBirthday();
        son.setAddress("Москва");
        System.out.println("У " + mom + " есть сын, " + son);
        System.out.println("Возраст сына указан: " + son.hasAge());
        System.out.println(mom.getName());
        System.out.println(mom.getSurname());
        System.out.println(mom.getAge());
        System.out.println(mom.getAddress());
        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace(System.out);
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setName("Вася").setSurname("Иванов").setAge(-100).build(); // если не задать имя и фамилию срабатывет IllegalStateException раньше чем IllegalArgumentException
        } catch (IllegalArgumentException e) {
            e.printStackTrace(System.out);
        }
    }
}