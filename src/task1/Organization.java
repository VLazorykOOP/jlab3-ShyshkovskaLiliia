package task1;

class Organization {

    protected String name;
    protected String address;
    protected int yearFounded;

    public Organization(String name, String address, int yearFounded) {
        this.name = name;
        this.address = address;
        this.yearFounded = yearFounded;
    }

    Organization() {
    }

    public void Show() {
        System.out.println("Дані про Організацію: ");
        System.out.println("Назва: " + name);
        System.out.println("Адреса: " + address);
        System.out.println("Рік заснування: " + yearFounded);
    }
}

// 2. Підклас: Страхова компанія
class InsuranceCompany extends Organization {
    private int numberOfClients;
    private long totalInsurancePremium;

    public InsuranceCompany(String name, String address, int yearFounded, int numberOfClients, long totalInsurancePremium) {
        super(name, address, yearFounded);
        this.numberOfClients = numberOfClients;
        this.totalInsurancePremium = totalInsurancePremium;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Тип: Страхова компанія");
        System.out.println("Кількість клієнтів: " + numberOfClients);
        System.out.println("Загальна страхова премія (грн): " + totalInsurancePremium);
    }
}

// 3. Підклас: Нафтогазова компанія
class OilGasCompany extends Organization {
    private double oilExtractionVolume;
    private String mainProduct;

    public OilGasCompany(String name, String address, int yearFounded, double oilExtractionVolume, String mainProduct) {
        super(name, address, yearFounded);
        this.oilExtractionVolume = oilExtractionVolume;
        this.mainProduct = mainProduct;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Тип: Нафтогазова компанія");
        System.out.println("Обсяг видобутку нафти (т/рік): " + oilExtractionVolume);
        System.out.println("Основний продукт: " + mainProduct);
    }
}

// 4. Підклас: Завод
class Factory extends Organization {
    private String industry;
    private int numberOfWorkshops;

    public Factory(String name, String address, int yearFounded, String industry, int numberOfWorkshops) {
        super(name, address, yearFounded);
        this.industry = industry;
        this.numberOfWorkshops = numberOfWorkshops;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Тип: Завод");
        System.out.println("Галузь: " + industry);
        System.out.println("Кількість цехів: " + numberOfWorkshops);
    }
}