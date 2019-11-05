package com.uls.jaxb;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

import com.uls.generated.ShoppingList;
import com.uls.generated.ShoppingList.Products.Product;
import com.uls.generated.ShoppingList.Units.Unit;

public class JAXBHelper {

	private final String FILE_NAME = "shoppingList.xml";
	
	public ShoppingList fetchShoppingList() {
		ShoppingList shoppingList = null;
		try {
			File file = new File(FILE_NAME);
			JAXBContext jc = JAXBContext.newInstance(ShoppingList.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			JAXBElement<ShoppingList> jaxbElement = (JAXBElement<ShoppingList>) unmarshaller
					.unmarshal(new StreamSource(file), ShoppingList.class);
			System.out.println("Unmarshalling...");
			shoppingList = jaxbElement.getValue();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return shoppingList;
	}

	public boolean saveShoppingList(ShoppingList shoppingList) {
		boolean status = false;
		if (shoppingList != null) {
			try {
				JAXBContext jc = JAXBContext.newInstance(ShoppingList.class);
				Marshaller marshaller = jc.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marshaller.marshal(
						new JAXBElement<ShoppingList>(new QName("", "shoppinglist"), ShoppingList.class, shoppingList),
						System.out);
				marshaller.marshal(
						new JAXBElement<ShoppingList>(new QName("", "shoppinglist"), ShoppingList.class, shoppingList),
						new File(FILE_NAME));
				System.out.println("Marshalling...");
				status = true;
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
		return status;
	}

}
