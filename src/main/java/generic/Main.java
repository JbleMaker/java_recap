package generic;

public class Main {

    public static void showAll(Repository<? extends Student> repository){
        repository.findAll().forEach(System.out::println);
    }

    public static void main(String[] args) {
        Repository<HighStudent> hsRepo = new Repository<>();
        Repository<AcademyStudent> asRepo = new Repository<>();

        hsRepo.save(new HighStudent());
        asRepo.save(new AcademyStudent());

        hsRepo.findAll().forEach(hs -> hs.toString());
        asRepo.findAll().forEach(as -> as.getName());

        showAll(hsRepo);
        showAll(asRepo);
    }
}
