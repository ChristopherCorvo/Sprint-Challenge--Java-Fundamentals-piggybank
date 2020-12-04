package com.lambdaschool.piggybank.models;
// ------ Auto Imports ------
import javax.persistence.*;

//coinid, name, nameplural, value, quantity

@Entity
@Table(name = "coins")

public class Coin
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // ----- Table Fields -----
    private long coinid;
    private String name;
    private String nameplural;
    private long value;
    private int quantity;

    // Constructor #1
    public Coin()
    {
        // Default constructor = required for spring data JPA
    }

    // Constructor #2 w/ parameters
    public Coin(
        long coinid,
        String name,
        String nameplural,
        long value,
        int quantity)
    {
        this.coinid = coinid;
        this.name = name;
        this.nameplural = nameplural;
        this.value = value;
        this.quantity = quantity;
    }

    // Getters and Setters

    public long getCoinid()
    {
        return coinid;
    }

    public void setCoinid(long coinid)
    {
        this.coinid = coinid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNameplural()
    {
        return nameplural;
    }

    public void setNameplural(String nameplural)
    {
        this.nameplural = nameplural;
    }

    public long getValue()
    {
        return value;
    }

    public void setValue(long value)
    {
        this.value = value;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    // This determines the format of the returned information
    //coinid, name, nameplural, value, quantity
    @Override
    public String toString()
    {
        return "Coin{" +
            "name=" + name +
            "nameplural=" + nameplural +
            "value=" + value +
            "quantity=" + quantity +
            "}";
    }
}
