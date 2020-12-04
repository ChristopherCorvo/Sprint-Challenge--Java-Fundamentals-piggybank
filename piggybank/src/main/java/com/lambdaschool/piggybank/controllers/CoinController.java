package com.lambdaschool.piggybank.controllers;

// ------ Auto Imports ------
import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

}
