package screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.IOException;
import java.util.*;

public class ShoppingScreen extends BaseScreen {

    public ShoppingScreen(AndroidDriver driver) {
        super(driver);
    }

    //Mobile Elements
    String buttonListEmpty = "No list selected";
    String buttonNewList = "NEW LIST";
    String textFieldListName = "Add new shopping list";
    String textFieldAddItem = "Add item";
    String buttonAdd = "ADD";
    String buttonEdit = "EDIT";
    String buttonRemove = "REMOVE";
    String buttonArchive = "ARCHIVE";
    String buttonDelete = "Delete";
    String ArchiveListEmpty = "There are no archived lists.";
    String buttonDeleteConfirmation = "DELETE";
    String screenNoList= "There are no current lists, create one!";
    String checkboxes = "//android.widget.CheckBox";
    String buttonAddItemOne = "//android.view.View[@content-desc=\"Add some items to your list!\"]/android.widget.Button";
    String buttonAddItem = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button";

    //Functions over mobile elements
    public void clickButtonListEmpty() {
        click(MobileBy.AccessibilityId(buttonListEmpty));
    }

    public void clickButtonNewList() {
        click(MobileBy.AccessibilityId(buttonNewList));
    }

    public void clickButtonAdd() {
        click(MobileBy.AccessibilityId(buttonAdd));
    }

    public void clickButtonEdit() {
        click(MobileBy.AccessibilityId(buttonEdit));
    }

    public void clickButtonRemove() {
        click(MobileBy.AccessibilityId(buttonRemove));
    }

    public void clickButtonDelete() {
        click(MobileBy.AccessibilityId(buttonDelete));
    }

    public void clickButtonDeleteConfirmation() {
        click(MobileBy.AccessibilityId(buttonDeleteConfirmation));
    }

    public void clickButtonArchive() {
        click(MobileBy.AccessibilityId(buttonArchive));
    }

    public void clickButtonAddItemOne() {
        click(By.xpath(buttonAddItemOne));
    }

    public void clickButtonAddItem() {
        click(By.xpath(buttonAddItem));
    }

    public void clickOnItemList(String item) {
        click(MobileBy.AccessibilityId(item));
    }

    public void clickAllCheckBoxItems() {
        clickOnFindElements(By.xpath(checkboxes));
    }

    public void createList(String text) throws IOException {
        sendTextNative(MobileBy.AccessibilityId(textFieldListName), text);
    }

    public void writeItem(String text) throws IOException {
        sendTextNative(MobileBy.AccessibilityId(textFieldAddItem), text);
    }

    public void writeItemUpdate(String text) throws IOException {
        sendTextNative(text);
    }

    public void addListItemsToList(Map<String, String> dataElements) throws IOException {

        Set<Map.Entry<String, String>> entrySet = dataElements.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            if (index == 0) {
                clickButtonAddItemOne();
            } else {
                clickButtonAddItem();
            }
            writeItem(iterator.next().getKey());
            clickButtonAdd();
            index++;
        }
    }

    public void editEachitemsToList(Map<String, String> dataElements) throws IOException {

        Iterator<Map.Entry<String, String>> iterator = dataElements.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            clickOnItemList(entry.getKey());
            scroll(MobileBy.AccessibilityId(buttonEdit));
            clickButtonEdit();
            writeItemUpdate(" - " + entry.getValue() + " units");
            pressEnter();
            hideKeyboard();
            clickBackButtonNative();
            sleep(2000);
        }
    }


    public void deleteItemToList(Map<String, String> dataElements, String item){

        Iterator<Map.Entry<String, String>> iterator = dataElements.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if(entry.getKey().contains(item)){
                clickOnItemList(entry.getKey() + " - " + entry.getValue() + " units");
                scroll(MobileBy.AccessibilityId(buttonEdit));
                clickButtonRemove();
            }
        }
    }

    public void swipeCurrentToArchive(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(screenNoList)));
        int startX = 585;
        int startY = 669;
        int endX = 76;
        int endY = 669;
        TouchAction action = new TouchAction(driver);
        action.press(startX, startY);
        action.moveTo(endX, endY);
        action.release();
        action.perform();
    }

    public void tabByCoordinatesThreePointsButton(){
        sleep(3000);
        (new TouchAction(driver)).tap(661, 393).perform();
    }

    public void verifyArchiveListEmpty(){
        waitAndFindElement(MobileBy.AccessibilityId(ArchiveListEmpty));
    }

    public void verifyCurrentListEmpty(){
        waitAndFindElement(MobileBy.AccessibilityId(screenNoList));
    }

    public void swipeArchiveToCurrent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(ArchiveListEmpty)));
        int startX = 76;
        int startY = 669;
        int endX = 585;
        int endY = 669;
        TouchAction action = new TouchAction(driver);
        action.press(startX, startY);
        action.moveTo(endX, endY);
        action.release();
        action.perform();
    }

}
