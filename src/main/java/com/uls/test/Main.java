package com.uls.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import com.uls.file.PropertyHandler;
import com.uls.generated.ShoppingList;
import com.uls.jaxb.JAXBHelper;

public class Main {

	public static void main(String[] args) {
		new Main();
	}

	public Main() {

//		JAXBHelper jaxbHelper = new JAXBHelper();
//		System.out.println(jaxbHelper.fetchShoppingList());
//		ShoppingList list = jaxbHelper.fetchShoppingList();
//		list.getUnits().getUnit().remove(0);
//		jaxbHelper.saveShoppingList(list);

		PropertyHandler propHandler = new PropertyHandler();
		//System.out.println(propHandler.removeProperty("db.user"));
		System.out.println(propHandler.getProperty("db.url"));
		
	}

}
