package task1;

public class Task1 {
    public static void main(String[] args) {

        Organization[] organizations = new Organization[4];

        // 1. Страхова компанія
        organizations[0] = new InsuranceCompany(
                "Надійна Захист",
                "Київ, вул. Шевченка, 10",
                2005,
                55000,
                350000000L
        );

        // 2. Нафтогазова компанія
        organizations[1] = new OilGasCompany(
                "Чорне Золото UA",
                "Львів, пр. Свободи, 5",
                1998,
                150000.5,
                "Нафта та газ"
        );

        // 3. Завод
        organizations[2] = new Factory(
                "Металопрокат Плюс",
                "Дніпро, Заводська, 1",
                1970,
                "Металургія",
                12
        );

        // 4. Ще одна Страхова компанія для демонстрації
        organizations[3] = new InsuranceCompany(
                "Страховий Партнер",
                "Одеса, Приморський б-р, 7",
                2010,
                22000,
                120000000L
        );


        System.out.println("Список організацій : ");

        for (Organization org : organizations) {
            org.Show();
            System.out.println("-------------------------------------");
        }
    }
}