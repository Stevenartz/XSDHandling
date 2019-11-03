//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.11.03 um 05:15:37 PM CET 
//


package com.uls.generated;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.uls.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.uls.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ShoppingList }
     * 
     */
    public ShoppingList createShoppingList() {
        return new ShoppingList();
    }

    /**
     * Create an instance of {@link ShoppingList.Units }
     * 
     */
    public ShoppingList.Units createShoppingListUnits() {
        return new ShoppingList.Units();
    }

    /**
     * Create an instance of {@link ShoppingList.Products }
     * 
     */
    public ShoppingList.Products createShoppingListProducts() {
        return new ShoppingList.Products();
    }

    /**
     * Create an instance of {@link ShoppingList.Units.Unit }
     * 
     */
    public ShoppingList.Units.Unit createShoppingListUnitsUnit() {
        return new ShoppingList.Units.Unit();
    }

    /**
     * Create an instance of {@link ShoppingList.Products.Product }
     * 
     */
    public ShoppingList.Products.Product createShoppingListProductsProduct() {
        return new ShoppingList.Products.Product();
    }

}
