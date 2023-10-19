package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BaseTest {

 public HomePage() {
  PageFactory.initElements(driver, this);
 }

//Elements

 @FindBy(className = "product_sort_container")
 public WebElement sortDropDown;

 @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
 public List<WebElement> addButtons;


//Products

 //class=inventory_list
 //InventoryItemObject class= inventory_item
 // inventory_item_img
 // inventory_item_description
 // inventory_item_label (name and description)
 //pricebar > inventory_item_price


 @FindBy(className = "inventory_item_name")
 public List<WebElement> productsNames;
 @FindBy(className = "inventory_item_desc")
 public List<WebElement> productDescriptions;
 @FindBy(className = "inventory_item_img")
 public List<WebElement> productImages;
 @FindBy(className = "inventory_item_price")
 public List<WebElement> productPrices;


//-----------------------------------------------------------------------------



 public void clickOnAddToCart(int index) {
  for (int i = 0; i < addButtons.size(); i++) {
   if (index == i) {
    addButtons.get(i).click();
    break;
   }
  }
 }


 //Doraditi ovu metodu ako je vec neki item dodat
 public void addAllToCart() {
  for (WebElement addButton : addButtons)
   addButton.click();
 }


 public void selectSortingOption(String optionText) {
  Select sortDropdownSelect = new Select(sortDropDown);
  sortDropdownSelect.selectByVisibleText(optionText);
 }


 //--------------------------------------------------------------------------------

 //Products methods

 public void clickOnProductName(int index) {
  for (int i = 0; i < productsNames.size(); i++) {
   if (index == i) {
    productsNames.get(i).click();
    break;
   }
  }
 }

 public ArrayList<String> getProductNames () {

   ArrayList<String> productNames = new ArrayList<>();

  for (int i = 0; i < productsNames.size(); i++) {
    productNames.add(productsNames.get(i).getText()) ;}

  return productNames;
 }

 /* public ArrayList<String> getProductName (int index) {

  String name= "";

  for (int i = 0; i < productsNames.size(); i++) {
   if (index == i) {
    name= productsNames.get(i).getText();
    break;


  return name;
 }}} */

 public ArrayList<String> getProductDescriptions () {

  ArrayList<String> productDescriptions = new ArrayList<>();

  for (int i = 0; i < productDescriptions.size(); i++) {
   productDescriptions.add(productsNames.get(i).getText()) ;}

  return productDescriptions;
 }
/*
 public ArrayList<String> getProductPrices () {

  ArrayList<String> productPrices = new ArrayList<>();

  for (int i = 0; i < productPrices.size(); i++) {
   productPrices.add(productPrices.get(i).getText()) ;}

  return productPrices;
 } */

 public ArrayList<Double> getProductPrices() {
  ArrayList<Double> productPrices = new ArrayList<>();
  List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));

  for (WebElement element : priceElements) {
   String priceText = element.getText().replaceAll("[^0-9.]", "");
   double price = Double.parseDouble(priceText);
   productPrices.add(price);
  }

  return productPrices;
 }





 public boolean allImagesAreDisplayed () {
  for (int i = 0; i < productImages.size(); i++) {

   if (productImages.get(i).getAttribute("src").isEmpty()){
    return false;
    }}

  return true;
 }


 public void clickOnProductImages (int index) {
  for (int i = 0; i < productImages.size(); i++) {
   if (index == i) {
    productImages.get(i).click();
    break;}}}




}