// builder design pattern
public class Person {
    private String name;
    private int age;
    private String address;
    private String phoneNumber;

    private Person(PersonBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
    }

    public static class PersonBuilder {
        private String name;
        private int age;
        private String address;
        private String phoneNumber;

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder address(String address) {
            this.address = address;
            return this;
        }

        public PersonBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return this.name + " : " + this.age + " : " + this.phoneNumber + " : " + this.address;
    }
}

