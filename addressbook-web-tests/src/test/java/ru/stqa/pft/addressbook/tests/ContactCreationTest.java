package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup( new GroupData("test1",null,null));}

    app.getNavigationHelper().gotoContactCreationPage();
    app.getContactHelper().createContact(new ContactData("firstname", "lastname", "address", "mobile", "email","test1" ));
    app.getSessionHelper().logout();

  }


}
