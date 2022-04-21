package org.test.prolaborate.baseclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoClass extends BaseClass {

	public PojoClass() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement textEmail;

	@FindBy(id = "Password")
	private WebElement textPass;
	
	
	
	@FindBy(className= "svg-inline--fa fa-bars fa-w-14")
	private WebElement menu; 
	
	@FindBy(xpath= "(//fa-icon[@class='ng-fa-icon icon-hover-style'])[1]")
	private WebElement repoMenu;
	
	@FindBy(xpath="//span[contains(text(),'Discard')]")
	private WebElement editDiscard;
	
	@FindBy(xpath = "(//span[contains(text(),'Edit')])[1]")
	private WebElement repoEdit;
	
	@FindBy(xpath = "//input[@placeholder='Enter a suitable name']")
	private WebElement reponame;
	
	@FindBy(xpath = "//input[@placeholder='Enter Alias Name']")
	private WebElement aliasName;
	
	@FindBy(xpath ="//input[@placeholder='Enter the Model Name']")
	private WebElement modelName;
	
	@FindBy(xpath = "//input[@placeholder='Enter the Server DNS or IP address']")
	private WebElement serverName;

	@FindBy(xpath ="//input[@placeholder='Enter the Port']")
	private WebElement portNo;
	
	@FindBy(xpath="(//span[text()='Active'])[1]")
	private WebElement statusActive;
	
	@FindBy(xpath="(//div[@class='ng-input'])[1]")
	private WebElement protocolName;
	
	@FindBy(xpath ="//input[@placeholder='Enter Login of an EA user']")
	private WebElement eaLogin;
	
	public WebElement getEaLogin() {
		return eaLogin;
	}

	@FindBy(xpath = "//textarea[@placeholder='Give a summary of this repository to your users (Optional)']")
	private WebElement repoDescription;
	
	@FindBy(xpath= "//span[contains(text(),'Cancel')]")
	private WebElement repoCancel;
	
	@FindBy(xpath = "//span[contains(text(),'Save')]")
	private WebElement repoSave;
	
	@FindBy(xpath = "//span[contains(text(),'Delete')]")
	private WebElement repoDelete;
	
	@FindBy(xpath = "//a[contains(text(),'Repositories')]")
	private WebElement repoBreadcrumbs;
	
	@FindBy(xpath = "//header/div[2]/div[1]/a[1]/img[1]")
	private WebElement prolabHeaderIcon;
	
	@FindBy(xpath = "//span[contains(text(),'Add Repository')]")
	private WebElement addRepoBtn;
	
	@FindBy(xpath ="//img[@class='d-inline-block rounded-circle user-icon']")
	private WebElement profileIcon;
	
	@FindBy(xpath ="(//span[contains(text(),'Example Model')])[2]")// path of Sections page in repository
	private WebElement sectionsExMod;

	@FindBy(xpath = "//span[contains(text(),'Sign Out')]")
	private WebElement signout;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signIn;
	
	@FindBy(xpath = "(//span[contains(text(),'More')])[1]")
	private WebElement more1;
	
	@FindBy(xpath = "(//span[contains(text(),'More')])[2]")
	private WebElement more2;
	
	@FindBy(xpath = "//span[contains(text(),'Make Default')]")
	private WebElement makeDefault1;
	
	@FindBy(xpath="//span[contains(text(),'Configure Manually')]")
	private WebElement manualConfig;
	
	@FindBy(xpath="//span[contains(text(),'Configure Automatically')]")
	private WebElement autoConfig;
	
	@FindBy(xpath="//span[contains(text(),'Delete Anyway')]")
	private WebElement deleteAnyway;
	

	@FindBy(xpath="//span[contains(text(),'Go Back')]")
	private WebElement editGoBack;

	@FindBy(xpath="//input[@id='activeRepository']")
	private WebElement statusBtn;
	
	@FindBy(xpath="//ngb-alert[contains(text(),'Invalid Pro Cloud Server details! Please check the details in the Application Server')]")
	private WebElement invalidPCS;
	
	@FindBy(xpath="//input[@id='enableRequiredAuthendication']")
	private WebElement enableSecurity;
	
	public WebElement getEnableSecurity() {
		return enableSecurity;
	}

	public WebElement getInvalidPCS() {
		return invalidPCS;
	}

	public WebElement getStatusBtn() {
		return statusBtn;
	}

	public WebElement getDeleteAnyway() {
		return deleteAnyway;
	}

	public WebElement getRepoDelete() {
		return repoDelete;
	}
	
	public WebElement getManualConfig() {
		return manualConfig;
	}

	public WebElement getAutoConfig() {
		return autoConfig;
	}

	public WebElement getStatusActive() {
		return statusActive;
	}

	public WebElement getServerName() {
		return serverName;
	}

	public WebElement getPortNo() {
		return portNo;
	}

	public WebElement getProtocolName() {
		return protocolName;
	}

	public WebElement getModelName() {
		return modelName;
	}

	public WebElement getSectionsExMod() {
		return sectionsExMod;
	}

	public WebElement getRepoMenu() {
		return repoMenu;
	}

	public WebElement getRepoDescription() {
		return repoDescription;
	}
	
	public WebElement getAliasName() {
		return aliasName;
	}

	public WebElement getMore2() {
		return more2;
	}

	
	public WebElement getRepoSave() {
		return repoSave;
	}

	public WebElement getMakeDefault1() {
		return makeDefault1;
	}

	public WebElement getMore1() {
		return more1;
	}

	public WebElement getSignIn() {
		return signIn;
	}

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getAddRepoBtn() {
		return addRepoBtn;
	}

	public WebElement getProlabHeaderIcon() {
		return prolabHeaderIcon;
	}

	public WebElement getRepoBreadcrumbs() {
		return repoBreadcrumbs;
	}

	public WebElement getRepoEdit() {
		return repoEdit;
	}

	public WebElement getRepoCancel() {
		return repoCancel;
	}

	public WebElement getReponame() {
		return reponame;
	}

	public WebElement getEditDiscard() {
		return editDiscard;
	}

	public WebElement getEditGoBack() {
		return editGoBack;
	}

	public WebElement getMenu() {
		return menu;
	}

	public WebElement getTextEmail() {
		return textEmail;
	}

	public WebElement getTextPass() {
		return textPass;
	}
}
	