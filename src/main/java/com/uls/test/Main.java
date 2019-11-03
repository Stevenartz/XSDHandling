package com.uls.test;

import java.io.File;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

import com.uls.generated.ObjectFactory;
import com.uls.generated.ShoppingList;
import com.uls.generated.ShoppingList.Products.Product;
import com.uls.generated.ShoppingList.Units.Unit;

public class Main {

	private Scanner scanner = new Scanner(System.in);
	private ObjectFactory factory = new ObjectFactory();

	public static void main(String[] args) {
		new Main();
	}

	public Main() {

		String input;

		while (true) {
			System.out.print("Unmarshal or marshal? (1, 2): ");
			input = scanner.nextLine();
			if (input.equals("1")) {
				System.out.println("Unmarshalling...");
				unmarshal();
			} else if (input.equals("2")) {
				System.out.println("Marshalling...");
				marshal();
			} else {
				System.out.println("Shutting down...");
				System.exit(0);
			}
		}

	}

	void unmarshal() {
		ShoppingList list = null;
		try {
			File file = new File("shoppingList.xml");
			JAXBContext jc = JAXBContext.newInstance(ShoppingList.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			JAXBElement<ShoppingList> jaxbElement = (JAXBElement<ShoppingList>) unmarshaller.unmarshal(new StreamSource(file), ShoppingList.class);
			list = jaxbElement.getValue();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		if (list != null) {
			System.out.println("Products: " + list.getProducts().getProduct().size());
			for (Product p : list.getProducts().getProduct()) {
				System.out.println("Product: [id = " + p.getId() + ", unitId = " + p.getUnitId() + ", name = " + p.getName() + ", amount = " + p.getAmount() + ", expiryDate = " + p.getExpiryDate() + "]");
			}
			System.out.println("Units: " + list.getUnits().getUnit().size());
			for (Unit u : list.getUnits().getUnit()) {
				u.getId();
				u.getName();
				u.getSymbol();
				u.isDeletable();
				System.out.println("Unit: [id = " + u.getId() + ", name = " + u.getName() + ", symbol = " + u.getSymbol() + ", deletable = " + u.isDeletable() + "]");
			}
		}
	}

	void marshal() {
		ShoppingList list = factory.createShoppingList();

		list.setProducts(factory.createShoppingListProducts());
		list.setUnits(factory.createShoppingListUnits());

		Product p1 = factory.createShoppingListProductsProduct();
		p1.setId(1);
		p1.setUnitId(1);
		p1.setName("Name");
		p1.setAmount(100d);
		try {
			p1.setExpiryDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
		} catch (DatatypeConfigurationException e1) {
			e1.printStackTrace();
		}

		list.getProducts().getProduct().add(p1);

		Unit u1 = factory.createShoppingListUnitsUnit();
		u1.setId(1);
		u1.setName("Kilogramm");
		u1.setSymbol("Kg");
		u1.setDeletable(false);

		Unit u2 = factory.createShoppingListUnitsUnit();
		u2.setId(2);
		u2.setName("Liter");
		u2.setSymbol("L");
		u2.setDeletable(false);

		list.getUnits().getUnit().addAll(Arrays.asList(u1, u2));

		try {
			JAXBContext jc = JAXBContext.newInstance(ShoppingList.class);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(new JAXBElement<ShoppingList>(new QName("", "shoppinglist"), ShoppingList.class, list),
					System.out);
			marshaller.marshal(new JAXBElement<ShoppingList>(new QName("", "shoppinglist"), ShoppingList.class, list),
					new File("shoppingList.xml"));

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
