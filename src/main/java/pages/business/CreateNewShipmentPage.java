package pages.business;

import com.github.javafaker.Faker;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class CreateNewShipmentPage extends PageBase {
    public CreateNewShipmentPage(WebDriver driver) {
        super(driver);
    }

    // shipment type
    @FindBy(id = "formGridState")
    WebElement shipmentTypeList;

    // receiver details
    @FindBy(id = "name-control")
    WebElement receiverName;

    @FindBy(id = "phone-control")
    WebElement receiverPhone;

    @FindBy(id = "address_line-control")
    WebElement receiverAddress;

    @FindBy(id = "city-control")
    WebElement cityList;

    @FindBy(id = "zone-control")
    WebElement zoneList;

    @FindBy(id = "building-control")
    WebElement buildingTxt;

    @FindBy(id = "floor-control")
    WebElement floorTxt;

    @FindBy(id = "apt-control")
    WebElement apartmentTxt;

    // package details
    @FindBy(id = "document-control")
    WebElement packageTypeList;

    @FindBy(id = "no-items-control")
    WebElement noOfItemsTxt;

    @FindBy(id = "description-control")
    WebElement packageDescriptionTxt;

    // cash collection details
    @FindBy(id = "price-control")
    WebElement codTxt;

    @FindBy(id = "notes-control")
    WebElement notesTxt;

    @FindBy(css = "button.btn.btn-primary")
    WebElement submitBtn;

    @FindBy(id = "receiving_location-control")
    WebElement receivingLocationList;

    protected String pName, pPhone, pAddress, pBuildingNo, pFloorNo, pAptNo;
    protected String pPkgType, pNoOfItems, pPkgDescription, pNote, pCod;
    protected int pCityIndex = 1, pZoneIndex = 1;
    protected Select selectCityOptions;
    protected Select selectZonesOptions;
    protected Select selectPackageTypeOptions;
    protected Select selectShipmentType;

    public void setFakeShipmentData() throws InterruptedException {

        // fake data from gitHub Java Faker
        Faker fakeUser = new Faker();

        pName = fakeUser.name().fullName();
        pCod = fakeUser.number().digits(3);
        pPhone = "014" + fakeUser.number().digits(8);
        pAddress = fakeUser.address().streetAddress();
        pBuildingNo = "3";
        pFloorNo = "2";
        pAptNo = "1";
        pNoOfItems = fakeUser.number().digits(1);
        pPkgDescription = "Automated shipment";
        pPkgType = "Small Box";
        pNote = "Created shipment by selenium WebDriver";

        // select random city from the cities list
        Thread.sleep(1000);
        selectCityOptions = new Select(cityList);
        int noOfCities = selectCityOptions.getOptions().size();
        Random rand = new Random();
        pCityIndex = rand.nextInt(noOfCities -1 ) + 1;
        selectCityOptions.selectByIndex(pCityIndex);
        Thread.sleep(3000);

        // select random Zone from the Zones list
        selectZonesOptions = new Select(zoneList);
        int noOfZones = selectZonesOptions.getOptions().size();
        pZoneIndex = rand.nextInt(noOfZones -1 ) + 1;
        selectZonesOptions.selectByIndex(pZoneIndex);
    }

    public void createNewSendShipment() throws InterruptedException {

        selectShipmentType = new Select(shipmentTypeList);
        selectShipmentType.selectByVisibleText("Forward");

        // fake shipment data with Faker
        setFakeShipmentData();

        // fill the form data
        setTextElement(receiverName, pName);
        setTextElement(receiverPhone, pPhone);
        setTextElement(receiverAddress, pAddress);

        setTextElement(buildingTxt, pBuildingNo);
        setTextElement(floorTxt, pFloorNo);
        setTextElement(apartmentTxt, pAptNo);

        selectPackageTypeOptions = new Select(packageTypeList);
        selectPackageTypeOptions.selectByVisibleText(pPkgType);

        setTextElement(noOfItemsTxt, pNoOfItems);
        setTextElement(packageDescriptionTxt, pPkgDescription);
        setTextElement(codTxt, pCod);

        setTextElement(notesTxt, pNote);
        clickButton(submitBtn);

    }

    public void createNewCashCollection() throws InterruptedException {
        selectShipmentType = new Select(shipmentTypeList);
        selectShipmentType.selectByVisibleText("Cash Collection");

        // fake shipment data with Faker
        setFakeShipmentData();

        // fill the form data
        setTextElement(receiverName, pName);
        setTextElement(receiverPhone, pPhone);
        setTextElement(receiverAddress, pAddress);

        setTextElement(buildingTxt, pBuildingNo);
        setTextElement(floorTxt, pFloorNo);
        setTextElement(apartmentTxt, pAptNo);

        Select selectShipmentType = new Select(shipmentTypeList);
        selectShipmentType.selectByVisibleText("Cash Collection");

        setTextElement(codTxt, pCod);

        setTextElement(notesTxt, pNote);
        clickButton(submitBtn);
    }


    public void createNewCRPShipment() throws InterruptedException {
        selectShipmentType = new Select(shipmentTypeList);
        selectShipmentType.selectByVisibleText("Customer Return Pickup (CRP)");

        // fake shipment data with Faker
        setFakeShipmentData();
        // fill the form data
        setTextElement(receiverName, pName);
        setTextElement(receiverPhone, pPhone);
        setTextElement(receiverAddress, pAddress);

        setTextElement(buildingTxt, pBuildingNo);
        setTextElement(floorTxt, pFloorNo);
        setTextElement(apartmentTxt, pAptNo);

        selectShipmentType = new Select(shipmentTypeList);
        selectShipmentType.selectByVisibleText("Customer Return Pickup (CRP)");

        Select receivingLocationsList = new Select(receivingLocationList);
        receivingLocationsList.selectByVisibleText("Original business location");

        selectPackageTypeOptions = new Select(packageTypeList);
        selectPackageTypeOptions.selectByVisibleText(pPkgType);

        setTextElement(noOfItemsTxt, pNoOfItems);
        setTextElement(packageDescriptionTxt, pPkgDescription);


        setTextElement(notesTxt, pNote);
        clickButton(submitBtn);
    }

    public void createNewExchangeShipment() throws InterruptedException {

        selectShipmentType = new Select(shipmentTypeList);
        selectShipmentType.selectByVisibleText("Exchange");

        // fake shipment data with Faker
        setFakeShipmentData();
        // fill the form data
        setTextElement(receiverName, pName);
        setTextElement(receiverPhone, pPhone);
        setTextElement(receiverAddress, pAddress);

        setTextElement(buildingTxt, pBuildingNo);
        setTextElement(floorTxt, pFloorNo);
        setTextElement(apartmentTxt, pAptNo);

        selectPackageTypeOptions = new Select(packageTypeList);
        selectPackageTypeOptions.selectByVisibleText(pPkgType);

        setTextElement(noOfItemsTxt, pNoOfItems);
        setTextElement(packageDescriptionTxt, pPkgDescription);
        setTextElement(codTxt, pCod);

        setTextElement(notesTxt, pNote);
        clickButton(submitBtn);
    }
}