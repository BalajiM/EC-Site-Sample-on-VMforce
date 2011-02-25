package com.vmforce.demo.sobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.force.sdk.jpa.annotation.CustomObject;

@Entity
@CustomObject(enableFeeds = true)
public class Ecsetting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String name;
	private String description;
	private String lang;
	
	// CSS
	private String cssbodybg;
	private String csscontainerbg;
	
	// Common
	private String companylogurl;
	private boolean isvalid;
	private String tabname1;
	private String tabname2;
	private String tabname3;
	private String tabname4;
	private String tabname5;
	
	// Home
	private String homesection1;
	private String homesection2;
	private String homelinktitle1;
	private String homelinktitle2;
	private String homelinktitle3;
	private String homelinkurl1;
	private String homelinkurl2;
	private String homelinkurl3;
	private String homelargeimgurl;
	
	// Company
	private String companysection1;
	private String companysection2;

	// Contact
	private String contactsection1;
	private String contactsection2;
	private String contactemail;
	private String contactsubject;
	private String contactdescription;

	// Product List
	private String productlistsection1;
	private String productlistsection2;
	
	// Product Detail
	private String productdetailaddcarturl;

	// Shopping Cart
	private String shoppingcartsection1;
	private String shoppingcartsection2;
	private String shoppingcartcontinueurl;
	private String shoppingcartdeleteurl;
	
	private String shoppingcartemptysection1;
	private String shoppingcartemptysection2;

	// Sign In
	private String signinsection1;
	private String signinemail;
	private String signinpassword;
	private String signinsubmit;
	
	// Sign Up
	private String signupsection1;
	private String signupsection2;
	private String signupemail;
	private String signupfirstname;
	private String signuplastname;
	private String signuppassword;
	private String signupphone;
	private String signupregister;
	private String signupreset;
	
	// Confirm
	private String confirmsection1;
	private String confirmsection2;
	private String confirmaccepturl;
	
	// Thank you
	private String thankyousection1;
	private String thankyousection2;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setHomesection1(String homesection1) {
		this.homesection1 = homesection1;
	}

	public String getHomesection1() {
		return homesection1;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setHomesection2(String homesection2) {
		this.homesection2 = homesection2;
	}

	public String getHomesection2() {
		return homesection2;
	}

	public void setCompanysection1(String companysection1) {
		this.companysection1 = companysection1;
	}

	public String getCompanysection1() {
		return companysection1;
	}

	public void setCompanysection2(String companysection2) {
		this.companysection2 = companysection2;
	}

	public String getCompanysection2() {
		return companysection2;
	}

	public void setContactsection1(String contactsection1) {
		this.contactsection1 = contactsection1;
	}

	public String getContactsection1() {
		return contactsection1;
	}

	public void setContactsection2(String contactsection2) {
		this.contactsection2 = contactsection2;
	}

	public String getContactsection2() {
		return contactsection2;
	}

	public void setProductlistsection1(String productlistsection1) {
		this.productlistsection1 = productlistsection1;
	}

	public String getProductlistsection1() {
		return productlistsection1;
	}

	public void setProductlistsection2(String productlistsection2) {
		this.productlistsection2 = productlistsection2;
	}

	public String getProductlistsection2() {
		return productlistsection2;
	}

	public void setShoppingcartsection1(String shoppingcartsection1) {
		this.shoppingcartsection1 = shoppingcartsection1;
	}

	public String getShoppingcartsection1() {
		return shoppingcartsection1;
	}

	public void setSigninsection1(String signinsetction1) {
		this.signinsection1 = signinsetction1;
	}

	public String getSigninsection1() {
		return signinsection1;
	}

	public void setHomelinktitle1(String homelinktitle1) {
		this.homelinktitle1 = homelinktitle1;
	}

	public String getHomelinktitle1() {
		return homelinktitle1;
	}

	public void setHomelinktitle2(String homelinktitle2) {
		this.homelinktitle2 = homelinktitle2;
	}

	public String getHomelinktitle2() {
		return homelinktitle2;
	}

	public void setHomelinktitle3(String homelinktitle3) {
		this.homelinktitle3 = homelinktitle3;
	}

	public String getHomelinktitle3() {
		return homelinktitle3;
	}

	public void setHomelinkurl1(String homelinkurl1) {
		this.homelinkurl1 = homelinkurl1;
	}

	public String getHomelinkurl1() {
		return homelinkurl1;
	}

	public void setHomelinkurl2(String homelinkurl2) {
		this.homelinkurl2 = homelinkurl2;
	}

	public String getHomelinkurl2() {
		return homelinkurl2;
	}

	public void setHomelinkurl3(String homelinkurl3) {
		this.homelinkurl3 = homelinkurl3;
	}

	public String getHomelinkurl3() {
		return homelinkurl3;
	}

	public void setCompanylogurl(String companylogurl) {
		this.companylogurl = companylogurl;
	}

	public String getCompanylogurl() {
		return companylogurl;
	}

	public void setHomelargeimgurl(String homelargeimgurl) {
		this.homelargeimgurl = homelargeimgurl;
	}

	public String getHomelargeimgurl() {
		return homelargeimgurl;
	}

	public void setIsvalid(boolean isvalid) {
		this.isvalid = isvalid;
	}

	public boolean isIsvalid() {
		return isvalid;
	}

	public void setTabname1(String tabname1) {
		this.tabname1 = tabname1;
	}

	public String getTabname1() {
		return tabname1;
	}

	public void setTabname2(String tabname2) {
		this.tabname2 = tabname2;
	}

	public String getTabname2() {
		return tabname2;
	}

	public void setTabname3(String tabname3) {
		this.tabname3 = tabname3;
	}

	public String getTabname3() {
		return tabname3;
	}

	public void setTabname4(String tabname4) {
		this.tabname4 = tabname4;
	}

	public String getTabname4() {
		return tabname4;
	}

	public void setTabname5(String tabname5) {
		this.tabname5 = tabname5;
	}

	public String getTabname5() {
		return tabname5;
	}

	public void setConfirmsection1(String confirmsection1) {
		this.confirmsection1 = confirmsection1;
	}

	public String getConfirmsection1() {
		return confirmsection1;
	}

	public void setConfirmsection2(String confirmsection2) {
		this.confirmsection2 = confirmsection2;
	}

	public String getConfirmsection2() {
		return confirmsection2;
	}

	public void setShoppingcartsection2(String shoppingcartsection2) {
		this.shoppingcartsection2 = shoppingcartsection2;
	}

	public String getShoppingcartsection2() {
		return shoppingcartsection2;
	}

	public void setThankyousection1(String thankyousection1) {
		this.thankyousection1 = thankyousection1;
	}

	public String getThankyousection1() {
		return thankyousection1;
	}

	public void setThankyousection2(String thankyousection2) {
		this.thankyousection2 = thankyousection2;
	}

	public String getThankyousection2() {
		return thankyousection2;
	}

	public void setShoppingcartemptysection1(String shoppingcartemptysection1) {
		this.shoppingcartemptysection1 = shoppingcartemptysection1;
	}

	public String getShoppingcartemptysection1() {
		return shoppingcartemptysection1;
	}

	public void setShoppingcartemptysection2(String shoppingcartemptysection2) {
		this.shoppingcartemptysection2 = shoppingcartemptysection2;
	}

	public String getShoppingcartemptysection2() {
		return shoppingcartemptysection2;
	}

	public void setSignupsection1(String signupsection1) {
		this.signupsection1 = signupsection1;
	}

	public String getSignupsection1() {
		return signupsection1;
	}

	public void setSignupsection2(String signupsection2) {
		this.signupsection2 = signupsection2;
	}

	public String getSignupsection2() {
		return signupsection2;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setSigninemail(String signinemail) {
		this.signinemail = signinemail;
	}

	public String getSigninemail() {
		return signinemail;
	}

	public void setSigninpassword(String signinpassword) {
		this.signinpassword = signinpassword;
	}

	public String getSigninpassword() {
		return signinpassword;
	}

	public void setSigninsubmit(String signinsubmit) {
		this.signinsubmit = signinsubmit;
	}

	public String getSigninsubmit() {
		return signinsubmit;
	}

	public void setSignupemail(String signupemail) {
		this.signupemail = signupemail;
	}

	public String getSignupemail() {
		return signupemail;
	}

	public void setSignupfirstname(String signupfirstname) {
		this.signupfirstname = signupfirstname;
	}

	public String getSignupfirstname() {
		return signupfirstname;
	}

	public void setSignuplastname(String signuplastname) {
		this.signuplastname = signuplastname;
	}

	public String getSignuplastname() {
		return signuplastname;
	}

	public void setSignuppassword(String signuppassword) {
		this.signuppassword = signuppassword;
	}

	public String getSignuppassword() {
		return signuppassword;
	}

	public void setSignupphone(String signupphone) {
		this.signupphone = signupphone;
	}

	public String getSignupphone() {
		return signupphone;
	}

	public void setSignupregister(String signupregister) {
		this.signupregister = signupregister;
	}

	public String getSignupregister() {
		return signupregister;
	}

	public void setSignupreset(String signupreset) {
		this.signupreset = signupreset;
	}

	public String getSignupreset() {
		return signupreset;
	}

	public void setProductdetailaddcarturl(String productdetailaddcarturl) {
		this.productdetailaddcarturl = productdetailaddcarturl;
	}

	public String getProductdetailaddcarturl() {
		return productdetailaddcarturl;
	}

	public void setShoppingcartcontinueurl(String shoppingcartcontinueurl) {
		this.shoppingcartcontinueurl = shoppingcartcontinueurl;
	}

	public String getShoppingcartcontinueurl() {
		return shoppingcartcontinueurl;
	}

	public void setShoppingcartdeleteurl(String shoppingcartdeleteurl) {
		this.shoppingcartdeleteurl = shoppingcartdeleteurl;
	}

	public String getShoppingcartdeleteurl() {
		return shoppingcartdeleteurl;
	}

	public void setConfirmaccepturl(String confirmaccepturl) {
		this.confirmaccepturl = confirmaccepturl;
	}

	public String getConfirmaccepturl() {
		return confirmaccepturl;
	}

	public void setContactemail(String contactemail) {
		this.contactemail = contactemail;
	}

	public String getContactemail() {
		return contactemail;
	}

	public void setContactsubject(String contactsubject) {
		this.contactsubject = contactsubject;
	}

	public String getContactsubject() {
		return contactsubject;
	}

	public void setContactdescription(String contactdescription) {
		this.contactdescription = contactdescription;
	}

	public String getContactdescription() {
		return contactdescription;
	}

	public void setCssbodybg(String cssbodybg) {
		this.cssbodybg = cssbodybg;
	}

	public String getCssbodybg() {
		return cssbodybg;
	}

	public void setCsscontainerbg(String csscontainerbg) {
		this.csscontainerbg = csscontainerbg;
	}

	public String getCsscontainerbg() {
		return csscontainerbg;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getLang() {
		return lang;
	}

}
