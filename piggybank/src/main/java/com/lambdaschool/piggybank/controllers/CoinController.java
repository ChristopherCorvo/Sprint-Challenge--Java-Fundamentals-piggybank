package com.lambdaschool.piggybank.controllers;

// ------ Auto Imports ------
import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController
{
    @Autowired
    CoinRepository coinrepo;

    private List<Coin> findCoins(List<Coin> myList, CheckCoin tester)
    {
        List<Coin> tempList = new ArrayList<>();
        for(Coin c : myList)
        {
            if(tester.test(c))
            {
                tempList.add(c);
            }
        }
        return tempList;
    }

    // -------- Web Endpoints ----------

    // http://localhost:2019/total

    @GetMapping(value = "/total", produces = "application/json")
    public ResponseEntity<?> findTotalCoins()
    {
        List<Coin> myList = new ArrayList<>();
        coinrepo.findAll().iterator().forEachRemaining(myList::add);


        for(Coin c : myList)
        {
            // Find total value of every coin summed together
            // getQuantity() * getName()
            if(c.getQuantity() == 1)
            {
                System.out.println(c.getQuantity() + " " + c.getName());
            }
            else
            {
                System.out.println(c.getQuantity() + " " + c.getNameplural());
            }
        }

        double total = 0.0;
        for(Coin c : myList)
        {
            total = total + (c.getQuantity() * c.getValue());
        }
        System.out.println("The piggy bank holds " + total);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Stretch:
    // http://localhost:2019/money/{amount}

    @GetMapping(value = "/money/{amount}", produces = "application/json")
    public ResponseEntity<?> removeCoins(@PathVariable double amount)
    {
        List<Coin> myList = new ArrayList<>();
        coinrepo.findAll().iterator().forEachRemaining(myList::add);

        double total = 0.0;
        double total2 = 0.0;
        for(Coin c : myList)
        {
            total = total + (c.getQuantity() * c.getValue());
        }

        if(total < amount)
        {
            System.out.println("Not enough funds in piggy bank for this transaction.");
        }
        else
        {
            for(Coin c : myList)
            {
                if(c.getQuantity() >= 1)
                {
                    System.out.println("Line 96 " + amount);
                    amount = amount - (c.getQuantity() * c.getValue());
                    System.out.println("Line 97 " + c.getName() + (amount = amount - (c.getQuantity() * c.getValue())));
                    System.out.println("Line 98 " + amount);
                    c.setQuantity(0);
                    System.out.println("Line 100 " + c.getQuantity());
                }
                else if(amount == 0.0)
                {
                    for(Coin c1 : myList)
                    {
                        if(c1.getQuantity() == 1)
                        {
                            System.out.println(c.getQuantity() + " " + c1.getName());
                        }
                        else
                        {
                            System.out.println(c1.getQuantity() + " " + c1.getNameplural());
                        }

                        for(Coin c2 : myList)
                        {
                            total2 = total2 + (c2.getQuantity() * c2.getValue());
                            System.out.println(total2);
                        }
                    }
                }
            }
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
