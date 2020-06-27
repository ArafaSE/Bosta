package pages.business;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    public void createNewSendShipment(
            String rName, String rPhone, String rAddress, String rCity, String rDistrict,
            String buildingNo, String floorNo, String aptNo, String pkgType, String noOfItems,
            String pkgDescription, String note, String cod) {

        setTextElement(receiverName, rName);
        setTextElement(receiverPhone, rPhone);
        setTextElement(receiverAddress, rAddress);
        Select selectCityOptions = new Select(cityList);
        selectCityOptions.selectByVisibleText(rCity);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select selectZonesOptions = new Select(zoneList);
        selectZonesOptions.selectByVisibleText(rDistrict);

        setTextElement(buildingTxt, buildingNo);
        setTextElement(floorTxt, floorNo);
        setTextElement(apartmentTxt, aptNo);

        Select selectPackageTypeOptions = new Select(packageTypeList);
        selectPackageTypeOptions.selectByVisibleText(pkgType);

        setTextElement(noOfItemsTxt, noOfItems);
        setTextElement(packageDescriptionTxt, pkgDescription);
        setTextElement(codTxt, cod);
        setTextElement(notesTxt, note);
        clickButton(submitBtn);
    }

    public void createNewCashCollection(
            String rName, String rPhone, String rAddress, String rCity, String rDistrict,
            String buildingNo, String floorNo, String aptNo, String cod, String note) {
        Select selectShipmentType = new Select(shipmentTypeList);
        selectShipmentType.selectByVisibleText("Cash Collection");

        setTextElement(receiverName, rName);
        setTextElement(receiverPhone, rPhone);
        setTextElement(receiverAddress, rAddress);
        Select selectCityOptions = new Select(cityList);
        selectCityOptions.selectByVisibleText(rCity);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select selectZonesOptions = new Select(zoneList);
        selectZonesOptions.selectByVisibleText(rDistrict);

        setTextElement(buildingTxt, buildingNo);
        setTextElement(floorTxt, floorNo);
        setTextElement(apartmentTxt, aptNo);

        setTextElement(codTxt, cod);
        setTextElement(notesTxt, note);
        clickButton(submitBtn);
    }


    public void createCRPShipment(String rName, String rPhone, String rAddress, String rCity, String rDistrict,
                                  String buildingNo, String floorNo, String aptNo, String note,
                                  String pkgType, String noOfItems, String pkgDescription) {
        Select selectShipmentType = new Select(shipmentTypeList);
        selectShipmentType.selectByVisibleText("Customer Return Pickup (CRP)");

        setTextElement(receiverName, rName);
        setTextElement(receiverPhone, rPhone);
        setTextElement(receiverAddress, rAddress);
        Select selectCityOptions = new Select(cityList);
        selectCityOptions.selectByVisibleText(rCity);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select selectZonesOptions = new Select(zoneList);
        selectZonesOptions.selectByVisibleText(rDistrict);

        setTextElement(buildingTxt, buildingNo);
        setTextElement(floorTxt, floorNo);
        setTextElement(apartmentTxt, aptNo);

        Select receivingLocationsList = new Select(receivingLocationList);
        receivingLocationsList.selectByVisibleText("Original business location");

        Select selectPackageTypeOptions = new Select(packageTypeList);
        selectPackageTypeOptions.selectByVisibleText(pkgType);

        setTextElement(noOfItemsTxt, noOfItems);
        setTextElement(packageDescriptionTxt, pkgDescription);
        setTextElement(notesTxt, note);
        clickButton(submitBtn);
    }

    public void createNewExchangeShipment(String rName, String rPhone, String rAddress, String rCity, String rDistrict,
                                          String buildingNo, String floorNo, String aptNo, String pkgType, String noOfItems,
                                          String pkgDescription, String note, String cod){

        Select selectShipmentType = new Select(shipmentTypeList);
        selectShipmentType.selectByVisibleText("Exchange");

        setTextElement(receiverName, rName);
        setTextElement(receiverPhone, rPhone);
        setTextElement(receiverAddress, rAddress);
        Select selectCityOptions = new Select(cityList);
        selectCityOptions.selectByVisibleText(rCity);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select selectZonesOptions = new Select(zoneList);
        selectZonesOptions.selectByVisibleText(rDistrict);

        setTextElement(buildingTxt, buildingNo);
        setTextElement(floorTxt, floorNo);
        setTextElement(apartmentTxt, aptNo);

        Select selectPackageTypeOptions = new Select(packageTypeList);
        selectPackageTypeOptions.selectByVisibleText(pkgType);
        setTextElement(noOfItemsTxt, noOfItems);
        setTextElement(packageDescriptionTxt, pkgDescription);

        setTextElement(codTxt, cod);
        setTextElement(notesTxt, note);
        clickButton(submitBtn);
    }
}