package LearningExtraInformation;

/**
 * Created by anna.r.petrosyan on 1/24/2018.
 */
public class PersonMethodChaining {

    private String name;
    private int age;

    public PersonMethodChaining setName(String name){
        this.name=name;
        return this;
    }

    public PersonMethodChaining setAge(int age){
        this.age=age;
        return this;
    }

    public void introduce(){
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }

    public static void main(String[] args) {
        PersonMethodChaining person = new PersonMethodChaining();
        person.setName("Peter").setAge(21).introduce();
        person.setName("a").setAge(8787).introduce();
    }

}
